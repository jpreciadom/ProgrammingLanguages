package LexicalAnalyzer.States.Interfaces;

import Diccionary.Diccionary;
import LexicalAnalyzer.Outputs.BasicOutput;

public abstract class BasicAcceptanceState extends AcceptanceState{
    public BasicAcceptanceState(Diccionary diccionary, String buffer) {
        super(diccionary, buffer);
    }

    @Override
    public BasicOutput getToken(int row, int col) {
        return new BasicOutput(this.token, row, col - this.buffer.length() + 1);
    }
}
