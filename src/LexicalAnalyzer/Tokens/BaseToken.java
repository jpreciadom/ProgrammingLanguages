package LexicalAnalyzer.Tokens;

public abstract class BaseToken {
    protected int row;
    protected int col;

    public BaseToken(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public abstract String toString();
}
