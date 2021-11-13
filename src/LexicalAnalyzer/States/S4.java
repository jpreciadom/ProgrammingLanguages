package LexicalAnalyzer.States;

import Diccionary.Diccionary;
import LexicalAnalyzer.Outputs.BasicOutput;
import LexicalAnalyzer.States.Interfaces.AcceptanceState;

public class S4 extends AcceptanceState {
    public S4(Diccionary diccionary, String buffer) {
        super(diccionary, buffer);
    }

    @Override
    public int getReturnSpaces() {
        return 0;
    }

    @Override
    public BasicOutput getToken(int row, int col) {
        return new BasicOutput("token_asig", row, col - this.buffer.length() + 1);
    }
}
