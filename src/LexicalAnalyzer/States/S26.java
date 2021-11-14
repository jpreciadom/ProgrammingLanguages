package LexicalAnalyzer.States;

import Diccionary.Diccionary;
import LexicalAnalyzer.States.Interfaces.BasicAcceptanceState;

public class S26 extends BasicAcceptanceState {
    public S26(Diccionary diccionary, String buffer) {
        super(diccionary, buffer);
        this.token = "token_o";
    }

    @Override
    public int getReturnSpaces() {
        return 0;
    }
}
