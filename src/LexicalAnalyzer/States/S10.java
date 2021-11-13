package LexicalAnalyzer.States;

import Diccionary.Diccionary;
import LexicalAnalyzer.Outputs.BasicOutput;
import LexicalAnalyzer.States.Interfaces.AcceptanceState;

public class S10 extends AcceptanceState {
    public S10(Diccionary diccionary, String buffer) {
        super(diccionary, buffer);
    }

    @Override
    public int getReturnSpaces() {
        return 1;
    }

    @Override
    public BasicOutput getToken(int row, int col) {
        return new BasicOutput("token_mayor", row, col - this.buffer.length() + 1);
    }
}
