package LexicalAnalyzer.States.Interfaces;

import Diccionary.Diccionary;
import LexicalAnalyzer.Tokens.BasicToken;

public abstract class BasicAcceptanceState extends AcceptanceState{
    public BasicAcceptanceState(Diccionary diccionary, String buffer) {
        super(diccionary, buffer);
    }

    @Override
    public BasicToken getToken(int row, int col) {
        return new BasicToken(this.token, row, col - this.buffer.length() + 1);
    }
}
