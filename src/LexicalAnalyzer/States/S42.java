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
        return 1;
    }

    @Override
    public BasicOutput getToken(int row, int col) {
        this.token = this.buffer.substring(0, this.buffer.length() - 1).toLowerCase();
        if (this.diccionary.isReservedWord(token)) {
            String token;
            if (this.diccionary.isCustomToken(this.token)) {
                token = this.diccionary.getCustomToken(this.token);
            } else {
                token = this.token;
            }
            return new BasicOutput(token, row, col - this.buffer.length() + 1);
        } else {
            return new ComplexOutput("id", this.token, row, col - this.buffer.length() + 1);
        }
    }
}
