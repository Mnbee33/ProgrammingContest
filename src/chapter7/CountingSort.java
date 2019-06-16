package chapter7;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CountingSort {
    private int size;
    private int[] sortTargetList;
    private int[] newList;
    private int[] cumulativeSumList;

    CountingSort(int n, int[] a) {
        size = n;
        sortTargetList = a;
        newList = new int[size];
        cumulativeSumList = new int[10001];
    }

    public void sort() {
        countEveryNumber();
        calculateCumulativeSum();
        creteNewListInCountOrder();
    }

    void countEveryNumber() {
        for (int i = 0; i < size; i++) {
            cumulativeSumList[sortTargetList[i]]++;
        }
    }

    void calculateCumulativeSum() {
        for (int i = 1; i < cumulativeSumList.length; i++) {
            cumulativeSumList[i] = cumulativeSumList[i] + cumulativeSumList[i - 1];
        }
    }

    void creteNewListInCountOrder() {
        for (int i = 0; i < size; i++) {
            newList[getLastIndexByCountList(i)] = sortTargetList[i];
            decrementCount(i);
        }
    }

    private void decrementCount(int i) {
        cumulativeSumList[sortTargetList[i]]--;
    }

    private int getLastIndexByCountList(int index) {
        return cumulativeSumList[sortTargetList[index]] - 1;
    }

    @Override
    public String toString() {
        String result = Arrays.stream(newList)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
        return result;
    }
}
