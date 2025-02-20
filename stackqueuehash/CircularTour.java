package com.bridgelabz.stackqueuehash;

public class CircularTour {
    public static void main(String[] args) {
        int[] gas={1,2,3,4,5};
        int[] cost={3,4,5,1,2};
        int sumOfGas=0,sumOfCost=0,total=0,start=0;
        for(int i=0;i<gas.length;i++){
            sumOfGas+=gas[i];
            sumOfCost+=cost[i];
        }
        if(sumOfGas<sumOfCost){
            System.out.println("No Tour");
            return;
        }
        for(int i=0;i<gas.length;i++){
            total+=(gas[i]-cost[i]);
            if(total<0){
              start=i+1;
              total=0;
            }
        }
        System.out.println("Index: "+start);
    }
}
