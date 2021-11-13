package Diccionary;

import java.util.HashMap;

public class Diccionary {
    protected final HashMap<Character, Boolean> validCharacters;
    protected final HashMap<String, String> tokens;

    public Diccionary() {
        validCharacters = new HashMap<>();
        tokens = new HashMap<>();
        this.setupTokens();
        this.setupValidCharacters();
    }

    private void setupTokens() {
        this.tokens.put("~", "token_neg");
        this.tokens.put("=", "token_igual");
        this.tokens.put("<-", "token_asig");
        this.tokens.put("<>", "token_diff");
        this.tokens.put("<", "token_menor");
        this.tokens.put(">", "token_mayor");
        this.tokens.put("<=", "token_menor_igual");
        this.tokens.put(">=", "token_mayor_igual");
        this.tokens.put("+", "token_mas");
        this.tokens.put("-", "token_menos");
        this.tokens.put("/", "token_div");
        this.tokens.put("*", "token_mul");
        this.tokens.put("%", "token_mod");
        this.tokens.put(";", "token_pyc");
        this.tokens.put(":", "token_dosp");
        this.tokens.put("(", "token_par_izq");
        this.tokens.put(")", "token_par_der");
        this.tokens.put("[", "token_cor_izq");
        this.tokens.put("]", "token_cor_der");
        this.tokens.put("|", "token_o");
        this.tokens.put("&", "token_y");
        this.tokens.put(",", "token_coma");
        this.tokens.put("^", "token_pot");
    }

    private void setupValidCharacters() {
        // Add all the characters in the tokens
        for (String key: this.tokens.keySet()) {
            for (int i = 0; i < key.length(); i++) {
                this.validCharacters.put(key.charAt(i), true);
            }
        }
        // Add all the alphanumeric characters
        for (int i = '0'; i <= '9'; i++) {
            this.validCharacters.put((char)(i), true);
        }
        for (int i = 'A'; i <= 'Z'; i++) {
            this.validCharacters.put((char)(i), true);
        }
        for (int i = 'a'; i <= 'z'; i++) {
            this.validCharacters.put((char)(i), true);
        }

        // Add others characters
        this.validCharacters.put('\\', true);
        this.validCharacters.put('_', true);
        this.validCharacters.put('\"', true);
        this.validCharacters.put('\'', true);
    }

    public boolean findCharacter(char toCheck) {
        return this.validCharacters.get(toCheck) != null;
    }

    public String getTokenName(String token) {
        return this.tokens.get(token);
    }
}
