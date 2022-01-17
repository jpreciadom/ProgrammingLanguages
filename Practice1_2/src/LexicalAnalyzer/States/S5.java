package LexicalAnalyzer.States;

import Diccionary.Diccionary;
import LexicalAnalyzer.States.Interfaces.BasicAcceptanceState;

public class S5 extends BasicAcceptanceState {
    public S5(Diccionary diccionary, String buffer) {
        super(diccionary, buffer);
        this.token = "token_dif";
    }

    @Override
    public int getReturnSpaces() {
        return 0;
    }
}
