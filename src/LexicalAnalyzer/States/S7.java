package LexicalAnalyzer.States;

import Diccionary.Diccionary;
import LexicalAnalyzer.Outputs.BasicOutput;
import LexicalAnalyzer.States.Interfaces.AcceptanceState;

public class S7 extends AcceptanceState {
    public S7(Diccionary diccionary, String buffer) {
        super(diccionary, buffer);
    }

    @Override
    public int getReturnSpaces() {
        return 1;
    }

    @Override
    public BasicOutput getToken(int row, int col) {
        return new BasicOutput("token_menor", row, col - this.buffer.length() + 1);
    }
}
