import Diccionary.Diccionary;
import LexicalAnalyzer.LexicalAnalyzer;
import LexicalAnalyzer.Tokens.BaseToken;
import SyntacticAnalyzer.Exceptions.GrammarIsNotLL1Exception;
import SyntacticAnalyzer.Grammar.Grammar;
import SyntacticAnalyzer.Grammar.GrammarBuilder;
import SyntacticAnalyzer.SyntacticAnalyzer;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class Test {
    protected static LexicalAnalyzer lexicalAnalyzer;
    protected static SyntacticAnalyzer syntacticAnalyzer;
    protected static Diccionary diccionary;
    protected static Grammar grammar;

    protected static String baseTestURL = "D:\\General\\Trabajos\\ProgrammingLanguages\\test\\";

    public static void main(String[] args) throws FileNotFoundException, GrammarIsNotLL1Exception {
        diccionary = new Diccionary();

        GrammarBuilder grammarBuilder = new GrammarBuilder(
                new FileInputStream( Objects.requireNonNull(Test.class.getResource("SyntacticAnalyzer/Grammar.csv")).getPath())
        );
        grammarBuilder.verify();
        grammar = grammarBuilder.toGrammar();

        testLexicalAnalyzer();
        testSyntacticAnalyzer();
    }

    private static FileInputStream getTestFile(String url, int idx) throws FileNotFoundException {
        return new FileInputStream( url + 'T' + idx + ".txt" );
    }

    private static FileInputStream getExpectedFile(String url, int idx) throws FileNotFoundException {
        return new FileInputStream( url + 'E' + idx + ".txt" );
    }

    public static void testLexicalAnalyzer() throws FileNotFoundException {
        System.out.println("Testing lexical analyzer");
        String testFolderPath = baseTestURL + "\\LexicalAnalyzerTest\\";
        for (int i = 1; i <= 0; i++) {
            FileInputStream testInputStream = getTestFile(testFolderPath, i);
            Scanner expectedOutput = new Scanner(getExpectedFile(testFolderPath, i));

            System.out.println("Test No: " + i + "\n");

            lexicalAnalyzer = new LexicalAnalyzer(diccionary, testInputStream);
            lexicalAnalyzer.analyze();

            for (BaseToken output : lexicalAnalyzer.getOutput()) {
                String received = output.toString();
                String expected = expectedOutput.nextLine();
                assertOutput(received, expected);
            }
            System.out.println("\n");
        }
        System.out.println("All test have passed!\n\n");
    }

    public static void testSyntacticAnalyzer() throws FileNotFoundException {
        System.out.println("Testing syntactic analyzer\n");
        String testFolderPath = baseTestURL + "\\SyntacticAnalyzerTest\\";
        for (int i = 5; i <= 5; i++) {
            FileInputStream testInputStream = getTestFile(testFolderPath, i);
            Scanner expectedOutput = new Scanner(getExpectedFile(testFolderPath, i));

            System.out.println("Test No: " + i);

            lexicalAnalyzer = new LexicalAnalyzer(diccionary, testInputStream);
            lexicalAnalyzer.analyze();

            syntacticAnalyzer = new SyntacticAnalyzer(diccionary, grammar, lexicalAnalyzer.getOutput());
            syntacticAnalyzer.analyze();

            assertOutput(syntacticAnalyzer.getOutput(), expectedOutput.nextLine());
            System.out.println("");
        }
        System.out.println("All test have passed!\n\n");
    }

    private static void assertOutput(String received, String expected) {
        if (received.equals(expected)) {
            System.out.println(received);
        } else {
            System.out.println("\nError!");
            System.out.println("Expected: " + expected);
            System.out.println("Received: " + received);
            System.exit(-1);
        }
    }
}
