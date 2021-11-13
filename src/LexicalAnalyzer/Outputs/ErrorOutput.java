package LexicalAnalyzer.Outputs;

public class ErrorOutput extends BaseOutput {

    public ErrorOutput(int row, int col) {
        super(row, col);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        return result.append(">>> Error lexico (linea: ").append(this.row).append(", posicion: ").append(this.col)
                .append(')').toString();
    }
}
