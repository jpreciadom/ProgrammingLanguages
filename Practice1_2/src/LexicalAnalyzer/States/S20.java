package LexicalAnalyzer.States;

import Diccionary.Diccionary;
import LexicalAnalyzer.States.Interfaces.BasicAcceptanceState;

public class S20 extends BasicAcceptanceState {
    public S20(Diccionary diccionary, String buffer) {
        super(diccionary, buffer);
        this.token = "token_pyc";
    }

    @Override
    public int getReturnSpaces() {
        return 0;
    }
}
