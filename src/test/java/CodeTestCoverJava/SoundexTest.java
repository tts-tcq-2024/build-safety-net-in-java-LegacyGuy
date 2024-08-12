package CodeTestCoverJava;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SoundexTest {

    @Test
    public void testEmptyAndNullInputs() {
        Assertions.assertEquals("", Soundex.generateSoundex(null));
        Assertions.assertEquals("", Soundex.generateSoundex(""));
    }

    @Test
    public void testSingleCharacter() {
        Assertions.assertEquals("A000", Soundex.generateSoundex("A"));
    }

    @Test
    public void testRegularNames() {
        Assertions.assertEquals("A500", Soundex.generateSoundex("An"));
        Assertions.assertEquals("A510", Soundex.generateSoundex("Amp"));
        Assertions.assertEquals("H410", Soundex.generateSoundex("Help"));
        Assertions.assertEquals("J250", Soundex.generateSoundex("Jackson"));
        Assertions.assertEquals("P236", Soundex.generateSoundex("Pfister"));
        Assertions.assertEquals("H555", Soundex.generateSoundex("Honeyman"));
    }

    @Test
    public void testSpecialCharacters() {
        Assertions.assertEquals("R000", Soundex.generateSoundex("R@#*("));
    }

    @Test
    public void testSimilarSounds() {
        Assertions.assertEquals("R163", Soundex.generateSoundex("Robert"));
        Assertions.assertEquals("R163", Soundex.generateSoundex("Rupert"));
    }

    @Test
    public void testDifferentNames() {
        Assertions.assertEquals("M460", Soundex.generateSoundex("Martin"));
        Assertions.assertEquals("R150", Soundex.generateSoundex("Rubin"));
    }
}
