package LexicalAnalyzer.States;

import Diccionary.Diccionary;
import LexicalAnalyzer.States.Interfaces.BasicAcceptanceState;

public class S13 extends BasicAcceptanceState {
    public S13(Diccionary diccionary, String buffer) {
        super(diccionary, buffer);
        this.token = "token_menos";
    }

    @Override
    public int getReturnSpaces() {
        return 0;
    }
}
