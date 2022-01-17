package SyntacticAnalyzer.Grammar;

import java.util.LinkedList;
import java.util.TreeSet;

public class Rule {
    protected final String nonTerminal;
    protected final LinkedList<String> derivation;
    protected TreeSet<String> predictionSet;

    public Rule(String nonTerminal, LinkedList<String> derivation) {
        this.nonTerminal = nonTerminal;
        this.derivation = derivation;
        this.predictionSet = new TreeSet<>();
    }

    public String getNonTerminal() {
        return nonTerminal;
    }

    public LinkedList<String> getDerivation() {
        return derivation;
    }

    public TreeSet<String> getPredictionSet() {
        return predictionSet;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(this.nonTerminal).append(" --> ");
        for (String symbol : this.derivation) {
            result.append(symbol).append(" ");
        }
        return result.toString();
    }
}
