package com.example.demo.Pr4;

import java.io.*;

import static com.example.demo.Pr4.Converter.replaceNumbersInText;

public class FileReplacement {

    public static void replaceNumbersInInFile(){
        String inputFile = "C:\\Users\\vovap\\Desktop\\input.txt";
        String outputFile = "C:\\Users\\vovap\\Desktop\\output.txt";

        try {
            replaceNumbersInFile(inputFile, outputFile);
            System.out.println("Numbers replaced successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void replaceNumbersInFile(String inputFile, String outputFile) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(replaceNumbersInText(line));
                writer.newLine();
            }
        }
    }

}
