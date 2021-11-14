package LexicalAnalyzer.States;

import Diccionary.Diccionary;
import LexicalAnalyzer.Exceptions.LexicalError;
import LexicalAnalyzer.States.Interfaces.IState;
import LexicalAnalyzer.States.Interfaces.NotAcceptanceState;

public class S33 extends NotAcceptanceState {
    public S33(Diccionary diccionary, String buffer) {
        super(diccionary, buffer);
    }

    @Override
    public IState processCharacter(char character) throws LexicalError {
        String buffer = this.validateCharacter(character, false);
        switch (character) {
            case '\n':
                return new S32(diccionary, buffer);
            case '\"':
                return new S34(diccionary, buffer);
            default:
                return new S33(diccionary, buffer);
        }
    }
}
