package LexicalAnalyzer.Outputs;

public abstract class BaseOutput {
    protected int row;
    protected int col;

    public BaseOutput(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public abstract String toString();
}
