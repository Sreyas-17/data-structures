package com.bridgelabz.stackqueuehash;

import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) {
        int[] price={100,80,60,70,65,90,120};
        int[] span=new int[price.length];
        Stack<Integer> stack=new Stack<>();
        span[0]=0;
        stack.push(0);
        for(int i=1;i<price.length;i++){
            while(!stack.isEmpty() && price[i]>price[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                span[i]=i;
            }
            else{
                span[i]=i-stack.peek()-1;
            }
            stack.push(i);
        }
        for (int j : span) {
            System.out.println(j);
        }
    }
}
