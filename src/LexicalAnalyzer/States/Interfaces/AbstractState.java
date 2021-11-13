package LexicalAnalyzer.States.Interfaces;

import Diccionary.Diccionary;
import LexicalAnalyzer.Exceptions.LexicalError;

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

    protected String validateCharacter(char character, boolean checkInDictionary) throws LexicalError {
        if (checkInDictionary && !this.diccionary.findCharacter(character)) {
            throw new LexicalError("Unknown character found");
        }
       return new StringBuffer(this.buffer).append(character).toString();
    }
}
