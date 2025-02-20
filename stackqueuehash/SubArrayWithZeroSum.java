package com.bridgelabz.stackqueuehash;
import java.util.*;

public class SubArrayWithZeroSum {
    public static void main(String[] args) {
        int[] arr = {1, 0, -1, -3, 0, 3, 6, 7};
        int n = arr.length;
        int prefix = 0, count = 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        map.put(0, new ArrayList<>());
        map.get(0).add(-1);
        for (int i = 0; i < n; i++) {
            prefix += arr[i];
            if (map.containsKey(prefix)) {
                count += map.get(prefix).size();

                for (int startIdx : map.get(prefix)) {
                    System.out.print("[ ");
                    for (int k = startIdx + 1; k <= i; k++) {
                        System.out.print(arr[k] + " ");
                    }
                    System.out.println("]");
                }
                map.get(prefix).add(i);
            } else {
                map.put(prefix, new ArrayList<>());
                map.get(prefix).add(i);
            }
        }
        System.out.println("There are " + count + " subarrays with 0 sum.");
    }
}