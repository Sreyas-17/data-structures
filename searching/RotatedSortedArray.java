package com.bridgelabz.searching;

public class RotatedSortedArray {
    public static int binarySearch(int[] arr) {

        int left = 0;
        int right = arr.length - 1;
        int high = arr[right];

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > high) {
                left = mid + 1;
            } else if (arr[mid] < high) {
                right = mid;
            }
            else{
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr={9,8,7,6,5,4,3,2,1};
        int result=binarySearch(arr);
        System.out.println("Index of target number: "+result);
    }
}
