package LexicalAnalyzer.States.Interfaces;

import LexicalAnalyzer.Exceptions.LexicalError;
import LexicalAnalyzer.Outputs.BasicOutput;

public interface IState {
    boolean isAcceptanceState();
    int getReturnSpaces();
    String getBuffer();
    BasicOutput getToken(int row, int col);
    IState lambdaTransition();
    IState processCharacter(char character) throws LexicalError;

    static boolean isNumeric(char character) {
        return character >= '0' && character <= '9';
    }

    static boolean isAlphabetic(char character) {
        return (character >= 'a' && character <= 'z') || (character >= 'A' && character <= 'Z');
    }

    static boolean isAlphaNumeric(char character) {
        return IState.isNumeric(character) || IState.isAlphabetic(character);
    }
}
