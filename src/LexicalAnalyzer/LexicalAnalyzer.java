package LexicalAnalyzer;

import Diccionary.Diccionary;
import LexicalAnalyzer.Exceptions.LexicalError;
import LexicalAnalyzer.Exceptions.UnexpectedToken;
import LexicalAnalyzer.Exceptions.UnknownToken;
import LexicalAnalyzer.Tokens.BaseToken;
import LexicalAnalyzer.Tokens.BasicToken;
import LexicalAnalyzer.Tokens.ErrorToken;
import LexicalAnalyzer.States.Interfaces.IState;
import LexicalAnalyzer.States.S0;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.Scanner;

public class LexicalAnalyzer {
    protected final Diccionary diccionary;
    protected final Scanner input;
    protected IState currentState;
    protected final LinkedList<BaseToken> output;

    public LexicalAnalyzer(Diccionary diccionary, InputStream readFrom) {
        this.diccionary = diccionary;
        input = new Scanner(readFrom);
        currentState = new S0(diccionary);
        output = new LinkedList<>();
    }

    public LinkedList<BaseToken> getOutput() {
        return this.output;
    }

    public boolean analyze() {
        int row = 0;
        while(this.input.hasNext()) {
            row ++;
            int col = 0;
            String readRow = new StringBuilder(this.input.nextLine()).append('\n').toString();
            while (col < readRow.length()) {
                try {
                    currentState = currentState.processCharacter(readRow.charAt(col));
                } catch (LexicalError lexicalError) {
                    if (lexicalError instanceof UnexpectedToken) {
                        this.output.addLast(new ErrorToken(row, col + 1 - currentState.getBuffer().length()));
                    } else if (lexicalError instanceof UnknownToken) {
                        this.output.addLast(new ErrorToken(row, col + 1));
                    }
                    return false;
                }
                if (currentState.isAcceptanceState()) {
                    BasicToken token = currentState.getToken(row, col + 1);
                    if (token != null) {
                        this.output.addLast(currentState.getToken(row, col + 1));
                    }
                    col -= currentState.getReturnSpaces();
                    currentState = currentState.lambdaTransition();
                }
                col++;
            }
        }
        return true;
    }
}
