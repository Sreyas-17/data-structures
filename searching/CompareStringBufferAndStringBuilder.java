package com.bridgelabz.searching;

import java.util.Scanner;

public class CompareStringBufferAndStringBuilder {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] arr=scanner.nextLine().split(" ");

        long startTime=System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            stringBuffer.append(arr[i]);
        }
        long endTime=System.nanoTime();
        System.out.println(stringBuffer);
        System.out.println("Time taken to concatenate using string buffer: "+(endTime-startTime));

        StringBuilder stringBuilder = new StringBuilder();
        startTime = System.nanoTime();
        for (int i = 0; i < arr.length; i++) {
            stringBuilder.append(arr[i]);
        }
        endTime=System.nanoTime();
        System.out.println(stringBuilder);
        System.out.println("Time taken to concatenate using string builder: "+(endTime-startTime));

    }
}
