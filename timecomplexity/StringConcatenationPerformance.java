package com.bridgelabz.timecomplexity;

public class StringConcatenationPerformance {
    public static void stringConcatenation(String[] words) {

        String str = "";
        long startTime = System.nanoTime();

        for (String word : words) {
            str += word;
        }

        long endTime = System.nanoTime();
        System.out.println("String Concatenation Time: " + (endTime - startTime));
    }

    public static void stringBuilderConcatenation(String[] words) {

        StringBuilder sb = new StringBuilder();

        long startTime = System.nanoTime();
        for (String word : words) {
            sb.append(word);
        }

        long endTime = System.nanoTime();
        System.out.println("StringBuilder Concatenation Time: " + (endTime - startTime));
    }

    public static void stringBufferConcatenation(String[] words) {

        StringBuffer sb = new StringBuffer();
        long startTime = System.nanoTime();

        for (String word : words) {
            sb.append(word);
        }

        long endTime = System.nanoTime();
        System.out.println("StringBuffer Concatenation Time: " + (endTime - startTime));
    }

    public static void main(String[] args) {
        String[] words = {"Hello","Java","World"};

        stringConcatenation(words);
        stringBuilderConcatenation(words);
        stringBufferConcatenation(words);

    }
}
