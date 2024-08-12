package CodeTestCoverJava;

import java.util.HashMap;
import java.util.Map;

public class Soundex {

    private static final Map<Character, Character> soundexMapping = initSoundexMapping();

    private static Map<Character, Character> initSoundexMapping() {
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
        return soundexMapping.getOrDefault(c, '0');
    }
}
