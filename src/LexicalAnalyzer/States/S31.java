package LexicalAnalyzer.States;

import Diccionary.Diccionary;
import LexicalAnalyzer.Outputs.BasicOutput;
import LexicalAnalyzer.Outputs.ComplexOutput;
import LexicalAnalyzer.States.Interfaces.ComplexAcceptanceState;

public class S31 extends ComplexAcceptanceState {
    public S31(Diccionary diccionary, String buffer) {
        super(diccionary, buffer);
        this.token = "token_cadena";
    }

    @Override
    public int getReturnSpaces() {
        return 0;
    }

    @Override
    public BasicOutput getToken(int row, int col) {
        return new ComplexOutput(
                this.token,
                this.buffer.substring(1, this.buffer.length() - this.getReturnSpaces() - 1),
                row,
                col - this.buffer.length() + 1
        );
    }
}
