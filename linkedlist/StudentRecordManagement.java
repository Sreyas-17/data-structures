package com.bridgelabz.linkedlist;

class StudentNode {
    int rollNumber;
    String name;
    int age;
    char grade;
    StudentNode next;

    // Constructor to initialize a student node
    public StudentNode(int rollNumber, String name, int age, char grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

public class StudentRecordManagement {
    //Head and tail nodes for traversal
    static StudentNode head = null;
    static StudentNode tail = null;

    // Add a student record at the beginning
    public static void addStudentAtBeginning(int rollNumber, String name, int age, char grade) {
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    // Add a student record at the end
    public static void addStudentAtEnd(int rollNumber, String name, int age, char grade) {
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Add a student record at a specific position
    public static void addStudentAtPosition(int rollNumber, String name, int age, char grade, int position) {
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        StudentNode current = head;
        int i = 1;
        while (current != null && i < position - 1) {
            current = current.next;
            i++;
        }

        if (current == null) {
            System.out.println("Invalid position");
            return;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    // Delete a student record by Roll Number
    public static void deleteStudentByRollNumber(int rollNumber) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        // If head node itself holds the roll number to be deleted
        if (head.rollNumber == rollNumber) {
            head = head.next;
            return;
        }

        StudentNode current = head;
        while (current.next != null && current.next.rollNumber != rollNumber) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Student with Roll Number " + rollNumber + " not found.");
        } else {
            current.next = current.next.next;
        }
    }

    // Search for a student record by Roll Number
    public static void searchStudentByRollNumber(int rollNumber) {
        StudentNode current = head;
        while (current != null && current.rollNumber != rollNumber) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("\nStudent with Roll Number " + rollNumber + " not found.");
        } else {
            System.out.println("\nStudent Found: Roll Number: " + current.rollNumber + ", Name: " + current.name
                    + ", Age: " + current.age + ", Grade: " + current.grade);
        }
    }

    // Display all student records
    public static void displayAllStudents() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        StudentNode current = head;
        while (current != null) {
            System.out.println("Roll Number: " + current.rollNumber + ", Name: " + current.name + ", Age: " + current.age
                    + ", Grade: " + current.grade);
            current = current.next;
        }
    }

    // Update a student's grade based on their Roll Number
    public static void updateStudentGrade(int rollNumber, char newGrade) {
        StudentNode current = head;
        while (current.rollNumber != rollNumber) {
            current = current.next;
        }
        current.grade = newGrade;
        System.out.println("\nGrade updated for Roll Number: " + rollNumber);
    }

    public static void main(String[] args) {
        // Adding students to the list
        addStudentAtBeginning(101, "Ravi", 20, 'A');
        addStudentAtBeginning(102, "Henry", 22, 'B');
        addStudentAtEnd(103, "John", 21, 'A');
        addStudentAtEnd(104, "Manish", 23, 'C');
        addStudentAtPosition(105, "Suresh", 22, 'B', 2);

        // Display all students
        System.out.println("Student records:");
        displayAllStudents();

        searchStudentByRollNumber(103);

        updateStudentGrade(102, 'A');

        System.out.println("\nStudent records after grade update:");
        displayAllStudents();

        deleteStudentByRollNumber(104);

        System.out.println("\nStudent records after deletion:");
        displayAllStudents();
    }
}
