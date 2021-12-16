package SyntacticAnalyzer.Grammar;

import Diccionary.Diccionary;
import LexicalAnalyzer.Tokens.BasicToken;
import SyntacticAnalyzer.Exceptions.NoDerivationFoundException;

import java.util.*;

public class Grammar {
    protected final HashMap<String, LinkedList<Rule>> rules;
    protected final Diccionary diccionary;

    public Grammar(Diccionary diccionary) {
        this.rules = new HashMap<>();
        this.diccionary = diccionary;
    }

    public HashMap<String, LinkedList<Rule>> getRules() {
        return rules;
    }

    public boolean isTerminal(String symbol) {
        return 'a' <= symbol.charAt(0) && symbol.charAt(0) <= 'z';
    }

    public LinkedList<String> derive(String symbol, BasicToken token) throws NoDerivationFoundException {
        Rule epsilon = null;
        String nonTerminal = token.getTokenType();
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
            StringBuilder errorBuilder = new StringBuilder();
            errorBuilder.append("<").append(token.getRow()) .append(":") .append(token.getCol()) .append(">");
            errorBuilder.append(" Error sintactico: se encontro: \"");
            errorBuilder.append(this.diccionary.getTokenSymbol(token.getTokenType())).append("\";");
            errorBuilder.append(" se esperaba: ");
            for (String expectedToken : this.getExpectedTokens(symbol)) {
                errorBuilder.append('\"').append(this.diccionary.getTokenSymbol(expectedToken)).append('\"').append(", ");
            }
            errorBuilder.setLength(errorBuilder.length() - 2);
            errorBuilder.append('.');
            throw new NoDerivationFoundException(errorBuilder.toString());
        }
    }

    private TreeSet<String> getExpectedTokens(String symbol) {
        TreeSet<String> expectedTokens = new TreeSet<>();
        for (Rule rule : this.rules.get(symbol)) {
            expectedTokens.addAll(rule.getPredictionSet());
        }
        return expectedTokens;
    }
}
