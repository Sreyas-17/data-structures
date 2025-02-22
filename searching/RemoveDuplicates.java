package com.bridgelabz.searching;

import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<Character>set=new HashSet<>();

        System.out.println("Enter a string: ");
        String input = scanner.nextLine();
        StringBuilder string=new StringBuilder();

        for(int i=0;i<input.length();i++){
            if(!set.contains(input.charAt(i))){
                string.append(input.charAt(i));
            }
            set.add(input.charAt(i));
        }
        System.out.println("After removing duplicates: \n"+string);
    }
}
