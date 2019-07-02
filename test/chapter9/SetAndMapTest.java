package chapter9;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SetAndMapTest {
    @Test
    void testSet() {
        Set<Integer> set = new TreeSet<>();

        set.add(8);
        set.add(1);
        set.add(7);
        set.add(4);
        set.add(8);
        set.add(4);
        // assertEquals("1,4,7,8", showSetContains(set));
        assertEquals("[1, 4, 7, 8]", set.toString());

        set.remove(7);
        //assertEquals("1,4,8", showSetContains(set));
        assertEquals("[1, 4, 8]", set.toString());

        set.add(2);
        //assertEquals("1,2,4,8", showSetContains(set));
        assertEquals("[1, 2, 4, 8]", set.toString());

        assertFalse(set.contains(10));
    }

    @Test
    void testMap() {
        Map<String, Integer> colormap = new TreeMap<>();

        colormap.put("red", 32);
        colormap.put("blue", 688);
        colormap.put("yellow", 122);

        colormap.put("blue", colormap.get("blue") + 312);
        assertEquals("{blue=1000, red=32, yellow=122}", colormap.toString());

        colormap.put("zebra", 101010);
        colormap.put("white", 0);
        colormap.remove("yellow");
        assertEquals("{blue=1000, red=32, white=0, zebra=101010}", colormap.toString());

        Map.Entry second = getSecondElement(colormap);
        assertEquals("red=32", second.toString());
    }

    private Map.Entry getSecondElement(Map<String, Integer> colormap) {
        int count = 0;
        for (Map.Entry e : colormap.entrySet()) {
            if (count == 1) {
                return e;
            }
            count++;
        }
        return null;
    }

    private String showSetContains(Set<Integer> set) {
        return set.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }
}
