package LexicalAnalyzer.States;

import Diccionary.Diccionary;
import LexicalAnalyzer.States.Interfaces.BasicAcceptanceState;

public class S19 extends BasicAcceptanceState {
    public S19(Diccionary diccionary, String buffer) {
        super(diccionary, buffer);
        this.token = "token_mod";
    }

    @Override
    public int getReturnSpaces() {
        return 0;
    }
}
