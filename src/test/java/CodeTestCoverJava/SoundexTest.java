package CodeTestCoverJava;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SoundexTest {

    @Test
    public void testEmptyString() {
        assertEquals("", Soundex.generateSoundex(""));
    }

    @Test
    public void testSingleCharacter() {
        assertEquals("A000", Soundex.generateSoundex("A"));
    }

    @Test
    public void testCommonNames() {
        assertEquals("A261", Soundex.generateSoundex("Ashcraft"));
        assertEquals("P236", Soundex.generateSoundex("Pfister"));
        assertEquals("H555", Soundex.generateSoundex("Honeyman"));
    }

    @Test
    public void testSimilarSoundingNames() {
        assertEquals("B620", Soundex.generateSoundex("Bartosz"));
        assertEquals("B620", Soundex.generateSoundex("Bartoz"));
    }

    @Test
    public void testCaseInsensitivity() {
        assertEquals(Soundex.generateSoundex("Ashcraft"), Soundex.generateSoundex("ashcraft"));
    }

    @Test
    public void testNamesWithSpecialCharacters() {
        assertEquals("R163", Soundex.generateSoundex("Robert!"));
        assertEquals("R163", Soundex.generateSoundex("Rupert#"));
        assertEquals("R150", Soundex.generateSoundex("Rubin$"));
    }

    @Test
    public void testNamesWithHyphensOrSpaces() {
        assertEquals("L300", Soundex.generateSoundex("Lloyd-Wright"));
        assertEquals("M620", Soundex.generateSoundex("Mary Jane"));
    }

    @Test
    public void testAdditionalNames() {
        assertEquals("R163", Soundex.generateSoundex("Robert"));
        assertEquals("R163", Soundex.generateSoundex("Rupert"));
        assertEquals("R150", Soundex.generateSoundex("Rubin"));
        assertEquals("A261", Soundex.generateSoundex("Ashcraft"));
        assertEquals("T522", Soundex.generateSoundex("Tymczak"));
        assertEquals("P236", Soundex.generateSoundex("Pfister"));
        assertEquals("J250", Soundex.generateSoundex("Jackson"));
        assertEquals("E460", Soundex.generateSoundex("Euler"));
        assertEquals("G020", Soundex.generateSoundex("Gauss"));
        assertEquals("H416", Soundex.generateSoundex("Hilbert"));
        assertEquals("K530", Soundex.generateSoundex("Knuth"));
        assertEquals("L300", Soundex.generateSoundex("Lloyd"));
        assertEquals("L220", Soundex.generateSoundex("Lukasiewicz"));
    }
}

