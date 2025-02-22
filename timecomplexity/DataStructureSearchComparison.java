package com.bridgelabz.timecomplexity;

import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class DataStructureSearchComparison {

    public static long searchInArray(int[] arr, int target, int iterations) {

        long totalTime = 0;

        for (int j = 0; j < iterations; j++) {
            long startTime = System.nanoTime();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == target) {
                    break;
                }
            }
            long endTime = System.nanoTime();
            totalTime += (endTime - startTime);
        }

        return totalTime / iterations;
    }

    public static long searchInHashSet(HashSet<Integer> set, int target, int iterations) {

        long totalTime = 0;

        for (int j = 0; j < iterations; j++) {
            long startTime = System.nanoTime();
            set.contains(target);
            long endTime = System.nanoTime();
            totalTime += (endTime - startTime);
        }

        return totalTime / iterations;
    }

    public static long searchInTreeSet(TreeSet<Integer> set, int target, int iterations) {

        long totalTime = 0;

        for (int j = 0; j < iterations; j++) {
            long startTime = System.nanoTime();
            set.contains(target);
            long endTime = System.nanoTime();
            totalTime += (endTime - startTime);
        }

        return totalTime / iterations;
    }

    public static void main(String[] args) {
        int size = 1000;
        int[] arr = new int[size];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(10_000);
            hashSet.add(arr[i]);
            treeSet.add(arr[i]);
        }

        int target = arr[970];

        int iterations = 1000;

        System.out.println("Array Search Time: " + searchInArray(arr, target, iterations));
        System.out.println("HashSet Search Time: " + searchInHashSet(hashSet, target, iterations));
        System.out.println("TreeSet Search Time: " + searchInTreeSet(treeSet, target, iterations));
    }
}
