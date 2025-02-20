package com.bridgelabz.stackqueuehash;

import java.util.Stack;

public class QueueUsingStack {
    static Stack<Integer> stackOne=new Stack<>();
    static Stack<Integer> stackTwo=new Stack<>();
    public static void enqueue(int data){
        while(!stackOne.isEmpty()){
            stackTwo.push(stackOne.pop());
        }
        stackOne.push(data);
        while(!stackTwo.isEmpty()){
            stackOne.push(stackTwo.pop());
        }
    }
    public static void dequeue(){
        if(stackOne.isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Dequeued: "+stackOne.pop());
    }
    public static void main(String[] args) {
        enqueue(10);
        enqueue(20);
        enqueue(30);
        enqueue(40);
        dequeue();
        dequeue();
        enqueue(50);
        dequeue();
        enqueue(60);
        dequeue();
    }
}
