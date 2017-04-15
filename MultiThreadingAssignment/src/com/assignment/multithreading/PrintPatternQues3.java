package com.assignment.multithreading;

public class PrintPatternQues3 {

    static int number=4;
    int temp=2;

    public void print1(int number){

        for (int i = 1; i < number+1; i++) {

            synchronized (this){
                try {
                    while (temp == 1 && temp == 3)
                        this.wait();

                    System.out.println(Thread.currentThread().getName() +" " +i);
                    temp = 2;
                    this.notifyAll();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void print2(int number){
        for (int i = 1; i < number+1; i++) {
            synchronized (this){
                try {
                    while (temp == 2 && temp == 1)
                        this.wait();
                    System.out.println(Thread.currentThread().getName() +" " +i);
                    temp = 3;
                    this.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void print3(int number){
        for (int i = 1; i < number+1; i++) {
            synchronized (this){
                try {
                    while (temp == 3 && temp == 2)
                        this.wait();
                    System.out.println(Thread.currentThread().getName() +" " +i);
                    temp = 1;
                    this.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {

        PrintPatternQues3 test = new PrintPatternQues3();
        new Thread( ()-> test.print1(test.number)).start();
        new Thread( ()-> test.print2(test.number)).start();
        new Thread( ()-> test.print3(test.number)).start();
    }
}
