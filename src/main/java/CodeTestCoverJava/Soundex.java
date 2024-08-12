package CodeTestCoverJava;

import java.util.HashMap;
import java.util.Map;

public class Soundex {

    private static final Map<Character, Character> CHAR_TO_DIGIT_MAP = createCharToDigitMap();

    private static Map<Character, Character> createCharToDigitMap() {
        Map<Character, Character> map = new HashMap<>();
        map.put('B', '1');
        map.put('F', '1');
        map.put('P', '1');
        map.put('V', '1');
        map.put('C', '2');
        map.put('G', '2');
        map.put('J', '2');
        map.put('K', '2');
        map.put('Q', '2');
        map.put('S', '2');
        map.put('X', '2');
        map.put('Z', '2');
        map.put('D', '3');
        map.put('T', '3');
        map.put('L', '4');
        map.put('M', '5');
        map.put('N', '5');
        map.put('R', '6');
        return map;
    }

    public static String generateSoundex(String name) {
        if (isInvalidName(name)) return "";

        StringBuilder soundexCode = new StringBuilder();
        char firstChar = name.toUpperCase().charAt(0);
        soundexCode.append(firstChar);

        processRemainingChars(name, soundexCode);

        return padToFourCharacters(soundexCode).toString();
    }

    private static boolean isInvalidName(String name) {
        return name == null || name.isEmpty();
    }

    private static void processRemainingChars(String name, StringBuilder soundexCode) {
        char prevDigit = mapCharToDigit(name.toUpperCase().charAt(0));

        for (int i = 1; i < name.length(); i++) {
            char currentChar = name.toUpperCase().charAt(i);
            if (Character.isLetter(currentChar)) {
                char currentDigit = mapCharToDigit(currentChar);
                appendIfValid(soundexCode, currentDigit, prevDigit);
                prevDigit = currentDigit;
            }
        }
    }

    private static void appendIfValid(StringBuilder soundexCode, char currentDigit, char prevDigit) {
        if (isValidSoundexCharacter(currentDigit, prevDigit) && soundexCode.length() < 4) {
            soundexCode.append(currentDigit);
        }
    }

    private static char mapCharToDigit(char c) {
        return CHAR_TO_DIGIT_MAP.getOrDefault(c, '0');
    }

    private static boolean isValidSoundexCharacter(char currentDigit, char prevDigit) {
        return currentDigit != '0' && currentDigit != prevDigit;
    }

    private static StringBuilder padToFourCharacters(StringBuilder soundexCode) {
        while (soundexCode.length() < 4) {
            soundexCode.append('0');
        }
        return soundexCode;
    }
}
