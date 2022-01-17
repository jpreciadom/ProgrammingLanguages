package LexicalAnalyzer.States;

import Diccionary.Diccionary;
import LexicalAnalyzer.States.Interfaces.BasicAcceptanceState;

public class S9 extends BasicAcceptanceState {
    public S9(Diccionary diccionary, String buffer) {
        super(diccionary, buffer);
        this.token = "token_mayor_igual";
    }

    @Override
    public int getReturnSpaces() {
        return 0;
    }
}
