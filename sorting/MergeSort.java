package com.bridgelabz.sorting;

public class MergeSort {
    public static void mergeSort(int[] arr,int l,int r){
        int mid=(l+r)/2;
        if(l<r){
            mergeSort(arr,l,mid);
            mergeSort(arr,mid+1,r);
            merge(arr,l,mid,r);
        }
    }
    public static void merge(int[] arr, int l, int m, int r){
        int leftSize=m-l+1;
        int rightSize=r-m;
        int[] left=new int[leftSize];
        int[] right=new int[rightSize];
        for(int i=0;i<leftSize;i++){
            left[i]=arr[l+i];
        }
        for(int j=0;j<rightSize;j++){
            right[j]=arr[j+1+m];
        }
        int i=0,j=0,k=l;
        while(i<leftSize && j<rightSize) {
            if (left[i] > right[j]) {
                arr[k] = right[j];
                j++;
                k++;

            }
            else {
                arr[k] = left[i];
                i++;
                k++;

            }
        }
        while(i<leftSize){
            arr[k]=left[i];
            i++;
            k++;
        }
        while(j<rightSize){
            arr[k]=right[j];
            j++;
            k++;
        }

    }
    public static void main(String[] args) {
        int[] arr={900,875,650,950,474,800,750};
        mergeSort(arr,0,arr.length-1);
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}
