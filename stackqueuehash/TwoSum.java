package com.bridgelabz.stackqueuehash;
import java.util.*;
public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter the target sum: ");
        int target=scanner.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(target-arr[i])){
                System.out.println("Indices: ");
                System.out.println(map.get(target-arr[i])+" and "+i);
                System.out.println("Values are: ");
                System.out.println(arr[map.get(target-arr[i])]+", "+arr[i]);
            }
            map.put(arr[i], i);
        }
        scanner.close();
    }
}
