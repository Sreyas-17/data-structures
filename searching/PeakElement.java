package com.bridgelabz.searching;

public class PeakElement {
    public static int binarySearch(int[] arr) {

        int left=0;
        int right=arr.length-1;

        while(left<=right) {
            int mid=(left+right)/2;
            if(arr[mid]>arr[mid+1] && arr[mid]>arr[mid-1]) {
                return arr[mid];
            }
            else if(arr[mid]<arr[mid-1]) {
                right=mid-1;
            }
            else if(arr[mid]<arr[mid+1]) {
                left=mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {

        int[] arr={20,1,3,4,6,5};
        System.out.println(binarySearch(arr));
    }
}
