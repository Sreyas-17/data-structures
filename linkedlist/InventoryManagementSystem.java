package com.bridgelabz.linkedlist;

class Product{
    String itemName;
    int itemId;
    int quantity;
    double price;
    Product next;
    Product(String itemName, int itemId, int quantity, double price){
        this.itemName=itemName;
        this.itemId=itemId;
        this.quantity=quantity;
        this.price=price;
        this.next=null;
    }
}
public class InventoryManagementSystem {
    static Product head=null;
    static Product tail=null;
    public static void addAtBeginning(String itemName, int itemId, int quantity, double price) {
        Product newNode = new Product(itemName, itemId, quantity, price);
        if(head==null){
            head=newNode;
            tail=head;
        }
        else{
            newNode.next=head;
            head=newNode;
        }
    }
    public static void addAtEnd(String itemName, int itemId, int quantity, double price){
        Product newNode=new Product(itemName,itemId,quantity,price);
        if(head==null){
            head=newNode;
            tail=head;
        }
        else{
            tail.next=newNode;
            tail=newNode;
        }
    }
    public static void addAtPosition(String itemName, int itemId, int quantity, double price, int position){
        Product newNode=new Product(itemName,itemId,quantity,price);
        Product current=head;
        if(position==0){
            addAtBeginning(itemName,itemId,quantity,price);
        }
        int i=1;
        while(current!=null && i<position-1){
            current=current.next;
            i++;
        }
        if(current==null){
            addAtEnd(itemName,itemId,quantity,price);
        }
        else{
            newNode.next=current.next;
            current.next=newNode;
            if(newNode.next==null){
                tail=newNode;
            }
        }
    }
    public static void removeNode(String itemName){
        if(head==null){
            System.out.println("Invalid");
            return;
        }
        if(head.itemName.equals(itemName)){
            if(head==tail){
                head=null;
                tail=null;
            }
            else{
                head=head.next;
            }
            return;
        }
        Product current=head;
        while(current.next!=null && !current.next.itemName.equals(itemName)){
            current=current.next;
        }
        if(current.next==null){
            System.out.println("Item not found");
            return;
        }
        if(current.next==tail){
            tail=current;
        }
        current.next=current.next.next;
    }
    public static void searchNode(int itemId){
        if(head==null){
            System.out.println("Invalid");
            return;
        }
        Product current=head;
        boolean found=false;
        while(current!=null){
            if(current.itemId==itemId){
                System.out.println("\nItem details of the item id "+itemId+" is found");
                System.out.println("["+current.itemName+","+current.itemId+","+current.quantity+","+current.price+"]");
                found=true;
            }
            current=current.next;
        }
        if(!found){
            System.out.println("Not found");
        }
    }
    public static void displayPrice(){
        if(head==null){
            System.out.println("Inventory list is empty.");
            return;
        }
        Product current=head;
        current=current.next;
        double priceOfItem,total=0;
        while(current!=null){
            priceOfItem=current.price*current.quantity;
            System.out.println("Total price of item Id "+current.itemId+" is: "+priceOfItem);
            total+=priceOfItem;
            current=current.next;
        }
        System.out.println("\nTotal price of all items is: "+total);
    }
    public static void mergeSort(){
        if(head==null){
            System.out.println("Inventory list is empty.");
            return;
        }
        head=mergeSort(head);
    }
    private static Product mergeSort(Product node) {
        if (node == null || node.next == null) {
            return node;
        }
        Product middle = split(node);
        Product middleNext = middle.next;
        middle.next = null;
        Product left = mergeSort(node);
        Product right = mergeSort(middleNext);
        return merge(left, right);
    }
    private static Product split(Product node) {
        Product slow = node;
        Product fast = node;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private static Product merge(Product left, Product right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        if (left.price <= right.price) {
            left.next = merge(left.next, right);
            return left;
        } else {
            right.next = merge(left, right.next);
            return right;
        }
    }


    public static void displayAll(){
        if(head==null){
            System.out.println("Inventory list is empty.");
            return;
        }
        Product current=head;
        while(current!=null) {
            System.out.print("[" + current.itemName + "," + current.itemId + "," + current.quantity + "," + current.price + "] ->");
            current = current.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        addAtBeginning("phone",1,5,70000);
        addAtBeginning("TV",2,2,60000);
        addAtEnd("Refrigerator",4,1,20000);
        addAtEnd("Chair",5,3,500);
        addAtPosition("Cup",6,10,50,2);
        addAtPosition("Mouse",7,4,700,3);
        displayAll();
        System.out.println("\nDisplay the bill");
        displayPrice();
        searchNode(3);
        removeNode("TV");
        System.out.println("\nDisplay the list after removing a node");
        displayAll();

        mergeSort();
        System.out.println("\nSorted Inventory in ascending order of price:");
        displayAll();
    }
}