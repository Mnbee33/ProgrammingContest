package chapter9;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyDictionaryTest {
    @Test
    void testDictionary() {
        MyDictionary dictionary = new MyDictionary(6);

        StringBuilder expected = new StringBuilder();
        expected.append("yes");
        expected.append(System.lineSeparator());
        expected.append("no");
        expected.append(System.lineSeparator());
        expected.append("yes");

        String actual = dictionary.submitCommands(new String[]{
                "insert AAA",
                "insert AAC",
                "find AAA",
                "find CCC",
                "insert CCC",
                "find CCC",
        });
        assertEquals(expected.toString(), actual);
    }
}