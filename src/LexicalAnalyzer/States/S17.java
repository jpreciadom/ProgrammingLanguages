package LexicalAnalyzer.States;

import Diccionary.Diccionary;
import LexicalAnalyzer.Tokens.BasicToken;
import LexicalAnalyzer.States.Interfaces.AcceptanceState;

public class S17 extends AcceptanceState {
    public S17(Diccionary diccionary, String buffer) {
        super(diccionary, buffer);
    }

    @Override
    public int getReturnSpaces() {
        return 0;
    }

    @Override
    public BasicToken getToken(int row, int col) {
        return null;
    }
}
