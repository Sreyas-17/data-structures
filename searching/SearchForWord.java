package com.bridgelabz.searching;

import java.util.Scanner;

public class SearchForWord {
    public static String linearSearch(String[] sentences,String word) {

        for (int i = 0; i < sentences.length; i++) {
            String[]words = sentences[i].split(" ");
            for( String w : words) {
                w=w.toLowerCase();
                if(w.equals(word)) {
                    return sentences[i];
                }
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] sentences=new String[3];
        System.out.println("Enter 3 sentences:");
        for (int i = 0; i < 3; i++) {
            sentences[i] = scanner.nextLine();
        }

        System.out.print("Enter the target word: ");
        String targetWord = scanner.nextLine();
        String result = linearSearch(sentences,targetWord);
        System.out.println(result);
    }
}
