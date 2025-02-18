package com.bridgelabz.linkedlist;

class MovieNode{
    String movieTitle;
    String Director;
    int yearOfRelease;
    double rating;
    MovieNode next;
    MovieNode prev;

    MovieNode(String movieTitle, String Director, int yearOfRelease, double rating){
        this.movieTitle=movieTitle;
        this.Director=Director;
        this.yearOfRelease=yearOfRelease;
        this.rating=rating;
        this.next=null;
        this.prev=null;
    }
}
public class MovieManagementSystem {
    static MovieNode head=null;
    static MovieNode tail=null;
    public static void addNodeAtBeginning(String movieTitle, String Director,int yearOfRelease,double rating){
        MovieNode newNode=new MovieNode(movieTitle,Director,yearOfRelease,rating);
        if(head==null){
            head=newNode;
            tail=head;
        }
        else{
            newNode.next=head;
            head.prev=newNode;
            head=newNode;
        }
    }
    public static void addNodeAtEnd(String movieTitle, String Director,int yearOfRelease,double rating){
        MovieNode newNode=new MovieNode(movieTitle,Director,yearOfRelease,rating);
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
    public static void addNodeAtPosition(String movieTitle, String Director,int yearOfRelease,double rating,int position){
        if (position == 0) {
            addNodeAtBeginning(movieTitle,Director,yearOfRelease,rating);
            return;
        }
        MovieNode newNode=new MovieNode(movieTitle,Director,yearOfRelease,rating);
        MovieNode current=head;
        int i=1;
        while(current!=null && i<position-1){
            current=current.next;
            i++;
        }
        if(current==null){
            addNodeAtEnd(movieTitle,Director,yearOfRelease,rating);
            return;
        }
        newNode.next=current.next;
        if (current.next != null) {
            current.next.prev = newNode;
        }
        current.next=newNode;
        newNode.prev=current;
        if(newNode.next==null){
            tail=newNode;
        }
    }
    public static void removeNodeByData(String movieTitle){
        MovieNode current = head;
        if(head==null){
            System.out.println("Invalid");
            return;
        }
        if(head.movieTitle.equals(movieTitle)){
            if(head==tail){
                head=null;
                tail=null;
            }
            else{
                head=head.next;
                head.prev=null;
            }
            return;
        }
        while(current.next!=null && !current.next.movieTitle.equals(movieTitle)){
            current=current.next;
        }
        if(current.next ==null){
            System.out.println("Movie not found");
            return;
        }
        if(current.next==tail){
            tail=current;
            tail.next = null;
        }
        else {
            current.next = current.next.next;
            if (current.next != null)
                current.next.prev = current;
        }
    }
    public static void searchNode(String director){
        MovieNode current = head;
        boolean found=false;
        while(current!=null) {
            if (current.Director.equals(director)) {
                System.out.println("\nMovie details of the director is found");
                System.out.println("["+current.movieTitle+","+ current.Director+","+current.yearOfRelease+","+current.rating+"]");
                found=true;
            }
            current = current.next;
        }
        if(!found){
            System.out.println("Not found");
        }
    }
    public static void displayInForward(){
        MovieNode current = head;
        while(current!=null){
            System.out.print("["+current.movieTitle+","+ current.Director+","+current.yearOfRelease+","+current.rating+"] <-> ");
            current = current.next;
        }
        System.out.println("null");
    }
    public static void displayInReverse(){
        MovieNode current = tail;
        while(current!=null){
            System.out.print("["+current.movieTitle+","+ current.Director+","+current.yearOfRelease+","+current.rating+"] <-> ");
            current = current.prev;
        }
        System.out.println("null");
    }
    public static void updateNode(String movieTitle,double rating){
        MovieNode current = head;
        boolean found=false;
        while(current!=null ){
            if(current.movieTitle.equals(movieTitle)) {
                current.rating = rating;
                found=true;
            }
            current = current.next;
        }
        if(!found){
            System.out.println("Not found");
        }
    }
    public static void main(String[] args) {
        addNodeAtBeginning("Bahubali","Rajamouli",2015,4.7);
        addNodeAtBeginning("Robo","Shankar",2010,4.5);
        addNodeAtEnd("Pushpa","Sukumar",2024,4.2);
        addNodeAtEnd("DarkKnight","Nolan",2008,5);

        System.out.println("\nDisplay the list in forward direction");
        displayInForward();
        System.out.println("\nDisplay the list in backward direction");
        displayInReverse();

        removeNodeByData("Bahubali");
        System.out.println("\nDisplay the list after removing a node");
        displayInForward();

        searchNode("Nolan");

        updateNode("Robo",4.7);
        System.out.println("\nDisplay the list after updating a node");
        displayInForward();

        addNodeAtPosition("Bahubali","Rajamouli",2015,4.7,0);
        System.out.println("\nDisplay the list after adding a node");
        displayInForward();
    }
}