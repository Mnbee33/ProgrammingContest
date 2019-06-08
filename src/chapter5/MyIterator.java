package chapter5;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MyIterator {

    public String trim(String line) {
        String[] chars = line.split(" ");
        return Arrays.stream(chars).collect(Collectors.joining());
    }
}
