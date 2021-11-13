package LexicalAnalyzer.States.Interfaces;

import Diccionary.Diccionary;
import LexicalAnalyzer.States.S0;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public abstract class AcceptanceState extends AbstractState {
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
}
