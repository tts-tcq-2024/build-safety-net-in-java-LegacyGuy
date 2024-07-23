package CodeTestCoverJava;

import java.util.HashMap;
import java.util.Map;

public class Soundex {

    private static final Map<Character, Character> soundexMap = createSoundexMap();

    private static Map<Character, Character> createSoundexMap() {
        Map<Character, Character> map = new HashMap<>();
        map.put('B', '1'); map.put('F', '1'); map.put('P', '1'); map.put('V', '1');
        map.put('C', '2'); map.put('G', '2'); map.put('J', '2'); map.put('K', '2');
        map.put('Q', '2'); map.put('S', '2'); map.put('X', '2'); map.put('Z', '2');
        map.put('D', '3'); map.put('T', '3');
        map.put('L', '4');
        map.put('M', '5'); map.put('N', '5');
        map.put('R', '6');
        return map;
    }

    public static String generateSoundex(String name) {
        if (name == null || name.isEmpty()) {
            return "";
        }

        String cleanedName = cleanName(name);
        String soundex = generateInitialSoundex(cleanedName);
        return padSoundexCode(soundex);
    }

    private static String cleanName(String name) {
        return name.replaceAll("[^a-zA-Z]", "").toUpperCase();
    }

    private static String generateInitialSoundex(String name) {
        StringBuilder soundex = new StringBuilder();
        char firstChar = name.charAt(0);
        soundex.append(firstChar);
        char prevCode = getSoundexCode(firstChar);

        generateSoundexForRemainingChars(name, soundex, prevCode);

        return soundex.toString();
    }

    private static void generateSoundexForRemainingChars(String name, StringBuilder soundex, char prevCode) {
        for (int i = 1; i < name.length() && soundex.length() < 4; i++) {
            char currentChar = name.charAt(i);
            processCharacter(soundex, currentChar, prevCode);
            if (soundex.length() == 4) {
                break;
            }
            prevCode = getSoundexCode(currentChar);
        }
    }

    private static void processCharacter(StringBuilder soundex, char currentChar, char prevCode) {
        char currentCode = getSoundexCode(currentChar);
        appendCodeIfValid(soundex, currentCode, prevCode);
    }

    private static void appendCodeIfValid(StringBuilder soundex, char currentCode, char prevCode) {
        if (currentCode != '0' && currentCode != prevCode) {
            soundex.append(currentCode);
        }
    }

    private static String padSoundexCode(String soundex) {
        StringBuilder paddedSoundex = new StringBuilder(soundex);
        while (paddedSoundex.length() < 4) {
            paddedSoundex.append('0');
        }
        return paddedSoundex.toString();
    }

    private static char getSoundexCode(char c) {
        return soundexMap.getOrDefault(c, '0');
    }

    public static void main(String[] args) {
        runTests();
    }

    private static void runTests() {
        assert generateSoundex("").equals("");
        assert generateSoundex("A").equals("A000");
        assert generateSoundex("Ashcraft").equals("A261");
        assert generateSoundex("Pfister").equals("P236");
        assert generateSoundex("Honeyman").equals("H555");
        assert generateSoundex("Bartosz").equals("B620");
        assert generateSoundex("Bartoz").equals("B620");
        assert generateSoundex("Ashcraft").equals(generateSoundex("ashcraft"));
        assert generateSoundex("Robert").equals("R163");
        assert generateSoundex("Rupert").equals("R163");
        assert generateSoundex("Rubin").equals("R150");
        assert generateSoundex("Ashcraft").equals("A261");
        assert generateSoundex("Tymczak").equals("T522");
        assert generateSoundex("Pfister").equals("P236");
        assert generateSoundex("Jackson").equals("J250");
        assert generateSoundex("Tymczak").equals("T522");
        assert generateSoundex("Euler").equals("E460");
        assert generateSoundex("Gauss").equals("G020");
        assert generateSoundex("Hilbert").equals("H416");
        assert generateSoundex("Knuth").equals("K530");
        assert generateSoundex("Lloyd").equals("L300");
        assert generateSoundex("Lukasiewicz").equals("L220");
        System.out.println("All tests passed");
    }
}
