package LexicalAnalyzer.States;

import Diccionary.Diccionary;
import LexicalAnalyzer.States.Interfaces.BasicAcceptanceState;

public class S18 extends BasicAcceptanceState {
    public S18(Diccionary diccionary, String buffer) {
        super(diccionary, buffer);
        this.token = "token_mul";
    }

    @Override
    public int getReturnSpaces() {
        return 0;
    }
}
