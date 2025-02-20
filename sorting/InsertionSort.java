package com.bridgelabz.sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int[] ids={2,5,1,3,8,34,9};
        for(int i=1;i<ids.length;i++){
            int temp=ids[i];
            int j=i-1;
            while(j>=0 && ids[j]>temp){
                ids[j+1]=ids[j];
                j--;
            }
            ids[j+1]=temp;
        }
        for(int i=0;i<ids.length;i++){
            System.out.print(ids[i]+" ");
        }
    }
}
