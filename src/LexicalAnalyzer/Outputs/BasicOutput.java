package LexicalAnalyzer.Outputs;

public class BasicOutput extends BaseOutput {
    protected String tokenType;

    public BasicOutput(String tokenType, int row, int col) {
        super(row, col);
        this.tokenType = tokenType;
        this.row = row;
        this.col = col;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        return result.append('<').append(tokenType).append(',').append(row).append(',').append(col).append('>').toString();
    }
}
