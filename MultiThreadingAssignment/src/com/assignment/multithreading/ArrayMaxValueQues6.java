package com.assignment.multithreading;

public class ArrayMaxValueQues6 extends Thread {
    private int[] arr;

    private int low, high, partialMax;

    public ArrayMaxValueQues6(int[] arr, int low, int high) {
        this.arr = arr;
        this.low = low;
        this.high = Math.min(high, arr.length);
    }

    public int getPartialMax() {
        return partialMax;
    }

    public void run() {
        partialMax = findMax(arr, low, high);
    }

    public static int findMax(int[] arr) {
        return findMax(arr, 0, arr.length);
    }

    public static int findMax(int[] arr, int low, int high) {
        int max = arr[0];

        for (int i = low; i < high; i++) {
            if(max<arr[i]){
                max = arr[i];
            }
        }

        return max;
    }

    public static int ConcurrentMax(int[] arr, int threads) {
        int size = (int) Math.ceil(arr.length * 1.0 / threads);

        ArrayMaxValueQues6[] maximums = new ArrayMaxValueQues6[threads];

        for (int i = 0; i < threads; i++) {
            maximums[i] = new ArrayMaxValueQues6(arr, i * size, (i + 1) * size);
            maximums[i].start();
        }

        try {
            for (ArrayMaxValueQues6 max : maximums) {
                max.join();
            }
        } catch (InterruptedException e) { }

        int max = maximums[0].getPartialMax();

        for (ArrayMaxValueQues6 parMax : maximums) {
            if(max<parMax.getPartialMax()){
                max = parMax.getPartialMax();
            }
        }

        return max;
    }
}