package LexicalAnalyzer.States;

import Diccionary.Diccionary;
import LexicalAnalyzer.States.Interfaces.ComplexAcceptanceState;

public class S40 extends ComplexAcceptanceState {
    public S40(Diccionary diccionary, String buffer) {
        super(diccionary, buffer);
        this.token = "token_entero";
    }

    @Override
    public int getReturnSpaces() {
        return 2;
    }
}
