package com.assignment.multithreading;

import java.util.Random;

public class MainApp {

    public static final int THREADS = 4;

    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(101) + 1;
        }

        for (int a: arr) {
            System.out.print(a + ", ");
        }
        System.out.println();
        System.out.println("Max value is: "+ ArrayMaxValueQues6.ConcurrentMax(arr, THREADS));
    }
}