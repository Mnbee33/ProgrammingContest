package chapter5;

import java.util.Arrays;

public class ArraysBinarySearch extends BinarySearch {
    public ArraysBinarySearch(int n, Integer[] a) {
        super(n, a);
    }

    public boolean isFound(int key) {
        return Arrays.binarySearch(list, key) > -1;
    }
}
