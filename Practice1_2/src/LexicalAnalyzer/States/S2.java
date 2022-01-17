package LexicalAnalyzer.States;

import Diccionary.Diccionary;
import LexicalAnalyzer.States.Interfaces.BasicAcceptanceState;

public class S2 extends BasicAcceptanceState {
    public S2(Diccionary diccionary, String buffer) {
        super(diccionary, buffer);
        this.token = "token_igual";
    }

    @Override
    public int getReturnSpaces() {
        return 0;
    }
}
