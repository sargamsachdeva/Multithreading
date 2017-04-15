package com.assignment.multithreading;


public class PatternQues9 extends Thread{

    int c;
    static int count;

    public static void main(String[] args) {

        int n=4;
        for(int i=1;i<=n;i++) {

            PatternQues9 patternQues9 = new PatternQues9(i,n);
            patternQues9.start();
        }

    }

    public static void print(int c,PatternQues9 pattern) {

        for(int i =c; i<=10; i=i+count) {

            System.out.println("Thread: "+pattern.getName() +":"+i);
        }
    }

    public PatternQues9(int c,int count) {

        this.c=c;
        this.count=count;

    }

    public void run() {

        print(c,(PatternQues9) Thread.currentThread());
    }
}


