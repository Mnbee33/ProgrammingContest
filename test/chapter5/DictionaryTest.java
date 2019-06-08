package chapter5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DictionaryTest {
    @Test
    void testFirstHash() {
        MyDictionary dictionary = new MyDictionary();
        assertEquals(1, dictionary.firstHash(8, 7));
    }

    @Test
    void testSecondHash() {
        MyDictionary dictionary = new MyDictionary();
        assertEquals(3, dictionary.secondHash(8, 7));
    }

    @Test
    void testGetChar() {
        MyDictionary dictionary = new MyDictionary();
        assertEquals(1, dictionary.getChar('A'));
        assertEquals(2, dictionary.getChar('C'));
        assertEquals(3, dictionary.getChar('G'));
        assertEquals(4, dictionary.getChar('T'));
        assertEquals(0, dictionary.getChar('B'));
    }

    @Test
    void testGetKey() {
        MyDictionary dictionary = new MyDictionary();
        assertEquals(1, dictionary.getKey("A")); // 1
        assertEquals(11, dictionary.getKey("AC"));  // 1 + (5 * 2)
    }

    @Test
    void testInsert() {
        MyDictionary dictionary = new MyDictionary();
        dictionary.insert("AC");
        int hash = dictionary.hash(11, 1046527, 0);
        assertEquals("AC", dictionary.data[hash]);

        dictionary.insert("AC");
        hash = dictionary.hash(11, 1046527, 1);
        assertEquals(null, dictionary.data[hash]);
    }

    @Test
    void testHash() {
        MyDictionary dictionary = new MyDictionary();
        assertEquals(4, dictionary.hash(8, 7, 1));
    }

    @Test
    void testIsFound() {
        MyDictionary dictionary = new MyDictionary();
        dictionary.insert("AC");
        assertTrue(dictionary.isFound("AC"));
        assertFalse(dictionary.isFound("ACC"));
    }

    @Test
    void testCommand() {
        MyDictionary dictionary = new MyDictionary();
        assertEquals("", dictionary.command("insert AAA"));
        assertEquals("yes" + System.lineSeparator(), dictionary.command("find AAA"));
        assertEquals("no" + System.lineSeparator(), dictionary.command("find AAC"));
    }

    @Test
    void testAll() {
        MyDictionary dictionary = new MyDictionary();

        String[] input = {
                "6",
                "insert AAA",
                "insert AAC",
                "find AAA",
                "find CCC",
                "insert CCC",
                "find CCC",
        };

        StringBuilder result = new StringBuilder();
        result.append("yes");
        result.append(System.lineSeparator());
        result.append("no");
        result.append(System.lineSeparator());
        result.append("yes");

        assertEquals(result.toString(), dictionary.commandAll(input));
    }
}
