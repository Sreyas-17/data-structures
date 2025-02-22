package com.bridgelabz.searching;

import java.util.Scanner;

public class OccurrenceOfAnElement {
    public static void firstOccurrence(int[] arr, int key) {

        int left=0;
        int right=arr.length-1;
        int result=-1;

        while(left<=right) {
            int mid=(left+right)/2;
            if(arr[mid]==key) {
                result=mid;
                right=mid-1;
            }
            else if(arr[mid]>key) {
                right=mid-1;
            }
            else if(arr[mid]<key) {
                left=mid+1;
            }
        }
        System.out.println("First occurrence index is: "+result);
    }

    public static void lastOccurrence(int[] arr, int key) {
        int left=0;
        int right=arr.length-1;
        int result=-1;

        while(left<=right) {
            int mid=(left+right)/2;
            if(arr[mid]==key) {
                result=mid;
                left=mid+1;
            }
            else if(arr[mid]>key) {
                right=mid-1;
            }
            else if(arr[mid]<key) {
                left=mid+1;
            }
        }
        System.out.println("Last occurrence index is: "+result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the element to be searched: ");

        int element = scanner.nextInt();
        int[] arr={1,3,5,6,8,8,8,8,8,9,10};

        firstOccurrence(arr,element);
        lastOccurrence(arr,element);
    }
}
