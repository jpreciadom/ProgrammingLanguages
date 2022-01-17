package LexicalAnalyzer.States;

import Diccionary.Diccionary;
import LexicalAnalyzer.States.Interfaces.BasicAcceptanceState;

public class S24 extends BasicAcceptanceState {
    public S24(Diccionary diccionary, String buffer) {
        super(diccionary, buffer);
        this.token = "token_cor_izq";
    }

    @Override
    public int getReturnSpaces() {
        return 0;
    }
}
