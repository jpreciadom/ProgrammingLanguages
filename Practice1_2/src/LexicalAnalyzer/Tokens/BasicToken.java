package LexicalAnalyzer.Tokens;

public class BasicToken extends BaseToken {
    protected String tokenType;

    public BasicToken(String tokenType, int row, int col) {
        super(row, col);
        this.tokenType = tokenType;
        this.row = row;
        this.col = col;
    }

    public String getTokenType() {
        return tokenType;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        return result.append('<').append(tokenType).append(',').append(row).append(',').append(col).append('>').toString();
    }
}
