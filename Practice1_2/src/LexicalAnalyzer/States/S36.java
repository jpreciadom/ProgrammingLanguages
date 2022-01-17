package LexicalAnalyzer.States;

import Diccionary.Diccionary;
import LexicalAnalyzer.Exceptions.LexicalError;
import LexicalAnalyzer.States.Interfaces.IState;
import LexicalAnalyzer.States.Interfaces.NotAcceptanceState;

public class S36 extends NotAcceptanceState {
    public S36(Diccionary diccionary, String buffer) {
        super(diccionary, buffer);
    }

    @Override
    public IState processCharacter(char character) throws LexicalError {
        String buffer = this.validateCharacter(character, false);
        if (IState.isNumeric(character)) {
            return new S37(diccionary, buffer);
        } else {
            return new S40(diccionary, buffer);
        }
    }
}
