package LexicalAnalyzer.States.Interfaces;

import Diccionary.Diccionary;
import LexicalAnalyzer.Outputs.BasicOutput;
import LexicalAnalyzer.Outputs.ComplexOutput;

public abstract class ComplexAcceptanceState extends AcceptanceState {
    public ComplexAcceptanceState(Diccionary diccionary, String buffer) {
        super(diccionary, buffer);
    }

    @Override
    public BasicOutput getToken(int row, int col) {
        return new ComplexOutput(
                this.token,
                this.buffer.substring(0, this.buffer.length() - this.getReturnSpaces()),
                row,
                col - this.buffer.length() + 1
        );
    }
}
