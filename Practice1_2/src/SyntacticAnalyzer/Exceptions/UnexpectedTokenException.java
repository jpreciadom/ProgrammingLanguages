package SyntacticAnalyzer.Exceptions;

public class UnexpectedTokenException extends SyntacticErrorException {
    public UnexpectedTokenException(String message) {
        super(message);
    }
}
