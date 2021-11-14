package LexicalAnalyzer.States;

import Diccionary.Diccionary;
import LexicalAnalyzer.Outputs.BasicOutput;
import LexicalAnalyzer.Outputs.ComplexOutput;
import LexicalAnalyzer.States.Interfaces.AcceptanceState;

public class S42 extends AcceptanceState {
    public S42(Diccionary diccionary, String buffer) {
        super(diccionary, buffer);
    }

    @Override
    public int getReturnSpaces() {
        return 0;
    }

    @Override
    public BasicOutput getToken(int row, int col) {
        this.token = this.buffer.substring(0, this.buffer.length() - 1).toLowerCase();
        System.out.println("I've found the following id or reserved word: " + this.token);
        if (this.diccionary.isReservedWord(token)) {
            return new BasicOutput(this.token, row, col - this.buffer.length() + 1);
        } else {
            return new ComplexOutput("id", this.token, row, col - this.buffer.length() + 1);
        }
    }
}
