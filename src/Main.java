import Diccionary.Diccionary;
import LexicalAnalyzer.LexicalAnalyzer;
import SyntacticAnalyzer.Exceptions.GrammarIsNotLL1Exception;
import SyntacticAnalyzer.Grammar.Grammar;
import SyntacticAnalyzer.Grammar.GrammarBuilder;
import SyntacticAnalyzer.SyntacticAnalyzer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {

    protected static LexicalAnalyzer lexicalAnalyzer;
    protected static SyntacticAnalyzer syntacticAnalyzer;
    protected static Diccionary diccionary;
    protected static Grammar grammar;

    public static void main(String[] args) throws FileNotFoundException, GrammarIsNotLL1Exception {
        boolean analyzeStatus;
        diccionary = new Diccionary();

        lexicalAnalyzer = new LexicalAnalyzer(diccionary, System.in);
        analyzeStatus = lexicalAnalyzer.analyze();

        if (!analyzeStatus) {
            System.out.println(lexicalAnalyzer.getOutput().peekLast().toString());
            System.exit(-1);
        }

        grammar = new GrammarBuilder(
                diccionary,
                new FileInputStream( Main.class.getResource("SyntacticAnalyzer/Grammar.csv").getPath())
        ).toGrammar();

        syntacticAnalyzer = new SyntacticAnalyzer(grammar, lexicalAnalyzer.getOutput());
        analyzeStatus = syntacticAnalyzer.analyze();
    }
}
