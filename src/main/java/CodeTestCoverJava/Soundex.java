package CodeTestCoverJava;

import java.util.HashMap;
import java.util.Map;

public class Soundex {

    private static final Map<Character, Character> CHAR_TO_DIGIT_MAP = new HashMap<>();

    static {
        CHAR_TO_DIGIT_MAP.put('B', '1');
        CHAR_TO_DIGIT_MAP.put('F', '1');
        CHAR_TO_DIGIT_MAP.put('P', '1');
        CHAR_TO_DIGIT_MAP.put('V', '1');
        CHAR_TO_DIGIT_MAP.put('C', '2');
        CHAR_TO_DIGIT_MAP.put('G', '2');
        CHAR_TO_DIGIT_MAP.put('J', '2');
        CHAR_TO_DIGIT_MAP.put('K', '2');
        CHAR_TO_DIGIT_MAP.put('Q', '2');
        CHAR_TO_DIGIT_MAP.put('S', '2');
        CHAR_TO_DIGIT_MAP.put('X', '2');
        CHAR_TO_DIGIT_MAP.put('Z', '2');
        CHAR_TO_DIGIT_MAP.put('D', '3');
        CHAR_TO_DIGIT_MAP.put('T', '3');
        CHAR_TO_DIGIT_MAP.put('L', '4');
        CHAR_TO_DIGIT_MAP.put('M', '5');
        CHAR_TO_DIGIT_MAP.put('N', '5');
        CHAR_TO_DIGIT_MAP.put('R', '6');
    }

    public static String generateSoundex(String name) {
        if (name == null || name.isEmpty()) return "";
        
        String upperName = name.toUpperCase();
        StringBuilder soundexCode = new StringBuilder();
        soundexCode.append(upperName.charAt(0));

        char prevDigit = mapCharToDigit(upperName.charAt(0));

        for (int i = 1; i < upperName.length(); i++) {
            char currentChar = upperName.charAt(i);
            if (!Character.isLetter(currentChar)) continue;

            char currentDigit = mapCharToDigit(currentChar);
            if (isValidSoundexCharacter(currentDigit, prevDigit)) {
                soundexCode.append(currentDigit);
            }

            prevDigit = currentDigit;

            if (soundexCode.length() == 4) break;
        }

        return padToFourCharacters(soundexCode).toString();
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
