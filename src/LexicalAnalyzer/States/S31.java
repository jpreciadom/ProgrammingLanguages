package LexicalAnalyzer.States;

import Diccionary.Diccionary;
import LexicalAnalyzer.States.Interfaces.ComplexAcceptanceState;

public class S31 extends ComplexAcceptanceState {
    public S31(Diccionary diccionary, String buffer) {
        super(diccionary, buffer);
        this.token = "token_cadena";
    }

    @Override
    public int getReturnSpaces() {
        return 0;
    }
}
