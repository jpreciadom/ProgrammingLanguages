package LexicalAnalyzer.States;

import Diccionary.Diccionary;
import LexicalAnalyzer.States.Interfaces.BasicAcceptanceState;

public class S11 extends BasicAcceptanceState {
    public S11(Diccionary diccionary, String buffer) {
        super(diccionary, buffer);
        this.token = "token_mas";
    }

    @Override
    public int getReturnSpaces() {
        return 0;
    }
}
