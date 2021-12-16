package Diccionary;

import java.util.HashMap;

public class Diccionary {
    protected final HashMap<Character, Boolean> validCharacters;
    protected final HashMap<String, Boolean> reservedWords;
    protected final HashMap<String, String> customTokens;
    protected final HashMap<String, String> tokenSymbols;

    public Diccionary() {
        this.validCharacters = new HashMap<>();
        this.reservedWords = new HashMap<>();
        this.customTokens = new HashMap<>();
        this.tokenSymbols = new HashMap<>();
        this.setupValidCharacters();
        this.setupReservedWords();
        this.setupCustomTokens();
        this.setupTokenSymbols();
    }

    private void setupValidCharacters() {
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
        char []validCharacters = {
            '\\',
            '_',
            '\"',
            '\'',
            '~',
            '-',
            '=',
            '<',
            '>',
            '+',
            '/',
            '*',
            '%',
            '.',
            ',',
            ';',
            ':',
            '(',
            ')',
            '[',
            ']',
            '|',
            '&',
            '^',
            ' ',
            '\n',
            '\t'
        };
        for (char validCharacter : validCharacters) {
            this.validCharacters.put(validCharacter, true);
        }
    }

    private void setupReservedWords() {
        String []reservedWords = {
            "algoritmo",
            "borrar",
            "caso",
            "cadena",
            "caracter",
            "como",
            "con",
            "de",
            "definir",
            "dimension",
            "entero",
            "entonces",
            "escribir",
            "esperar",
            "falso",
            "finalgoritmo",
            "finfuncion",
            "finmientras",
            "finpara",
            "finproceso",
            "finsegun",
            "finsi",
            "finsubproceso",
            "funcion",
            "hacer",
            "hasta",
            "leer",
            "limpiar",
            "logico",
            "mod",
            "mientras",
            "milisegundos",
            "modo",
            "no",
            "numerico",
            "numero",
            "o",
            "otro",
            "pantalla",
            "para",
            "paso",
            "proceso",
            "que",
            "real",
            "repetir",
            "segun",
            "segundos",
            "si",
            "sino",
            "subproceso",
            "tecla",
            "texto",
            "verdadero",
            "y"
        };

        for (String reservedWord : reservedWords) {
            this.reservedWords.put(reservedWord, true);
        }
    }

    private void setupCustomTokens() {
        this.customTokens.put("y", "token_y");
        this.customTokens.put("o", "token_o");
        this.customTokens.put("no", "token_neg");
        this.customTokens.put("mod", "token_mod");
    }

    private void setupTokenSymbols() {
        this.tokenSymbols.put("token_neg", "~");
        this.tokenSymbols.put("token_igual", "=");
        this.tokenSymbols.put("token_asig", "<-");
        this.tokenSymbols.put("token_dif", "<>");
        this.tokenSymbols.put("token_menor_igual", "<=");
        this.tokenSymbols.put("token_menor", "<");
        this.tokenSymbols.put("token_mayor_igual", ">=");
        this.tokenSymbols.put("token_mayor", ">");
        this.tokenSymbols.put("token_mas", ">");
        this.tokenSymbols.put("token_menos", "-");
        this.tokenSymbols.put("token_div", "/");
        this.tokenSymbols.put("token_mul", "*");
        this.tokenSymbols.put("token_mod", "%");
        this.tokenSymbols.put("token_pyc", ";");
        this.tokenSymbols.put("token_dosp", ":");
        this.tokenSymbols.put("token_par_izq", "(");
        this.tokenSymbols.put("token_par_der", ")");
        this.tokenSymbols.put("token_cor_izq", "[");
        this.tokenSymbols.put("token_cor_der", "]");
        this.tokenSymbols.put("token_o", "|");
        this.tokenSymbols.put("token_y", "&");
        this.tokenSymbols.put("token_coma", ",");
        this.tokenSymbols.put("token_pot", "^");
        this.tokenSymbols.put("token_cadena", "valor_cadena");
        this.tokenSymbols.put("token_entero", "valor_entero");
        this.tokenSymbols.put("token_real", "valor_real");
        this.tokenSymbols.put("id", "identificador");
        this.tokenSymbols.put("eof", "EOF");
    }

    public boolean findCharacter(char toCheck) {
        return this.validCharacters.get(toCheck) != null;
    }

    public boolean isReservedWord(String toCheck) {
        return this.reservedWords.get(toCheck) != null;
    }

    public boolean isCustomToken(String token) {
        return this.customTokens.get(token) != null;
    }

    public String getCustomToken(String token) {
        return this.customTokens.get(token);
    }

    public String getTokenSymbol(String token) {
        String reg = this.tokenSymbols.get(token);
        return reg == null ? token : reg;
    }
}
