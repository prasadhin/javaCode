import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnagramTest {
    private Anagram1 anagram;

    @BeforeEach
    void setUp() {
        anagram = new Anagram1();
    }

    @AfterEach
    void tearDown() {
        anagram = null;
    }

    @Test
    void testCheckifAnagram() {
        String firstString = "Hitlers is good";
        String secondString = "good is Hirelts";
        String expectedResult = "Anagram";
        assertEquals(expectedResult,anagram.checkifAnagram(firstString,secondString));
    }

    @Test
    void testCheckifNotAnagram() {
        String firstString = "Hitlers is good";
        String secondString = "good si Hielt";
        String expectedResult = "Not a Anagram";
        assertEquals(expectedResult,anagram.checkifAnagram(firstString,secondString));
        //assertTrue(expectedResult.equalsIgnoreCase(anagram.checkifAnagram(firstString,secondString)));
    }
}