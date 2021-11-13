package LexicalAnalyzer.States;

import Diccionary.Diccionary;
import LexicalAnalyzer.Exceptions.LexicalError;
import LexicalAnalyzer.States.Interfaces.IState;
import LexicalAnalyzer.States.Interfaces.NotAcceptanceState;

public class S8 extends NotAcceptanceState {
    public S8(Diccionary diccionary, String buffer) {
        super(diccionary, buffer);
    }

    @Override
    public IState processCharacter(char character) throws LexicalError {
        String buffer = this.validateCharacter(character, true);
        switch (character) {
            case '=':
                return new S9(diccionary, buffer);
            default:
                return new S10(diccionary, buffer);
        }
    }
}
