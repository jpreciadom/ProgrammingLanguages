import Diccionary.Diccionary;
import LexicalAnalyzer.LexicalAnalyzer;
import LexicalAnalyzer.Outputs.BaseOutput;

import java.io.*;
import java.util.Scanner;

public class Test {
    protected static LexicalAnalyzer lexicalAnalyzer;
    protected static Diccionary diccionary;
    protected static String baseTestURL = "D:\\General\\Trabajos\\ProgrammingLanguages\\test\\";

    public static void main(String[] args) {
        diccionary = new Diccionary();

        for (int i = 1; i <= 13; i++) {
            FileInputStream testInputStream = null;
            Scanner expectedOutput = null;
            try {
                File testFile = new File(new StringBuilder(baseTestURL).append('T').append(i).append(".txt").toString());
                File expectedFile = new File(new StringBuilder(baseTestURL).append('E').append(i).append(".txt").toString());
                testInputStream = new FileInputStream(testFile);
                FileInputStream expectedDataStream = new FileInputStream(expectedFile);
                expectedOutput = new Scanner(expectedDataStream);
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
                System.exit(-1);
            }

            System.out.println("Test No: " + i + "\n");

            lexicalAnalyzer = new LexicalAnalyzer(diccionary, testInputStream);
            lexicalAnalyzer.analyze();

            for (BaseOutput output : lexicalAnalyzer.getOutput()) {
                String expected = expectedOutput.nextLine();
                String received = output.toString();
                if (received.equals(expected)) {
                    System.out.println(received);
                } else {
                    System.out.println("\nError!");
                    System.out.println("Expected: " + expected);
                    System.out.println("Received: " + received);
                    System.exit(-1);
                }
            }
            System.out.println("\n");
        }
        System.out.println("All test have passed!");
    }
}
