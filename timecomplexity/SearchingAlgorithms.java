package com.bridgelabz.timecomplexity;

public class SearchingAlgorithms {
    public static void linearSearch(int[] arr, int target) {
        long startTime = System.nanoTime();
        long endTime;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                break;
            }
        }
        endTime = System.nanoTime();

        System.out.println("linear search time required: " + (endTime- startTime));
    }

    public static void binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        long startTime = System.nanoTime();
        long endTime;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                break;
            }
            else if (arr[mid] < target) {
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        endTime = System.nanoTime();
        System.out.println("binary search time required: " + (endTime- startTime));
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,5,7,8,9};

        linearSearch(arr,9);
        binarySearch(arr,9);
    }
}
