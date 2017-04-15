package com.assignment.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class PubSubUsingQueue {

    private BlockingQueue<String> queue = new LinkedBlockingQueue<String>(4);
    List<String> list = new ArrayList<>();


    public static void main(String[] args) {

        PubSubUsingQueue queue = new PubSubUsingQueue();

        queue.list.add("1");
        queue.list.add("2");

        Thread t = new Thread(() -> queue.publisher());
        t.start();
        Thread t1 = new Thread(() -> queue.subscriber());
        t1.start();
    }


    public void subscriber() {

        for (int i = 0; i < 5; i++) {

            try {

                for (String e: list) {
                    queue.remove(e);
                }

            } catch (Exception e) {}


            System.out.println(i + ". Message subscribed..." +queue);
        }
    }


    public void publisher() {

        for (int i = 0; i < 5; i++) {

            try {

                for (String e: list)
                    queue.put(e);


            } catch (Exception e) {}

            System.out.println(i + ". Message published..." +queue);
        }
    }
}
