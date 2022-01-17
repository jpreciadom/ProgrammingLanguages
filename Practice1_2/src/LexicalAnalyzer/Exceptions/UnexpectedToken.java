package LexicalAnalyzer.Exceptions;

public class UnexpectedToken extends LexicalError {
    public UnexpectedToken() {
        super("Unexpected token found");
    }
}
