package com.assignment.multithreading;

import java.util.Random;

public class Main {

    public static final int THREADS = 4;

    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(101) + 1; // 1..100
        }

        for (int a: arr) {
            System.out.print(a + ", ");
        }
        System.out.println();
        System.out.println("Sum is: "+ArrayAdditionQues5.ConcurrentSum(arr, THREADS));
    }
}