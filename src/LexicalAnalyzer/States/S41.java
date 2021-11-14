package LexicalAnalyzer.States;

import Diccionary.Diccionary;
import LexicalAnalyzer.Exceptions.LexicalError;
import LexicalAnalyzer.States.Interfaces.IState;
import LexicalAnalyzer.States.Interfaces.NotAcceptanceState;

public class S41 extends NotAcceptanceState {
    public S41(Diccionary diccionary, String buffer) {
        super(diccionary, buffer);
    }

    @Override
    public IState processCharacter(char character) throws LexicalError {
        String buffer = this.validateCharacter(character, true);
        if (IState.isAlphaNumeric(character) || character == '_') {
            return new S41(diccionary, buffer);
        } else {
            return new S42(diccionary, buffer);
        }
    }
}
