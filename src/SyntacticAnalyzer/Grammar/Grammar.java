package SyntacticAnalyzer.Grammar;

import SyntacticAnalyzer.Exceptions.NoDerivationFound;

import java.io.InputStream;
import java.util.*;

public class Grammar {
    protected final HashMap<String, LinkedList<Rule>> rules;

    public Grammar() {
        this.rules = new HashMap<>();
    }

    public HashMap<String, LinkedList<Rule>> getRules() {
        return rules;
    }

    public boolean isTerminal(String symbol) {
        return 'a' <= symbol.charAt(0) && symbol.charAt(0) <= 'z';
    }

    public LinkedList<String> derive(String symbol, String nonTerminal) throws NoDerivationFound {
        Rule epsilon = null;
        for (Rule rule : this.rules.get(symbol)) {
            if (rule.getPredictionSet().contains(nonTerminal)) {
                return (LinkedList<String>) rule.getDerivation().clone();
            } else if (rule.getPredictionSet().contains("")) {
                epsilon = rule;
            }
        }

        if (epsilon != null) {
            return (LinkedList<String>) epsilon.getDerivation().clone();
        } else {
            throw new NoDerivationFound("");
        }
    }
}
