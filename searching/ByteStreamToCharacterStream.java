package com.bridgelabz.searching;

import java.io.*;

public class ByteStreamToCharacterStream {
    public static void main(String[] args){

        String filePath="src/com/bridgelabz/searching/javaFile";

        try(BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"))) {
                String line;
                while((line=br.readLine())!=null){
                    System.out.println(line);
                }
            }
        catch (IOException e){
            System.out.println(e);
        }
    }
}
