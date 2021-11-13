import Diccionary.Diccionary;
import LexicalAnalyzer.LexicalAnalyzer;
import LexicalAnalyzer.Outputs.BaseOutput;

public class Main {

    protected static LexicalAnalyzer lexicalAnalyzer;
    protected static Diccionary diccionary;

    public static void main(String[] args) {
        diccionary = new Diccionary();

        lexicalAnalyzer = new LexicalAnalyzer(diccionary);
        lexicalAnalyzer.analyze();

        for(BaseOutput output: lexicalAnalyzer.getOutput()) {
            System.out.println(output.toString());
        }
    }
}
