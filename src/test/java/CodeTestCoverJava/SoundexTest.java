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
}
