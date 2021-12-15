package SyntacticAnalyzer;

import Diccionary.Diccionary;
import LexicalAnalyzer.Tokens.BaseToken;
import LexicalAnalyzer.Tokens.BasicToken;
import SyntacticAnalyzer.Exceptions.NoDerivationFound;
import SyntacticAnalyzer.Grammar.Grammar;

import java.util.LinkedList;
import java.util.Stack;

public class SyntacticAnalyzer {
    protected final Diccionary diccionary;
    protected final Grammar grammar;
    protected final LinkedList<BaseToken> input;
    protected final Stack<String> derivation;

    protected String output;

    public SyntacticAnalyzer(Diccionary diccionary, Grammar grammar, LinkedList<BaseToken> input) {
        this.diccionary = diccionary;
        this.grammar = grammar;
        this.input = new LinkedList<>(input);
        this.derivation = new Stack<>();
        this.derivation.push("S");
    }

    public String getOutput() {
        return output;
    }

    public boolean analyze() {
        while (this.input.size() > 0) {
            String symbol = this.derivation.pop();
            if (!symbol.equals("")) {
                if (!this.grammar.isTerminal(symbol)) {
                    try {
                        this.deriveNextNonTerminal(symbol);
                    } catch (NoDerivationFound ex) {
                        this.output = ex.getMessage();
                        return false;
                    }
                } else {
                    BasicToken next = (BasicToken) this.input.removeFirst();
                    this.matchSymbols(next, symbol);
                }
            }
        }

        if (this.derivation.size() > 0) {
            this.output = "Falta algo";
            return false;
        } else {
            this.output = "El analisis sintactico ha finalizado exitosamente.";
            return true;
        }
    }

    private void deriveNextNonTerminal(String symbol) throws NoDerivationFound {
        BasicToken next = (BasicToken) this.input.getFirst();
        LinkedList<String> result = this.grammar.derive(symbol, next.getTokenType());

        while (result.size() > 0) {
            this.derivation.push(result.removeLast());
        }
    }

    private void matchSymbols(BasicToken inputSymbol, String derivationSymbol) {
        boolean match = inputSymbol.getTokenType().equals(derivationSymbol);
    }
}
