package LexicalAnalyzer.Outputs;

public class ComplexOutput extends BasicOutput {
    protected String lexeme;

    public ComplexOutput(String tokenType, int row, int col, String lexeme) {
        super(tokenType, row, col);
        this.lexeme = lexeme;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        return result.append('<').append(this.tokenType).append(',').append(this.lexeme).append(',')
                .append(this.row).append(',').append(this.col).append('>').toString();
    }
}
