package com.bridgelabz.searching;

import java.io.*;

public class CompareStringAndReaderClasses {

    public static void compareStringClasses(String[] strings){
        //String builder
        StringBuilder builder=new StringBuilder();
        long startTime=System.nanoTime();
        int i=0;
        while(i<strings.length){
            builder.append(strings[i]);
            i++;
        }
        long endTime=System.nanoTime();
        System.out.println("Time taken: "+(endTime-startTime)+" by using StringBuilder");

        //String buffer
        StringBuffer buffer=new StringBuffer();
        startTime=System.nanoTime();
        i=0;
        while(i<strings.length){
            buffer.append(strings[i]);
            i++;
        }
        endTime=System.nanoTime();
        System.out.println("Time taken: "+(endTime-startTime)+" by using StringBuffer");
    }

    public static void compareReaderClasses(String[] strings){
        String filePath="src/com/bridgelabz/searching/javaFile";

        //File reader
        try(FileReader fileReader=new FileReader(filePath)){
            int ch;
            long startTime=System.nanoTime();
            while((ch=fileReader.read())!=-1){
            }
            long endTime=System.nanoTime();
            System.out.println("Time taken: "+(endTime-startTime)+" by using fileReader");
        }
        catch(IOException e){
            System.out.println(e);
        }

        //Input stream reader
        try(InputStreamReader isr=new InputStreamReader(new FileInputStream(filePath))) {
            int ch;
            long startTime=System.nanoTime();
            while((ch=isr.read())!=-1){
            }
            long endTime=System.nanoTime();
            System.out.println("Time taken: "+(endTime-startTime)+" by using Inputstream reader");
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {

        String[] strings={"Hello", "World","Java","Hello","World","Java","Hello","World","Java","Hello","World","Java"};
        compareStringClasses(strings);
        compareReaderClasses(strings);

    }
}
