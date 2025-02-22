package com.bridgelabz.searching;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string: ");
        String string = scanner.nextLine();

        StringBuilder reverseString = new StringBuilder(string);
        reverseString.reverse();
        System.out.println("Reversed string: "+reverseString);
    }
}
