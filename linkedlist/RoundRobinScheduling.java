package com.bridgelabz.linkedlist;

class Process {
    int processId;
    int burstTime;
    int priority;
    Process next;

    public Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

public class RoundRobinScheduling {
    static Process head = null;
    static Process tail = null;
    static int timeQuantum = 3;

    public static void addProcessAtEnd(int processId, int burstTime, int priority) {
        Process newNode = new Process(processId, burstTime, priority);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    public static void removeProcess(int processId) {
        if (head == null) {
            System.out.println("Invalid");
            return;
        }
        Process current = head;
        if (head.processId==processId) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }
            return;
        }
        while (current.next != head && current.next.processId!=processId) {
            current = current.next;
        }
        if (current.next == head) {
            System.out.println("Task not found.");
            return;
        }
        if (current.next == tail) {
            tail = current;
            tail.next=head;
        }
        current.next = current.next.next;
    }
    public static void mergeSort() {
        if (head == null || head.next == head) return;
        tail.next = null;
        head = mergeSort(head);
        Process temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;
        tail = temp;
    }

    public static Process mergeSort(Process node) {
        if (node == null || node.next == null) {
            return node;
        }
        Process middle = getMiddle(node);
        Process middleNext = middle.next;
        middle.next = null;

        Process left = mergeSort(node);
        Process right = mergeSort(middleNext);

        return merge(left, right);
    }

    public static Process merge(Process left, Process right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        if (left.priority > right.priority) {
            left.next = merge(left.next, right);
            return left;
        } else {
            right.next = merge(left, right.next);
            return right;
        }
    }
    public static Process getMiddle(Process node) {
        if (node == null || node.next == node) {
            return node;
        }

        Process slow = node, fast = node;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static void scheduling() {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        Process current = head;
        System.out.println("\nRound robin process:");
        while (head != null) {
            displayAll();

            if (current.burstTime > timeQuantum) {
                current.burstTime -= timeQuantum;
                current = current.next;
            } else {
                int processToRemove = current.processId;
                current = current.next;
                removeProcess(processToRemove);
                if (head == null) {
                    break;
                }
            }
        }

        System.out.println("\nAll processes completed.");
    }

    public static void displayAll() {
        if (head == null) {
            System.out.println("No processes remaining.");
            return;
        }
        Process current = head;
        System.out.println();
        do {
            System.out.print("[" + current.processId + "," + current.burstTime + "," + current.priority + "] <-> ");
            current = current.next;
        } while (current != head);
        System.out.println("head");
    }

    public static void main(String[] args) {
        addProcessAtEnd(1, 5, 1);
        addProcessAtEnd(2, 3, 2);
        addProcessAtEnd(3, 8, 3);
        addProcessAtEnd(4, 6, 4);

        System.out.println("\nProcesses before sorting:");
        displayAll();

        mergeSort();
        System.out.println("\nProcesses after sorting (priority order):");
        displayAll();
        scheduling();
    }
}
