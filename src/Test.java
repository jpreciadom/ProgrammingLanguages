import Diccionary.Diccionary;
import LexicalAnalyzer.LexicalAnalyzer;
import LexicalAnalyzer.Outputs.BaseOutput;

import java.io.*;

public class Test {
    protected static LexicalAnalyzer lexicalAnalyzer;
    protected static Diccionary diccionary;

    public static void main(String[] args) {
        FileInputStream dataInputStream = null;

        try {
            dataInputStream = new FileInputStream(new File("Test.txt"));
        } catch (FileNotFoundException ex) {
            System.exit(-1);
        }

        diccionary = new Diccionary();

        lexicalAnalyzer = new LexicalAnalyzer(diccionary, dataInputStream);
        lexicalAnalyzer.analyze();

        for(BaseOutput output: lexicalAnalyzer.getOutput()) {
            System.out.println(output.toString());
        }
    }
}
