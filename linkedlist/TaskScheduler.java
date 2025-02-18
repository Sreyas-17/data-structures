package com.bridgelabz.linkedlist;
class Task {
    String taskId;
    int priority;
    String taskName;
    String dueDate;
    Task next;

    Task(String taskId, int priority, String taskName, String dueDate) {
        this.taskId = taskId;
        this.priority = priority;
        this.taskName = taskName;
        this.dueDate = dueDate;
        this.next=null;
    }
}
public class TaskScheduler {
    static Task head = null;
    static Task tail = null;
    public static void addAtBeginning(String taskId, int priority, String taskName, String dueDate) {
        Task newNode = new Task(taskId, priority, taskName, dueDate);
        if (head == null) {
            head = newNode;
            tail=head;
            tail.next=head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next=head;
        }
    }
    public static void addAtEnd(String taskId, int priority, String taskName, String dueDate) {
        Task newNode = new Task(taskId, priority, taskName, dueDate);
        if (head == null) {
            head = newNode;
            tail=head;
            tail.next=head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next=head;
        }
    }
    public static void addAtPosition(String taskId, int priority, String taskName, String dueDate, int position) {
        Task newNode = new Task(taskId, priority, taskName, dueDate);
        position-=1;
        if (position == 0) {
            addAtBeginning(taskId, priority, taskName, dueDate);
            return;
        }
        Task current = head;
        int i = 1;
        while (current != null && i < position - 1) {
            current = current.next;
            i++;
        }
        if (current == null||current.next==head) {
            addAtEnd(taskId, priority, taskName, dueDate);
            return;
        }
        newNode.next = current.next;
        current.next = newNode;
    }
    public static void removeNode(String taskId){
        if(head==null){
            System.out.println("Invalid");
            return;
        }
        if(head.taskId.equals(taskId)){
            if(head==tail){
                head=null;
                tail=null;
            }
            else{
                head=head.next;
                tail.next=head;
            }
            return;
        }
        Task current=head;
        while(current.next!=head && !current.next.taskId.equals(taskId)){
            current=current.next;
        }
        if (current.next == head) {
            System.out.println("Task not found.");
            return;
        }
        if(current.next==tail){
            tail=current;
            tail.next=head;
        }
        current.next=current.next.next;
    }
    public static void displayCurrentAndNext(int position){
        Task current=head;
        int index=position-1,i=0;
        while(i<index){
            if (current.next == head) {
                System.out.println("Invalid position");
                return;
            }
            current=current.next;
            i++;
        }
        System.out.print("\n["+current.taskId+","+current.priority+","+current.taskName+","+current.dueDate+"] ->");
        current = current.next;
        System.out.println("["+current.taskId+","+current.priority+","+current.taskName+","+current.dueDate+"]");
    }
    public static void displayAll(){
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }
        Task current=head;
        System.out.print("["+current.taskId+","+current.priority+","+current.taskName+","+current.dueDate+"] ->");
        current=current.next;
        while(current!=head){
            System.out.print("["+current.taskId+","+current.priority+","+current.taskName+","+current.dueDate+"] ->");
            current=current.next;
        }
        System.out.println("head");
    }
    public static void searchNode(int priority){
        Task current=head;
        boolean found=false;
        do{
            if(current.priority==priority){
                System.out.println("\nTask details of the priority "+ priority +" is found");
                System.out.println("["+current.taskId+","+current.priority+","+current.taskName+","+current.dueDate+"]");
                found=true;
            }
            current=current.next;
        }while(current!=head);
        if(!found){
            System.out.println("\nNot found");
        }
    }
    public static void main(String[] args) {
        addAtBeginning("T101", 1, "Task1", "2018-01-01");
        addAtBeginning("T102", 2, "Task2", "2018-01-02");
        addAtEnd("T104", 3, "Task4", "2018-01-04");
        addAtEnd("T105", 4, "Task5", "2018-01-05");
        addAtPosition("T106", 5, "Task6", "2018-01-06", 2);
        displayAll();
        searchNode(4);
        removeNode("T102");
        System.out.println("\nDisplay the list after removing a node");
        displayAll();
        displayCurrentAndNext(3);
    }
}
