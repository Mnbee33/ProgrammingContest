package chapter5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinerSearch extends Search {
    List<Integer> list;

    LinerSearch(int size, Integer[] a) {
        super(size, a);
        List<Integer> arrays = Arrays.asList(a);
        this.list = new ArrayList<>(arrays);
    }

    boolean isFound(int key) {
        setSearchTarget(key);
        return isFoundByLinerSearch(key);
    }

    int listEnd() {
        return list.get(list.size() - 1);
    }

    void setSearchTarget(int key) {
        list.add(size, key);
    }

    boolean isFoundByLinerSearch(int key) {
        int i = 0;
        while (list.get(i) != key) i++;
        return i != size;
    }
}
