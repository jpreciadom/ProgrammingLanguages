package LexicalAnalyzer.States;

import Diccionary.Diccionary;
import LexicalAnalyzer.States.Interfaces.BasicAcceptanceState;

public class S22 extends BasicAcceptanceState {
    public S22(Diccionary diccionary, String buffer) {
        super(diccionary, buffer);
        this.token = "token_par_izq";
    }

    @Override
    public int getReturnSpaces() {
        return 0;
    }
}
