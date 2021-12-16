package SyntacticAnalyzer.Exceptions;

public abstract class SyntacticErrorException extends Exception {
    public SyntacticErrorException(String message) {
        super(message);
    }
}
