package LexicalAnalyzer.States;

import Diccionary.Diccionary;
import LexicalAnalyzer.Exceptions.LexicalError;
import LexicalAnalyzer.Exceptions.UnexpectedToken;
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
            return new S35(diccionary, buffer);
        } else if (IState.isAlphabetic(character)) {
            return new S41(diccionary, buffer);
        }

        switch (character) {
            case '~':
                return new S1(diccionary, buffer);
            case '=':
                return new S2(diccionary, buffer);
            case '<':
                return new S3(diccionary, buffer);
            case '>':
                return new S8(diccionary, buffer);
            case '+':
                return new S11(diccionary, buffer);
            case '-':
                return new S12(diccionary, buffer);
            case '/':
                return new S14(diccionary, buffer);
            case '*':
                return new S18(diccionary, buffer);
            case '%':
                return new S19(diccionary, buffer);
            case ';':
                return new S20(diccionary, buffer);
            case ':':
                return new S21(diccionary, buffer);
            case '(':
                return new S22(diccionary, buffer);
            case ')':
                return new S23(diccionary, buffer);
            case '[':
                return new S24(diccionary, buffer);
            case ']':
                return new S25(diccionary, buffer);
            case '|':
                return new S26(diccionary, buffer);
            case '&':
                return new S27(diccionary, buffer);
            case ',':
                return new S28(diccionary, buffer);
            case '^':
                return new S29(diccionary, buffer);
            case '\'':
            case '\"':
                return new S30(diccionary, buffer);
            case ' ':
            case '\n':
            case '\t':
                return new S0(diccionary);
            default:
                throw new UnexpectedToken();
        }
    }
}
