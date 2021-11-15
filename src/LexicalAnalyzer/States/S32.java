package LexicalAnalyzer.States;

import Diccionary.Diccionary;
import LexicalAnalyzer.Exceptions.LexicalError;
import LexicalAnalyzer.Exceptions.UnexpectedToken;
import LexicalAnalyzer.States.Interfaces.IState;
import LexicalAnalyzer.States.Interfaces.NotAcceptanceState;

public class S32 extends NotAcceptanceState {
    public S32(Diccionary diccionary, String buffer) {
        super(diccionary, buffer);
    }

    @Override
    public IState processCharacter(char character) throws LexicalError {
        throw new UnexpectedToken();
    }
}
