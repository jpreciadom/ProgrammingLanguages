package SyntacticAnalyzer;

import Diccionary.Diccionary;
import LexicalAnalyzer.Tokens.BaseToken;
import LexicalAnalyzer.Tokens.BasicToken;
import SyntacticAnalyzer.Exceptions.ErrorBuilder;
import SyntacticAnalyzer.Exceptions.NoDerivationFoundException;
import SyntacticAnalyzer.Exceptions.SyntacticErrorException;
import SyntacticAnalyzer.Exceptions.UnexpectedTokenException;
import SyntacticAnalyzer.Grammar.Grammar;

import java.util.LinkedList;
import java.util.Stack;
import java.util.TreeSet;

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
        try {
            while (this.input.size() > 0) {
                String symbol = this.derivation.pop();
                if (!symbol.equals("")) {
                    if (!this.grammar.isTerminal(symbol)) {
                        this.deriveNextNonTerminal(symbol);
                    } else {
                        BasicToken next = (BasicToken) this.input.removeFirst();
                        this.matchSymbols(next, symbol);
                    }
                }
            }
        } catch (SyntacticErrorException syntacticError) {
            this.output = syntacticError.getMessage();
            return false;
        }

        if (this.derivation.size() > 0) {
            this.output = "Falta algo";
            return false;
        } else {
            this.output = "El analisis sintactico ha finalizado exitosamente.";
            return true;
        }
    }

    private void deriveNextNonTerminal(String symbol) throws NoDerivationFoundException {
        BasicToken next = (BasicToken) this.input.getFirst();
        LinkedList<String> result = this.grammar.derive(symbol, next);

        while (result.size() > 0) {
            this.derivation.push(result.removeLast());
        }
    }

    private void matchSymbols(BasicToken inputSymbol, String derivationSymbol) throws UnexpectedTokenException {
        boolean match = inputSymbol.getTokenType().equals(derivationSymbol);
        if (!match) {
            TreeSet<String> expectedToken = new TreeSet<>();
            expectedToken.add(derivationSymbol);
            throw new UnexpectedTokenException(
                    ErrorBuilder.buildError(
                            this.diccionary,
                            inputSymbol.getRow(),
                            inputSymbol.getCol(),
                            inputSymbol.getTokenType(),
                            expectedToken
                    )
            );
        }
    }
}
