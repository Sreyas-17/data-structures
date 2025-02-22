package com.bridgelabz.searching;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class CountTheOccurrencesOfWord {
    public static void main(String[] args) {

        String filePath="src/com/bridgelabz/searching/javaFile";
        String line,target="hello";
        int count=0;

        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            while((line=br.readLine())!=null) {
                String[] words = line.split(" ");

                for (String word : words) {
                    word = word.toLowerCase();
                    if (word.equals(target)) {
                        count++;
                    }
                }
            }
        }
        catch(IOException e){
            System.out.println(e);
        }

        System.out.println("Total count of "+target+" in file is "+count);
    }
}
