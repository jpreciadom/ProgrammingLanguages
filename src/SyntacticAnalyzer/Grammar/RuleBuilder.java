package SyntacticAnalyzer.Grammar;

import java.util.LinkedList;
import java.util.TreeSet;

public class RuleBuilder extends Rule {
    protected final TreeSet<String> firstSet;
    protected TreeSet<String> followSet;

    public void setFollowSet(TreeSet<String> followSet) {
        this.followSet = followSet;
    }

    public TreeSet<String> getFirstSet() {
        return firstSet;
    }

    public TreeSet<String> getFollowSet() {
        return followSet;
    }

    public RuleBuilder(String nonTerminal, LinkedList<String> derivation) {
        super(nonTerminal, derivation);
        this.firstSet = new TreeSet<>();
        this.followSet = new TreeSet<>();
    }

    public Rule buildRule() {
        Rule rule = new Rule(this.nonTerminal, this.derivation);
        TreeSet<String> predictionSet = rule.getPredictionSet();
        if (this.firstSet.contains("")) {
            predictionSet.addAll(this.firstSet);
            predictionSet.remove("");
            predictionSet.addAll(this.followSet);
        } else {
            predictionSet.addAll(this.firstSet);
        }
        return rule;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        builder.append("| PRIMEROS = {");
        for (String first : this.firstSet) {
            builder.append(first).append(", ");
        }
        builder.setLength(builder.length() - 2);
        builder.append("}");
        builder.append(" | SIGUIENTES = {");
        for (String follow : this.followSet) {
            builder.append(follow).append(", ");
        }
        builder.setLength(builder.length() - 2);
        builder.append("}");
        return builder.toString();
    }
}
