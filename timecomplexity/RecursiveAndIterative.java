package com.bridgelabz.timecomplexity;

public class RecursiveAndIterative {

    public static int fibonacciRecursive(int n) {

        if (n <= 1)
            return n;

        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciIterative(int n) {

        int a = 0, b = 1, sum;

        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        fibonacciRecursive(25);
        long endTime = System.nanoTime();
        System.out.println("Time taken by recursion: " + (endTime - startTime));

        startTime = System.nanoTime();
        fibonacciIterative(25);
        endTime = System.nanoTime();
        System.out.println("Time taken by iterative: " + (endTime - startTime));
    }

}
