package com.bridgelabz.stackqueuehash;

import java.util.*;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = {3,1,2,-1,-2,4,6,7};
        System.out.println("Enter the size of the window (array size is 7): ");
        int k = scanner.nextInt();
        int i, j, n = arr.length;
        Deque<Integer> queue = new LinkedList();
        for (i = 0; i < k; i++) {
            queue.addLast(i);
            if(arr[i]>arr[queue.peekFirst()]){
                queue.removeFirst();
            }
        }
        System.out.println(arr[queue.peekFirst()]);
        for (j=k; j < n; j++) {
            if(queue.peekFirst()<=j-k&&!queue.isEmpty()){
                queue.removeFirst();
            }
            while (!queue.isEmpty() && arr[j]>=arr[queue.peekFirst()]){
                queue.removeFirst();
            }
            queue.addLast(j);
            System.out.println(arr[queue.peekFirst()]);
        }
    }
}
