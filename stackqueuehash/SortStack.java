package com.bridgelabz.stackqueuehash;

import java.util.Stack;

public class SortStack {
    public static void sortStack(Stack<Integer> stack){
        int top;
        if(!stack.isEmpty()){
            top=stack.pop();
            sortStack(stack);
            insert(stack,top);
        }
    }
    public static void insert(Stack<Integer> stack, int data){
        if(stack.isEmpty()||data>=stack.peek()){
            stack.push(data);
        }
        else{
            int temp=stack.pop();
            insert(stack,data);
            stack.push(temp);
        }
    }
    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        stack.push(30);
        stack.push(10);
        stack.push(20);
        stack.push(40);
        stack.push(35);
        stack.push(50);
        sortStack(stack);
        System.out.println("Sorted Stack: ");
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
