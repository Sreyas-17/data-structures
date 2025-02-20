package com.bridgelabz.sorting;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr={99,91,98,78,84,79,68,83};
        for(int i=0;i<arr.length-1;i++) {
            int smallestIndex=i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[smallestIndex]) {
                    smallestIndex = j;
                }
            }
            int temp=arr[i];
            arr[i]=arr[smallestIndex];
            arr[smallestIndex]=temp;
        }
        System.out.println("Sorted array");
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}
