package LexicalAnalyzer.States.Interfaces;

import Diccionary.Diccionary;
import LexicalAnalyzer.Tokens.BasicToken;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public abstract class NotAcceptanceState extends AbstractState {
    public NotAcceptanceState(Diccionary diccionary, String buffer) {
        super(diccionary, buffer);
    }

    public boolean isAcceptanceState() {
        return false;
    }

    public int getReturnSpaces() { throw new NotImplementedException(); }

    @Override
    public BasicToken getToken(int row, int col) { throw new NotImplementedException(); }

    public IState lambdaTransition() {
        throw new NotImplementedException();
    }
}
