package com.bridgelabz.linkedlist;

class Ticket{
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTimme;
    Ticket next;
    Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTimme){
        this.ticketId=ticketId;
        this.customerName=customerName;
        this.movieName=movieName;
        this.seatNumber=seatNumber;
        this.bookingTimme=bookingTimme;
        this.next=null;
    }
}
public class OnlineTicketReservationSystem {
    static Ticket head=null;
    static Ticket tail=null;
    public static void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTimme){
        Ticket newNode=new Ticket(ticketId,customerName,movieName,seatNumber,bookingTimme);
        if(head==null){
            head=newNode;
            tail=newNode;
            tail.next=head;
        }
        else{
            tail.next=newNode;
            tail=newNode;
            tail.next=head;
        }
    }
    public static void removeTicket(int ticketId){
        if(head==null){
            System.out.println("Invalid");
            return;
        }
        if(head.ticketId==ticketId){
            if(head==tail){
                head=null;
                tail=null;
            }
            else {
                head=head.next;
                tail.next=head;
            }
            return;
        }
        Ticket current=head;
        while(current.next!=head && current.next.ticketId!=ticketId){
            current=current.next;
        }
        if(current.next==head){
            System.out.println("Ticket not found");
            return;
        }
        if(current.next==tail){
            tail=current;
            tail.next=head;
        }
        else{
            current.next=current.next.next;
        }
    }

    public static void displayTicket(){
        if(head==null){
            System.out.println("Ticket list is empty.");
            return;
        }
        Ticket current=head;
        System.out.println("\nTickets booked are: ");
        do{
            System.out.print("["+current.ticketId+","+current.customerName+","+current.movieName+","+current.seatNumber+","+current.bookingTimme+"] -> ");
            current=current.next;
        }while(current!=head);
        System.out.println("head");
    }

    public static void searchTicket(String movieName) {
        if (head == null) {
            System.out.println("Ticket list is empty.");
            return;
        }
        Ticket current = head;
        boolean found = false;
        do {
            if (current.movieName.equals(movieName)) {
                System.out.println("\nTicket details of the movie is found");
                System.out.println("[" + current.ticketId + "," + current.customerName + "," + current.movieName + "," + current.seatNumber + "," + current.bookingTimme + "]");
                found = true;
            }
            current = current.next;
        } while (current != head);
        if(!found){
            System.out.println("\nMovie not found");
        }
    }

    public static void countBookedTickets(){
        if(head==null){
            System.out.println("Ticket list is empty.");
            return;
        }
        Ticket current=head;
        int count=0;
        do{
            if(current.customerName!=null){
                count++;
            }
            current=current.next;
        }while(current!=head);
        System.out.println("\nTotal number of booked tickets is "+count);
    }
    public static void main(String[] args) {
        addTicket(101, "Ravi", "Dark Knight", "A1", "10:30 AM");
        addTicket(102, "Suresh", "Dark Knight", "A2", "10:40 AM");
        addTicket(103, "Manish", "Dark Knight", "A3", "10:50 AM");
        addTicket(104, "Sai", "Dark Knight", "A4", "11:00 AM");
        displayTicket();
        searchTicket("Dark Knight");
        removeTicket(102);
        System.out.println("\nDisplay the list after removing a ticket");
        displayTicket();
        countBookedTickets();
    }
}