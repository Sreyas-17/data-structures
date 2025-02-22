package com.bridgelabz.searching;

public class SearchForNegativeNumber {
    public static int linearSearch(int[] arr){

        for(int i=0; i<arr.length; i++){
            if(arr[i]<0){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr={2,3,1,4,-2,-3,2};
        int result=linearSearch(arr);
        System.out.println("First negative number is at index: "+result);
    }
}
