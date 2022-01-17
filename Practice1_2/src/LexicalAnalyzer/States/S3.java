package LexicalAnalyzer.States;

import Diccionary.Diccionary;
import LexicalAnalyzer.Exceptions.LexicalError;
import LexicalAnalyzer.States.Interfaces.IState;
import LexicalAnalyzer.States.Interfaces.NotAcceptanceState;

public class S3 extends NotAcceptanceState {
    public S3(Diccionary diccionary, String buffer) {
        super(diccionary, buffer);
    }

    @Override
    public IState processCharacter(char character) throws LexicalError {
        String buffer = validateCharacter(character, true);
        switch (character) {
            case '-':
                return new S4(diccionary, buffer);
            case '>':
                return new S5(diccionary, buffer);
            case '=':
                return new S6(diccionary, buffer);
            default:
                return new S7(diccionary, buffer);
        }
    }
}
