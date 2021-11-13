package LexicalAnalyzer;

import Diccionary.Diccionary;
import LexicalAnalyzer.Exceptions.LexicalError;
import LexicalAnalyzer.Outputs.BaseOutput;
import LexicalAnalyzer.Outputs.BasicOutput;
import LexicalAnalyzer.Outputs.ErrorOutput;
import LexicalAnalyzer.States.Interfaces.IState;
import LexicalAnalyzer.States.S0;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LexicalAnalyzer {
    protected final Diccionary diccionary;
    protected final Scanner input;
    protected IState currentState;
    protected final LinkedList<BaseOutput> output;

    public LexicalAnalyzer(Diccionary diccionary) {
        this.diccionary = diccionary;
        input = new Scanner(System.in);
        currentState = new S0(diccionary);
        output = new LinkedList<>();
    }

    public List<BaseOutput> getOutput() {
        return this.output;
    }

    public boolean analyze() {
        int row = 0;
        while(this.input.hasNext()) {
            row ++;
            String readRow = this.input.nextLine();
            for (int col = 0; col < readRow.length(); col++ ) {
                col ++;
                try {
                    currentState = currentState.processCharacter(readRow.charAt(col));
                } catch (LexicalError lexicalError) {
                    this.output.addLast(new ErrorOutput(row, col + 1));
                    return false;
                }
                if (currentState.isAcceptanceState()) {
                    col -= currentState.getReturnSpaces();
                    this.output.addLast(currentState.getToken(row, col + 1));
                    currentState.lambdaTransition();
                }
            }
        }
        return true;
    }
}
