package SyntacticAnalyzer.Exceptions;

import Diccionary.Diccionary;

import java.util.TreeSet;

public abstract class ErrorBuilder {
    public static String buildError(
            Diccionary diccionary,
            int row,
            int col,
            String tokenFound,
            TreeSet<String> expectedTokens
    ) {
        StringBuilder errorBuilder = new StringBuilder();
        errorBuilder.append("<").append(row) .append(":") .append(col) .append(">");
        errorBuilder.append(" Error sintactico: se encontro: \"").append(diccionary.getTokenSymbol(tokenFound)).append("\";");
        errorBuilder.append(" se esperaba: ");
        for (String expectedToken : expectedTokens) {
            errorBuilder.append('\"').append(diccionary.getTokenSymbol(expectedToken)).append('\"').append(", ");
        }
        errorBuilder.setLength(errorBuilder.length() - 2);
        errorBuilder.append('.');
        return errorBuilder.toString();
    }
}
