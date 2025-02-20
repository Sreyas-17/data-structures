package com.bridgelabz.sorting;
import java.util.Arrays;
public class CountingSort {
    public static void main(String[] args) {
        int[] arr = { 10,12,11,11,17,13,14,17,18,19,16};
        int[] count = new int[Arrays.stream(arr).max().getAsInt()+1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]+=1;
        }
        for (int i = 0; i < count.length; i++) {
            System.out.print(count[i]+" ");
        }
        int[] sortedArr=new int[arr.length];
        int j=0,k=0;
        for (int i = 0; i < count.length; i++) {
            if(count[i]>0){
                while(j++<count[i]){
                    sortedArr[k++]=i;
                }
                j=0;
            }
        }
        System.out.println();
        for(int i=0;i<sortedArr.length;i++){
            System.out.print(sortedArr[i]+" ");
        }
    }
}
