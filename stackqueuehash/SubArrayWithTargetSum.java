package com.bridgelabz.stackqueuehash;

import java.util.*;

public class SubArrayWithTargetSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = {1, 0, -1, -3, 0, 3, 6, 7};
        int n = arr.length;
        int prefix = 0, count = 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        System.out.println("Enter the target sum: ");
        int k = scanner.nextInt();
        map.put(0, new ArrayList<>());
        map.get(0).add(-1);
        for (int i = 0; i < n; i++) {
            prefix += arr[i];
            if (map.containsKey(prefix - k)) {
                count += map.get(prefix - k).size();
                for (int startIdx : map.get(prefix - k)) {
                    System.out.print("[ ");
                    for (int j = startIdx + 1; j <= i; j++) {
                        System.out.print(arr[j] + " ");
                    }
                    System.out.println("]");
                }
            }
            map.putIfAbsent(prefix, new ArrayList<>());
            map.get(prefix).add(i);
        }
        System.out.println("There are " + count + " subarrays with target sum.");
    }
}
