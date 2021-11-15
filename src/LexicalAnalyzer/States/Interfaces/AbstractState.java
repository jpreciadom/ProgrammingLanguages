package LexicalAnalyzer.States.Interfaces;

import Diccionary.Diccionary;
import LexicalAnalyzer.Exceptions.LexicalError;
import LexicalAnalyzer.Exceptions.UnknownToken;

public abstract class AbstractState implements IState {
    protected Diccionary diccionary;
    protected String buffer;

    public  AbstractState(Diccionary diccionary, String buffer) {
        this.diccionary = diccionary;
        this.buffer = buffer;
    }

    @Override
    public String getBuffer() {
        return this.buffer;
    }

    protected String validateCharacter(char character, boolean checkInDictionary) throws UnknownToken {
        if (checkInDictionary && !this.diccionary.findCharacter(character)) {
            throw new UnknownToken();
        }
       return new StringBuffer(this.buffer).append(character).toString();
    }
}
