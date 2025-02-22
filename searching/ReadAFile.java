package com.bridgelabz.searching;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class ReadAFile {
    public static void main(String[] args) {

        String filePath="src/com/bridgelabz/searching/javaFile";

        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            while((line=br.readLine())!=null){
                System.out.println(line);
            }
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
}
