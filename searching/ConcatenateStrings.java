package com.bridgelabz.searching;

import java.util.Scanner;

public class ConcatenateStrings {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter array of strings: ");
        String[] arr=scanner.nextLine().split(" ");

        StringBuffer string=new StringBuffer();
        for(int i=0;i<arr.length;i++){
            string.append(arr[i]);
        }

        System.out.println("After concatenation: \n" +string);
    }
}
