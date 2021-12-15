package SyntacticAnalyzer.Exceptions;

public class GrammarIsNotLL1Exception extends Exception {
    public GrammarIsNotLL1Exception(String message) {
        super("The provided grammar is not LL1. " + message);
    }
}
