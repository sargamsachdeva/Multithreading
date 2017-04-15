package com.assignment.multithreading;

public class ArrayAdditionQues5 extends Thread {
    private int[] arr;

    private int low, high, partial;

    public ArrayAdditionQues5(int[] arr, int low, int high) {
        this.arr = arr;
        this.low = low;
        this.high = Math.min(high, arr.length);
    }

    public int getPartialSum() {
        return partial;
    }

    public void run() {
        partial = sum(arr, low, high);
    }

    public static int sum(int[] arr) {
        return sum(arr, 0, arr.length);
    }

    public static int sum(int[] arr, int low, int high) {
        int total = 0;

        for (int i = low; i < high; i++) {
            total += arr[i];
        }

        return total;
    }

    public static int ConcurrentSum(int[] arr, int threads) {
        int size = (int) Math.ceil(arr.length * 1.0 / threads);

        ArrayAdditionQues5[] sums = new ArrayAdditionQues5[threads];

        for (int i = 0; i < threads; i++) {
            sums[i] = new ArrayAdditionQues5(arr, i * size, (i + 1) * size);
            sums[i].start();
        }

        try {
            for (ArrayAdditionQues5 sum : sums) {
                sum.join();
            }
        } catch (InterruptedException e) { }

        int total = 0;

        for (ArrayAdditionQues5 sum : sums) {
            total += sum.getPartialSum();
        }

        return total;
    }
}