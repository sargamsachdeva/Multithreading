package com.assignment.multithreading;

class OddEvenThread implements Runnable{

    private boolean evenFlag = false;

    public static void main(String[] args) {

        OddEvenThread t1 = new OddEvenThread();
        Thread td1 = new Thread(t1);
        Thread td2 = new Thread(t1);
        td1.start();
        td2.start();

    }

    public void run() {

        if (evenFlag == false) {
            printEven();
        } else {
            printOdd();
        }
    }


    public void printEven() {

        for (int i = 0; i <= 20; i += 2) {

            synchronized (this) {

                while (evenFlag) {

                    try {
                        this.wait();
                    } catch (InterruptedException e) {}
                }

                System.out.println(i + " " + Thread.currentThread().getName());
                evenFlag = true;
                this.notify();
            }
        }
    }


    public void printOdd() {

        for (int i = 1; i <= 19; i += 2) {

            synchronized (this) {

                while (!evenFlag) {

                    try {
                        this.wait();
                    } catch (InterruptedException e) {}
                }

                System.out.println(i + " " + Thread.currentThread().getName());
                evenFlag = false;
                this.notify();
            }
        }
    }
}