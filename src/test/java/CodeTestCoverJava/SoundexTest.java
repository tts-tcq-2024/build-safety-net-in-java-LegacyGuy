
package CodeTestCoverJava;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

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
    public void testMultipleCharacters() {
        assertEquals("A123", Soundex.generateSoundex("AbCdEfG"));
    }

    @Test
    public void testLowerCase() {
        assertEquals("A123", Soundex.generateSoundex("abcdefg"));
    }

    @Test
    public void testNonAlphabetic() {
        assertEquals("A000", Soundex.generateSoundex("1234$%"));
    }
}
