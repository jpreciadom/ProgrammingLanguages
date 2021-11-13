package LexicalAnalyzer.States;

import Diccionary.Diccionary;
import LexicalAnalyzer.Exceptions.LexicalError;
import LexicalAnalyzer.States.Interfaces.IState;
import LexicalAnalyzer.States.Interfaces.NotAcceptanceState;

public class S0 extends NotAcceptanceState {
    public S0(Diccionary diccionary) {
        super(diccionary, "");
    }

    @Override
    public IState processCharacter(char character) throws LexicalError {
        String buffer = this.validateCharacter(character, true);

        if (IState.isNumeric(character)) {
            return null;
        } else if (IState.isAlphabetic(character)) {
            return null;
        }

        switch (character) {
            case '~':
                return new S1(diccionary, buffer);
            case '=':
                return new S2(diccionary, buffer);
            case '<':
                return new S3(diccionary, buffer);
            case '>':
                return null;
            case '+':
                return null;
            case '-':
                return null;
            case '/':
                return null;
            case '*':
                return null;
            case '%':
                return null;
            case ';':
                return null;
            case ':':
                return null;
            case '(':
                return null;
            case ')':
                return null;
            case '[':
                return null;
            case ']':
                return null;
            case '|':
                return null;
            case '&':
                return null;
            case ',':
                return null;
            case '^':
                return null;
            case '\'':
                return null;
            case '\"':
                return null;
            default:
                throw new LexicalError("Unexpected token found");
        }
    }
}
