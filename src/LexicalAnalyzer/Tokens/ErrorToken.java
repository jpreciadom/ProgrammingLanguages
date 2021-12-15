package LexicalAnalyzer.Tokens;

public class ErrorToken extends BaseToken {

    public ErrorToken(int row, int col) {
        super(row, col);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        return result.append(">>> Error lexico (linea: ").append(this.row).append(", posicion: ").append(this.col)
                .append(')').toString();
    }
}
