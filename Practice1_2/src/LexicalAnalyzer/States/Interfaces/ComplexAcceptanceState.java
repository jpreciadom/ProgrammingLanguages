package LexicalAnalyzer.States.Interfaces;

import Diccionary.Diccionary;
import LexicalAnalyzer.Tokens.BasicToken;
import LexicalAnalyzer.Tokens.ComplexToken;

public abstract class ComplexAcceptanceState extends AcceptanceState {
    public ComplexAcceptanceState(Diccionary diccionary, String buffer) {
        super(diccionary, buffer);
    }

    @Override
    public BasicToken getToken(int row, int col) {
        return new ComplexToken(
                this.token,
                this.buffer.substring(0, this.buffer.length() - this.getReturnSpaces()),
                row,
                col - this.buffer.length() + 1
        );
    }
}
