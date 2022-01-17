package LexicalAnalyzer.States;

import Diccionary.Diccionary;
import LexicalAnalyzer.Exceptions.LexicalError;
import LexicalAnalyzer.Exceptions.UnexpectedToken;
import LexicalAnalyzer.States.Interfaces.IState;
import LexicalAnalyzer.States.Interfaces.NotAcceptanceState;

public class S35 extends NotAcceptanceState {
    public S35(Diccionary diccionary, String buffer) {
        super(diccionary, buffer);
    }

    @Override
    public IState processCharacter(char character) throws LexicalError {
        String buffer = this.validateCharacter(character, true);
        if (IState.isAlphabetic(character)) {
            throw new UnexpectedToken();
        } else if (IState.isNumeric(character)) {
            return new S35(diccionary, buffer);
        } else if (character == '.') {
            return new S36(diccionary, buffer);
        } else {
            return new S39(diccionary, buffer);
        }
    }
}
