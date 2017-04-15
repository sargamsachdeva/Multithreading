package com.assignment.multithreading;

public class ReverseHello extends Thread {

    int counter;

    public static void main(String[] arg){

        ReverseHello hello = new ReverseHello(1);
        hello.start();
    }


    public ReverseHello(int counter){
        this.counter=counter;
    }


    public void run() {

        if(counter < 10)
        {
            createThread(counter+1);
        }
        System.out.println("hello" + counter);
    }


    public void createThread(int counter) {

        ReverseHello hello=new ReverseHello(counter);
        hello.start();

        try {
            hello.join();
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }

}
