package LexicalAnalyzer.States;

import Diccionary.Diccionary;
import LexicalAnalyzer.Exceptions.LexicalError;
import LexicalAnalyzer.Outputs.BasicOutput;
import LexicalAnalyzer.States.Interfaces.AcceptanceState;
import LexicalAnalyzer.States.Interfaces.IState;
import LexicalAnalyzer.States.S0;

public class S1 extends AcceptanceState {
    public S1(Diccionary diccionary, String buffer) {
        super(diccionary, buffer);
    }

    @Override
    public int getReturnSpaces() {
        return 0;
    }

    @Override
    public BasicOutput getToken(int row, int col) {
        return new BasicOutput("token_neg", row, col - this.buffer.length() + 1);
    }
}
