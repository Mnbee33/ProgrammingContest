package chapter5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinerSearch {
    int size;
    List<Integer> list;

    LinerSearch(int size, Integer[] list) {
        this.size = size;
        List<Integer> arrays = Arrays.asList(list);
        this.list = new ArrayList<>(arrays);
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


    boolean isFound(int key) {
        setSearchTarget(key);
        return isFoundByLinerSearch(key);
    }

    public int countMatch(Integer[] t) {
        int total = 0;
        for (int key : t) {
            if (isFound(key)) total++;
        }
        return total;
    }
}
