package LexicalAnalyzer.States;

import Diccionary.Diccionary;
import LexicalAnalyzer.States.Interfaces.BasicAcceptanceState;

public class S1 extends BasicAcceptanceState {
    public S1(Diccionary diccionary, String buffer) {
        super(diccionary, buffer);
        this.token = "token_neg";
    }

    @Override
    public int getReturnSpaces() {
        return 0;
    }
}
