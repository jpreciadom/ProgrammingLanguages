package LexicalAnalyzer.States;

import Diccionary.Diccionary;
import LexicalAnalyzer.States.Interfaces.BasicAcceptanceState;

public class S6 extends BasicAcceptanceState {
    public S6(Diccionary diccionary, String buffer) {
        super(diccionary, buffer);
        this.token = "token_menor_igual";
    }

    @Override
    public int getReturnSpaces() {
        return 0;
    }
}
