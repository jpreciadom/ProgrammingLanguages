package Diccionary;

import java.util.HashMap;

public class Diccionary {
    protected final HashMap<Character, Boolean> validCharacters;
    protected final HashMap<String, Boolean> reservedWords;
    protected final HashMap<String, String> customTokens;

    public Diccionary() {
        this.validCharacters = new HashMap<>();
        this.reservedWords = new HashMap<>();
        this.customTokens = new HashMap<>();
        this.setupValidCharacters();
        this.setupReservedWords();
        this.setupCustomTokens();
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
            '\n'
        };
        for (char validCharacter : validCharacters) {
            this.validCharacters.put(validCharacter, true);
        }
    }

    private void setupReservedWords() {
        String []reservedWords = {
            "algoritmo",
            "borrar",
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
}
