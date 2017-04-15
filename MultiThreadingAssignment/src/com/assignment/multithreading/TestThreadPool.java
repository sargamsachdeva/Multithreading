package com.assignment.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestThreadPool {

    private static final int noOfThreads = 5;
    static Runnable sharedCounter = new SharedCounter(0);

    public static void main(String[] args) throws Exception{

        ExecutorService executor = Executors.newFixedThreadPool(noOfThreads);

        for (int i = 0; i < 2; i++) {

            executor.execute(sharedCounter);
        }

        for (int i = 2; i < 5; i++) {

            executor.execute(sharedCounter);
        }

        executor.shutdown();

        executor.awaitTermination(1000, TimeUnit.SECONDS);
        System.out.println("Finished all threads");
    }

}