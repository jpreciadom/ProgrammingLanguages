package LexicalAnalyzer.States;

import Diccionary.Diccionary;
import LexicalAnalyzer.States.Interfaces.BasicAcceptanceState;

public class S15 extends BasicAcceptanceState {
    public S15(Diccionary diccionary, String buffer) {
        super(diccionary, buffer);
        this.token = "token_div";
    }

    @Override
    public int getReturnSpaces() {
        return 1;
    }
}
