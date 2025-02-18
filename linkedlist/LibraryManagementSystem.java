package com.bridgelabz.linkedlist;

class Library{
    String title;
    String author;
    String genre;
    String id;
    boolean availabilityStatus;
    Library next;
    Library prev;

    Library(String title, String author, String genre, String id, boolean availabilityStatus){
        this.title=title;
        this.author=author;
        this.genre=genre;
        this.id=id;
        this.availabilityStatus=availabilityStatus;
        this.next=null;
        this.prev=null;
    }
}
public class LibraryManagementSystem {
    static Library head=null;
    static Library tail=null;
    public static void addAtBeginning(String title, String author, String genre, String id, boolean availabilityStatus){
        Library newNode=new Library(title, author, genre, id, availabilityStatus);
        if(head==null){
            head=newNode;
            tail=head;
        }
        else{
            head.prev=newNode;
            newNode.next=head;
            head=newNode;
        }
    }
    public static void addAtEnd(String title, String author, String genre, String id, boolean availabilityStatus){
        Library newNode=new Library(title, author, genre, id, availabilityStatus);
        if(tail==null){
            tail=newNode;
            head=tail;
        }
        else{
            tail.next=newNode;
            newNode.prev=tail;
            tail=newNode;
        }
    }
    public static void addAtPosition(String title, String author, String genre, String id, boolean availabilityStatus, int position){
        if (position == 0) {
            addAtBeginning(title,author,genre,id,availabilityStatus);
            return;
        }
        Library newNode=new Library(title, author, genre, id, availabilityStatus);
        Library current=head;
        int i=1;
        while(current!=null && i<position-1){
            current=current.next;
            i++;
        }
        if(current==null){
            addAtEnd(title,author,genre,id,availabilityStatus);
            return;
        }
        newNode.next=current.next;
        current.next.prev=newNode;
        current.next=newNode;
        newNode.prev=current;
    }
    public static void removeNode(String id){
        Library current=head;
        if(head==null){
            System.out.println("Invalid");
            return;
        }
        if(head.id.equals(id)){
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
        while(current.next!=null && !current.next.id.equals(id)){
            current=current.next;
        }
        if(current.next==null){
            System.out.println("Book not found");
            return;
        }
        if(current.next==tail){
            tail=current;
            tail.next=null;
        }
        else{
            current.next=current.next.next;
            if(current.next.next!=null)
                current.next.prev=current;
        }
    }
    public static void updateAvailabilityStatus(String id, boolean availabilityStatus){
        Library current=head;
        boolean found=false;
        while(current!=null){
            if(current.id.equals(id)){
                current.availabilityStatus=availabilityStatus;
                found=true;
            }
            current=current.next;
        }
        if(!found){
            System.out.println("\nBook not found");
        }
    }
    public static void displayInForward(){
        Library current=head;
        while(current!=null){
            System.out.print("["+current.title+","+current.author+","+current.genre+","+current.id+","+current.availabilityStatus+"] <-> ");
            current=current.next;
        }
        System.out.println("null");
    }
    public static void displayInReverse(){
        Library current=tail;
        while(current!=null){
            System.out.print("["+current.title+","+current.author+","+current.genre+","+current.id+","+current.availabilityStatus+"] <-> ");
            current=current.prev;
        }
        System.out.println("null");
    }
    public static void countBooks(){
        Library current=head;
        int count=0;
        while(current!=null){
            count++;
            current=current.next;
        }
        System.out.println("\nTotal number of books in the library is: "+count);
    }
    public static void main(String[] args) {
        addAtBeginning("Book 1", "Author 1", "Genre 1", "1", true);
        addAtEnd("Book 2", "Author 2", "Genre 2", "2", true);
        addAtEnd("Book 3", "Author 3", "Genre 3", "3", false);
        addAtPosition("Book 4", "Author 4", "Genre 4", "4", true, 1);
        addAtPosition("Book 5", "Author 5", "Genre 5", "5", false, 2);
        // Display books
        System.out.println("Books in forward order:");
        displayInForward();

        // Display books in reverse order
        System.out.println("\nBooks in reverse order:");
        displayInReverse();

        // Update availability status
        updateAvailabilityStatus("2", false);
        System.out.println("\nUpdated availability for Book 2:");
        displayInForward();

        // Remove a book
        System.out.println("\nAfter removing Book with id 1:");
        removeNode("1");
        displayInForward();

        // Count books
        countBooks();
    }
}