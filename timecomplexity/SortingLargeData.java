package com.bridgelabz.timecomplexity;

public class SortingLargeData {
    public static void bubbleSort(int[] arr) {
        long startTime = System.nanoTime();

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        long endTime = System.nanoTime();
        System.out.println("Bubble Sort Time: " + (endTime - startTime));
    }
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
        int[] arr = {3,2,5,1,9,7,6,4};
        bubbleSort(arr);

        long startTime = System.nanoTime();
        mergeSort(arr,0,arr.length-1);
        long endTime = System.nanoTime();
        System.out.println("Merge Sort Time: " + (endTime - startTime));

        startTime = System.nanoTime();
        quickSort(arr,0,arr.length-1);
        endTime = System.nanoTime();
        System.out.println("Quick Sort Time: " + (endTime - startTime));
    }
}
