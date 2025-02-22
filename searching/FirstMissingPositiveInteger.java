package com.bridgelabz.searching;

import java.util.Scanner;

public class FirstMissingPositiveInteger {
    public static void binarySearch(int[] arr,int target) {

        int left=0;
        int right=arr.length-1;
        int result=-1;

        while(left<=right) {
            int mid=(left+right)/2;
            if(arr[mid]==target) {
                result=mid;
                break;
            }
            else if(arr[mid]>target) {
                right=mid-1;
            }
            else if(arr[mid]<target) {
                left=mid+1;
            }
        }
        System.out.println("The target index is "+result);
    }

    public static void linearSearch(int[] arr) {
        boolean found=false;

        for(int i=1;i< arr.length;i++) {
            if(arr[i]!=arr[i-1]+1) {
                System.out.println("The first missing positive integer at index is "+i);
                System.out.println("Missing positive integer value "+(arr[i-1]+1));
                found=true;
                break;
            }
        }

        if(!found) {
            System.out.println("There is no missing element in the array");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr={1,3,4,5,7,9,10};
        System.out.println("Enter the target");
        int target = scanner.nextInt();

        binarySearch(arr,target);
        linearSearch(new int[]{12,13,14,16,5,6,8,9});
    }
}
