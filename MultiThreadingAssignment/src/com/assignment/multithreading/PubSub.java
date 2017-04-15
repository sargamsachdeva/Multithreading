package com.assignment.multithreading;

import java.util.ArrayList;
import java.util.List;

public class PubSub {

    private List<Integer> list =new ArrayList<>();

    public static void main(String[] args) {

        PubSub pubSub=new PubSub();

        Thread t = new Thread(() -> pubSub.publisher());
        t.start();
        Thread t1=new Thread(() -> pubSub.subscriber());
        t1.start();
    }


    public void subscriber() {

        for(int i = 0; i < 5; i++){

            synchronized (this) {
                try {
                    while(list.isEmpty()){
                        this.wait();
                    }

                    System.out.println(i+". List subscribed...."+list);
                    list.removeAll(list);

                    System.out.println(i+". Making list empty...."+list);
                    this.notify();

                } catch (InterruptedException e) {}
            }
        }
    }


    public void publisher() {

        for(int i = 0; i < 5; i++){

            synchronized (this) {
                try {
                    while(!list.isEmpty()){
                        this.wait();
                    }

                    list.add(1);
                    list.add(2);
                    list.add(3);
                    list.add(4);

                    System.out.println(i+". List published...."+list);
                    this.notify();

                } catch (InterruptedException e) {}
            }
        }
    }
}
