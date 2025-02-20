package com.bridgelabz.sorting;

public class QuickSort {
    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);
            quickSort(arr, left, pivot-1);
            quickSort(arr,pivot+1,right);
        }
    }
    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i=left-1,j=left;
        while(j<right && i<j){
            if(arr[j]<pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            j++;
        }
        int temp = arr[i+1];
        arr[i+1] = arr[right];
        arr[right] = temp;
        return i+1;
    }
    public static void main(String[] args) {
        int[] arr = { 200,399,150,175 };
        quickSort(arr, 0, arr.length-1);
        System.out.println("Sorted array");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
