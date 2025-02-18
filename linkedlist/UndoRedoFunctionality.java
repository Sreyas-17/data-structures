package com.bridgelabz.linkedlist;

import java.util.ArrayList;

class Node{
    int data;
    Node next;
    Node prev;
    Node(int data){
        this.data=data;
        this.next=null;
        this.prev=null;
    }
}
public class UndoRedoFunctionality {
    static Node head=null;
    static Node tail=null;
    static ArrayList<Integer> state=new ArrayList<>();
    public static void addNode(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            tail=head;
        }
        else{
            tail.next=newNode;
            newNode.prev=tail;
            tail=newNode;
        }
    }
    public static void undo(){
        if(state.size()==10) {
            state.removeFirst();
        }
        if(head==null){
            System.out.println("No undo operation possible");
            return;
        }

        state.add(tail.data);
        tail=tail.prev;
        tail.next=null;

    }
    public static void redo(){
        if(state.isEmpty()){
            System.out.println("No redo operation possible because history storage is 10");
            return;
        }

        if(head==null){
            addNode(state.getLast());
            state.removeLast();
        }
        else{
            Node newNode=new Node(state.getLast());
            if(head.next==null){
                head.next=newNode;
                newNode.prev=head;

            }
            else{
                tail.next=newNode;
                newNode.prev=tail;
            }
            tail=newNode;
            state.removeLast();
        }

    }
    public static void display(){
        Node current=head;
        System.out.println();
        while(current!=null){
            System.out.print(current.data+"->");
            current=current.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        addNode(1);
        addNode(2);
        addNode(3);
        addNode(4);
        addNode(5);
        addNode(6);
        addNode(7);
        addNode(8);
        addNode(9);
        addNode(10);
        addNode(11);
        addNode(12);
        addNode(13);
        addNode(14);
        addNode(15);
        display();
        undo();
        undo();
        undo();
        undo();
        undo();
        undo();
        undo();
        undo();
        undo();
        undo();
        undo();
        undo();
        undo();
        undo();
        System.out.print("\nAfter 14 undo operation");
        display();
        System.out.println();
        redo();
        redo();
        redo();
        redo();
        redo();
        redo();
        redo();
        redo();
        redo();
        redo();
        redo();
        redo();
        redo();
        System.out.print("\nAfter 14 redo operation");
        display();
    }
}