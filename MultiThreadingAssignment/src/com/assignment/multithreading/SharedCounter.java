package com.assignment.multithreading;

class SharedCounter implements Runnable {

    volatile int counter ;

    public SharedCounter(int counter) {

        this.counter=counter;
    }

    public void run() {

        System.out.println("Doing a task when counter is : " + counter);

        for(int i1=1;i1<=1000;i1++)
            increment();

        System.out.println("Counter: "+counter);
    }


    public synchronized void increment() {

        int temp = counter;
        temp = temp + 1;
        counter = temp;
    }
}

