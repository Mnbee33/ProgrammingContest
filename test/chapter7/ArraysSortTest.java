package chapter7;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArraysSortTest {
    @Test
    void testArraysSort() {
        int[] array = new int[]{8, 6, 9, 10, 7};
        Arrays.sort(array); // Dual-Pivot QuickSort 従来のQuickSortよりも高速
        String result = Arrays.stream(array).mapToObj(String::valueOf).collect(Collectors.joining(" "));
        assertEquals("6 7 8 9 10", result);
    }

    @Test
    void testListSort() {
        List<Integer> list = new ArrayList<>();
        list.add(8);
        list.add(6);
        list.add(9);
        list.add(10);
        list.add(7);

        list.sort(Comparator.comparing(Integer::valueOf));  // 反復マージ・ソート（TimSortを応用したもの）
        String result = list.stream().map(String::valueOf).collect(Collectors.joining(" "));

        assertEquals("6 7 8 9 10", result);
    }
}
