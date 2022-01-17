package LexicalAnalyzer.States;

import Diccionary.Diccionary;
import LexicalAnalyzer.States.Interfaces.BasicAcceptanceState;

public class S10 extends BasicAcceptanceState {
    public S10(Diccionary diccionary, String buffer) {
        super(diccionary, buffer);
        this.token = "token_mayor";
    }

    @Override
    public int getReturnSpaces() {
        return 1;
    }
}
