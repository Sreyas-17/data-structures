package com.bridgelabz.timecomplexity;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LargeFileReadingEfficiency {
    public static void fileReader(String[] strings) {
        String filePath = "src/com/bridgelabz/searching/javaFile";

        //File reader
        try (FileReader fileReader = new FileReader(filePath)) {
            int ch;
            long startTime = System.nanoTime();
            while ((ch = fileReader.read()) != -1) {
            }
            long endTime = System.nanoTime();
            System.out.println("Time taken: " + (endTime - startTime) + " by using fileReader");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void inputStreamReader(String[] strings) {
        //Input stream reader
        String filePath="src/com/bridgelabz/searching/javaFile";

        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath))) {
            int ch;
            long startTime = System.nanoTime();
            while ((ch = isr.read()) != -1) {
            }
            long endTime = System.nanoTime();
            System.out.println("Time taken: " + (endTime - startTime) + " by using Inputstream reader");
        }

        catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {

        String[] strings={"Hello", "World","Java","Hello","World","Java","Hello","World","Java","Hello","World","Java"};

        fileReader(strings);
        inputStreamReader(strings);

    }
}
