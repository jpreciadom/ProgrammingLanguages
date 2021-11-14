package LexicalAnalyzer.States;

import Diccionary.Diccionary;
import LexicalAnalyzer.States.Interfaces.BasicAcceptanceState;

public class S21 extends BasicAcceptanceState {
    public S21(Diccionary diccionary, String buffer) {
        super(diccionary, buffer);
        this.token = "token_dosp";
    }

    @Override
    public int getReturnSpaces() {
        return 0;
    }
}
