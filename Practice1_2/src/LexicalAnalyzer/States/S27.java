package LexicalAnalyzer.States;

import Diccionary.Diccionary;
import LexicalAnalyzer.States.Interfaces.BasicAcceptanceState;

public class S27 extends BasicAcceptanceState {
    public S27(Diccionary diccionary, String buffer) {
        super(diccionary, buffer);
        this.token = "token_y";
    }

    @Override
    public int getReturnSpaces() {
        return 0;
    }
}
