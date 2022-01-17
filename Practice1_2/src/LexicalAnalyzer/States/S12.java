package LexicalAnalyzer.States;

import Diccionary.Diccionary;
import LexicalAnalyzer.Exceptions.LexicalError;
import LexicalAnalyzer.States.Interfaces.BasicAcceptanceState;
import LexicalAnalyzer.States.Interfaces.IState;
import LexicalAnalyzer.States.Interfaces.NotAcceptanceState;

public class S12 extends BasicAcceptanceState {
    public S12(Diccionary diccionary, String buffer) {
        super(diccionary, buffer);
        this.token = "token_menos";
    }

    @Override
    public int getReturnSpaces() {
        return 0;
    }
}
