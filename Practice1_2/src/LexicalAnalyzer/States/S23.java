package LexicalAnalyzer.States;

import Diccionary.Diccionary;
import LexicalAnalyzer.States.Interfaces.BasicAcceptanceState;

public class S23 extends BasicAcceptanceState {
    public S23(Diccionary diccionary, String buffer) {
        super(diccionary, buffer);
        this.token = "token_par_der";
    }

    @Override
    public int getReturnSpaces() {
        return 0;
    }
}
