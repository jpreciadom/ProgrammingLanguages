package LexicalAnalyzer.Tokens;

public class ComplexToken extends BasicToken {
    protected String lexeme;

    public ComplexToken(String tokenType, String lexeme, int row, int col) {
        super(tokenType, row, col);
        this.lexeme = lexeme;
    }

    public String getLexeme() {
        return lexeme;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        return result.append('<').append(this.tokenType).append(',').append(this.lexeme).append(',')
                .append(this.row).append(',').append(this.col).append('>').toString();
    }
}
