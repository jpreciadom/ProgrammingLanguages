package LexicalAnalyzer.States;

import Diccionary.Diccionary;
import LexicalAnalyzer.Exceptions.LexicalError;
import LexicalAnalyzer.Exceptions.UnexpectedToken;
import LexicalAnalyzer.States.Interfaces.IState;
import LexicalAnalyzer.States.Interfaces.NotAcceptanceState;

public class S37 extends NotAcceptanceState {
    public S37(Diccionary diccionary, String buffer) {
        super(diccionary, buffer);
    }

    @Override
    public IState processCharacter(char character) throws LexicalError {
        String buffer = this.validateCharacter(character, false);
        if (IState.isAlphabetic(character)) {
            throw new UnexpectedToken();
        } else if (IState.isNumeric(character)) {
            return new S37(diccionary, buffer);
        } else {
            return new S38(diccionary, buffer);
        }
    }
}
