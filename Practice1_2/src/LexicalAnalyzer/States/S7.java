package LexicalAnalyzer.States;

import Diccionary.Diccionary;
import LexicalAnalyzer.States.Interfaces.BasicAcceptanceState;

public class S7 extends BasicAcceptanceState {
    public S7(Diccionary diccionary, String buffer) {
        super(diccionary, buffer);
        this.token = "token_menor";
    }

    @Override
    public int getReturnSpaces() {
        return 1;
    }
}
