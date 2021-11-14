package LexicalAnalyzer.States;

import Diccionary.Diccionary;
import LexicalAnalyzer.States.Interfaces.BasicAcceptanceState;

public class S28 extends BasicAcceptanceState {
    public S28(Diccionary diccionary, String buffer) {
        super(diccionary, buffer);
        this.token = "token_coma";
    }

    @Override
    public int getReturnSpaces() {
        return 0;
    }
}
