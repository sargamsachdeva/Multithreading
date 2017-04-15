package com.assignment.multithreading;

public class Exercise2 {


    static boolean isPrimeExec=false;


    public void printNonPrime() {


        for (int i = 0; i <20 ; i++)
            {


                synchronized (this)
                {

                    while (!isPrimeExec)
                {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                    if(i==4||i==6||i==8||i==9||i==10||i==12||i==14||i==15||i==16||i==18||i==20)
                    {
                        System.out.println("NonPrime :"+i);
                        isPrimeExec=false;
                        this.notify();
                    }
                    else
                    {
                        isPrimeExec=false;
                        this.notify();
                    }

            }

        }
    }

    public void printprime()
    {


        for (int i = 0; i <20 ; i++)
        {


            synchronized (this)
            {
                while (isPrimeExec)
                {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if(i==2||i==3||i==5||i==7||i==11||i==13||i==17||i==19)
                {
                    System.out.println("Prime :"+i);
                    isPrimeExec=true;
                    this.notify();
                }
                else
                {
                    isPrimeExec=true;
                    this.notify();
                }




            }

        }
    }

    public static void main(String[] args) {


        Exercise2 ex = new Exercise2();

        Thread thread = new Thread(()->{ ex.printNonPrime();});

        Thread thread1 = new Thread(()->{ex.printprime();});

        thread.start();
        thread1.start();

        try {
            thread.join();
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }




    }






}
