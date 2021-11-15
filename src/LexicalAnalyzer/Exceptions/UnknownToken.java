package LexicalAnalyzer.Exceptions;

public class UnknownToken extends LexicalError {
    public UnknownToken() {
        super("Unknown token found");
    }
}
