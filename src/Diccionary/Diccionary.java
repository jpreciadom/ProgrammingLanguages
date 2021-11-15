package Diccionary;

import java.util.HashMap;

public class Diccionary {
    protected final HashMap<Character, Boolean> validCharacters;
    protected final HashMap<String, Boolean> reservedWords;

    public Diccionary() {
        validCharacters = new HashMap<>();
        this.reservedWords = new HashMap<>();
        this.setupReservedWords();
        this.setupValidCharacters();
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
            '\'',
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
            ';',
            ':',
            '(',
            ')',
            '[',
            ']',
            '|',
            '&',
            ',',
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
            "finmientras",
            "finpara",
            "finproceso",
            "finsegun",
            "finsi",
            "finsubproceso",
            "hacer",
            "hasta",
            "leer",
            "logico",
            "mientras",
            "milisegundos",
            "modo",
            "numerico",
            "otro",
            "pantalla",
            "para",
            "paso",
            "proceso",
            "real",
            "segun",
            "segundos",
            "si",
            "sino",
            "subproceso",
            "tecla",
            "verdadero"
        };

        for (String reservedWord : reservedWords) {
            this.reservedWords.put(reservedWord, true);
        }
    }

    public boolean findCharacter(char toCheck) {
        return this.validCharacters.get(toCheck) != null;
    }

    public boolean isReservedWord(String toCheck) {
        return this.reservedWords.get(toCheck) != null;
    }
}
