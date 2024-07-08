package CodeTestCoverJava;

import java.util.HashMap;
import java.util.Map;

public class Soundex {

    private static final Map<Character, Character> soundexMap = new HashMap<>();
    
    static {
        soundexMap.put('B', '1');
        soundexMap.put('F', '1');
        soundexMap.put('P', '1');
        soundexMap.put('V', '1');
        soundexMap.put('C', '2');
        soundexMap.put('G', '2');
        soundexMap.put('J', '2');
        soundexMap.put('K', '2');
        soundexMap.put('Q', '2');
        soundexMap.put('S', '2');
        soundexMap.put('X', '2');
        soundexMap.put('Z', '2');
        soundexMap.put('D', '3');
        soundexMap.put('T', '3');
        soundexMap.put('L', '4');
        soundexMap.put('M', '5');
        soundexMap.put('N', '5');
        soundexMap.put('R', '6');
    }

    public static String generateSoundex(String name) {
        if (name == null || name.isEmpty()) {
            return "";
        }

        StringBuilder soundex = new StringBuilder();
        soundex.append(Character.toUpperCase(name.charAt(0)));
        char prevCode = getSoundexCode(name.charAt(0));

        for (int i = 1; i < name.length() && soundex.length() < 4; i++) {
            char code = getSoundexCode(name.charAt(i));
            if (code != '0' && code != prevCode) {
                soundex.append(code);
                prevCode = code;
            }
        }

        while (soundex.length() < 4) {
            soundex.append('0');
        }

        return soundex.toString();
    }

    private static char getSoundexCode(char c) {
        c = Character.toUpperCase(c);
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
        System.out.println("All tests passed");
    }
}
