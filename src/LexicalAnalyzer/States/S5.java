package LexicalAnalyzer.States;

import Diccionary.Diccionary;
import LexicalAnalyzer.Outputs.BasicOutput;
import LexicalAnalyzer.States.Interfaces.AcceptanceState;
import LexicalAnalyzer.States.Interfaces.IState;

public class S5 extends AcceptanceState {
    public S5(Diccionary diccionary, String buffer) {
        super(diccionary, buffer);
    }

    @Override
    public int getReturnSpaces() {
        return 0;
    }

    @Override
    public BasicOutput getToken(int row, int col) {
        return new BasicOutput("token_dif", row, col - this.buffer.length() + 1);
    }
}
