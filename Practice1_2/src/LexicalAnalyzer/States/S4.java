package LexicalAnalyzer.States;

import Diccionary.Diccionary;
import LexicalAnalyzer.States.Interfaces.BasicAcceptanceState;

public class S4 extends BasicAcceptanceState {
    public S4(Diccionary diccionary, String buffer) {
        super(diccionary, buffer);
        this.token = "token_asig";
    }

    @Override
    public int getReturnSpaces() {
        return 0;
    }
}
