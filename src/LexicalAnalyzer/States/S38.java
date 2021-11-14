package LexicalAnalyzer.States;

import Diccionary.Diccionary;
import LexicalAnalyzer.States.Interfaces.ComplexAcceptanceState;

public class S38 extends ComplexAcceptanceState {
    public S38(Diccionary diccionary, String buffer) {
        super(diccionary, buffer);
        this.token = "token_real";
    }

    @Override
    public int getReturnSpaces() {
        return 1;
    }
}
