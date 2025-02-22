package com.bridgelabz.searching;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class WriteToAFile {
    public static void main(String[] args) throws IOException {

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        String filePath = "src/com/bridgelabz/searching/javaFile";
        FileWriter fr = new FileWriter(filePath,true);

        String input;
        System.out.println("Enter sentence to add or 'exit' to stop");
        while(!(input=br.readLine()).equals("exit")) {
            fr.write(input + "\n");
        }

        fr.close();
        br.close();
        isr.close();
        System.out.println("File written successfully");
    }
}
