package SyntacticAnalyzer.Grammar;

import Diccionary.Diccionary;
import SyntacticAnalyzer.Exceptions.GrammarIsNotLL1Exception;

import java.io.InputStream;
import java.util.*;

public class GrammarBuilder extends Grammar {
    protected final Diccionary dictionary;
    protected final InputStream readFrom;

    protected final HashMap<String, LinkedList<RuleBuilder>> rulesInBuilding;
    protected final TreeSet<String> nonTerminals;
    protected final HashMap<String, TreeSet<String>> nonTerminalsFirsts;
    protected final HashMap<String, TreeSet<String>> nonTerminalsFollows;

    public GrammarBuilder (Diccionary dictionary, InputStream readGrammarFrom) {
        super(dictionary);
        this.dictionary = dictionary;
        this.readFrom = readGrammarFrom;
        this.rulesInBuilding = new HashMap<>();
        this.nonTerminals = new TreeSet<>();
        this.nonTerminalsFirsts = new HashMap<>();
        this.nonTerminalsFollows = new HashMap<>();
        this.setup();
    }

    private void setup() {
        this.readGrammar();
        this.calculateFirst();
        this.calculateFollow();
    }

    private void readGrammar() {
        Scanner scanner = new Scanner(this.readFrom);

        while (scanner.hasNext()) {
            // Read the rule from the file, add the left part of the rule to the set, and create the rule
            String []incomingRule = scanner.nextLine().split(",");
            LinkedList<String> incomingRuleDerivation = new LinkedList<>();
            switch (incomingRule.length) {
                case 0:
                    continue;
                case 1:
                    incomingRuleDerivation.addLast("");
                    break;
                default:
                    for (String s : incomingRule[1].split(" ")) {
                        incomingRuleDerivation.addLast(s);
                    }
            }
            this.nonTerminals.add(incomingRule[0]);

            // Add the created rule to the map
            RuleBuilder newRule = new RuleBuilder(incomingRule[0], incomingRuleDerivation);
            LinkedList<RuleBuilder> availableRules = rulesInBuilding.get(incomingRule[0]);
            if (availableRules == null) {
                availableRules = new LinkedList<>();
            }
            availableRules.addLast(newRule);
            rulesInBuilding.put(incomingRule[0], availableRules);
        }
    }

    private void calculateFirst() {
        for (String nonTerminalReg : nonTerminals) {
            for (RuleBuilder ruleReg : rulesInBuilding.get(nonTerminalReg)) {
                for (String nonTerminal : nonTerminals) {
                    for (RuleBuilder rule : rulesInBuilding.get(nonTerminal)) {
                        // Calculate the first set for the current rule
                        TreeSet<String> alphaFirst = rule.getFirstSet();

                        if (Objects.requireNonNull(rule.derivation.peekFirst()).equals("")) {
                            alphaFirst.add("");
                        } else {
                            alphaFirst.addAll(this.calculateFirstOf((LinkedList<String>) rule.derivation.clone()));
                        }

                        // Update the non-terminal first set
                        TreeSet<String> symbolFirst = this.nonTerminalsFirsts.get(rule.getNonTerminal());
                        if (symbolFirst == null) {
                            symbolFirst = new TreeSet<>();
                        }
                        symbolFirst.addAll(alphaFirst);
                        this.nonTerminalsFirsts.put(rule.nonTerminal, symbolFirst);
                    }
                }
            }
        }
    }

    private TreeSet<String> calculateFirstOf(LinkedList<String> symbols) {
        TreeSet<String> first = new TreeSet<>();
        String a1 = symbols.removeFirst();
        if (this.isTerminal(a1)) {
            first.add(a1);
        } else {
            TreeSet<String> alphasFirst = this.nonTerminalsFirsts.get(a1);
            if (alphasFirst == null) {
                return first;
            }

            first.addAll(alphasFirst);
            first.remove("");

            if (alphasFirst.contains("")) {
                if (symbols.size() == 0) {
                    first.add("");
                } else {
                    first.addAll(this.calculateFirstOf(symbols));
                }
            }
        }
        return first;
    }

    private TreeSet<String> getFirstOf(String symbol) {
        TreeSet<String> first;
        if (symbol.equals("") || this.isTerminal(symbol)) {
            first = new TreeSet<>();
            first.add(symbol);
        } else {
            first = this.nonTerminalsFirsts.get(symbol);
        }
        return first;
    }

    private void calculateFollow() {
        for (String nonTerminal : this.nonTerminals) {
            this.nonTerminalsFollows.put(nonTerminal, new TreeSet<String>());
        }
        this.nonTerminalsFollows.get("S").add("$");

        boolean canContinue = true;
        while (canContinue) {
            canContinue = false;
            for (String A : this.nonTerminals) {
                for (String B : this.nonTerminals) {
                    for (RuleBuilder ruleB : this.rulesInBuilding.get(B)) {
                        int idx = ruleB.getDerivation().indexOf(A);
                        if (idx != -1) {
                            TreeSet<String> firstOfBeta;
                            String beta;
                            idx++;
                            if (idx < ruleB.getDerivation().size()) {
                                beta = ruleB.getDerivation().get(idx);
                            } else {
                                beta = "";
                            }
                            firstOfBeta = this.getFirstOf(beta);

                            if (firstOfBeta == null) {
                                System.out.println("Non-terminal " + beta + " wasn't found");
                                System.exit(-1);
                            }

                            TreeSet<String> followOfA = this.nonTerminalsFollows.get(A);
                            int oldSize = followOfA.size();
                            followOfA.addAll(firstOfBeta);
                            followOfA.remove("");
                            if (firstOfBeta.contains("") || beta.equals("")) {
                                followOfA.addAll(this.nonTerminalsFollows.get(B));
                            }
                            this.nonTerminalsFollows.put(A, followOfA);

                            if (oldSize < followOfA.size()) {
                                canContinue = true;
                            }
                        }
                    }
                }
            }
        }

        for (String nonTerminal : this.nonTerminals) {
            for (RuleBuilder rule : this.rulesInBuilding.get(nonTerminal)) {
                rule.setFollowSet(this.nonTerminalsFollows.get(nonTerminal));
            }
        }
    }

    public void verify() throws GrammarIsNotLL1Exception {
        for (String nonTerminal : this.nonTerminals) {
            TreeSet<String> firstOfNonTerminals = new TreeSet<>();
            for (RuleBuilder rule : this.rulesInBuilding.get(nonTerminal)) {
                TreeSet<String> firstOfRule = rule.getFirstSet();
                for (String firsts : firstOfRule) {
                    if (firstOfNonTerminals.contains(firsts)) {
                        StringBuilder error = new StringBuilder()
                                .append("The non-terminal ")
                                .append(nonTerminal)
                                .append(" has the token {")
                                .append(firsts)
                                .append("} repeated in two or more rules ");
                        throw new GrammarIsNotLL1Exception(error.toString());
                    }
                    firstOfNonTerminals.add(firsts);
                }
            }
        }
    }

    public Grammar toGrammar() {
        Grammar grammar = new Grammar(diccionary);
        for (String nonTerminal : this.nonTerminals) {
            grammar.getRules().put(nonTerminal, new LinkedList<>());
            for (RuleBuilder ruleBuilder : this.rulesInBuilding.get(nonTerminal)) {
                grammar.getRules().get(nonTerminal).addLast(ruleBuilder.buildRule());
            }
        }
        return grammar;
    }
}
