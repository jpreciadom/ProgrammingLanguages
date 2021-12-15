package LexicalAnalyzer.States.Interfaces;

import Diccionary.Diccionary;
import LexicalAnalyzer.Tokens.ComplexToken;
import LexicalAnalyzer.States.S0;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public abstract class AcceptanceState extends AbstractState {

    protected String token;

    public AcceptanceState(Diccionary diccionary, String buffer) {
        super(diccionary, buffer);
    }

    public boolean isAcceptanceState() {
        return true;
    }

    @Override
    public IState lambdaTransition() {
        return new S0(diccionary);
    }

    @Override
    public IState processCharacter(char character) { throw new NotImplementedException(); }

    protected ComplexToken generateComplexOutput(String token, int row, int col) {
        return new ComplexToken(
                token,
                this.buffer.substring(0, this.buffer.length() - this.getReturnSpaces()),
                row,
                col - this.buffer.length() + 1
        );
    }
}
