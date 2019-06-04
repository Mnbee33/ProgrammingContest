package chapter3;

import java.util.*;
import java.util.stream.Collectors;

public class StableSort {
    int size;
    String[] source;
    String[] cards;

    StringBuffer result = new StringBuffer();

    StableSort(int n, String[] cards) {
        size = n;
        source = cards;
    }

    void sort() {
        bubbleSortAndPrint();
        result.append(System.lineSeparator());
        selectionSortAndPrint();
    }

    private void bubbleSortAndPrint() {
        cards = Arrays.copyOf(source, size);
        bubbleSort();
        print();
    }

    private void bubbleSort() {
        for (int i = 0; i < size; i++) {
            for (int j = size - 1; j >= i + 1; j--) {
                int from = Integer.valueOf(cards[j].substring(1, 2));
                int to = Integer.valueOf(cards[j - 1].substring(1, 2));

                if (from < to) {
                    swap(j, j - 1);
                }
            }
        }
    }

    private void selectionSortAndPrint() {
        cards = Arrays.copyOf(source, size);
        selectionSort();
        print();
    }

    private void selectionSort(){
        for (int i = 0; i < size; i++) {
            int minIndex = i;
            for (int j = i; j < size; j++) {
                int from = Integer.valueOf(cards[j].substring(1, 2));
                int to = Integer.valueOf(cards[minIndex].substring(1, 2));

                if (from < to) {
                    minIndex = j;
                }
            }
            swap(i, minIndex);
        }
    }

    private boolean isStable() {
        Map<String, List<String>> input = mapByNumber(source);
        Map<String, List<String>> output = mapByNumber(cards);

        boolean isStable = true;
        for (Map.Entry<String, List<String>> e : output.entrySet()) {
            List<String> outputOrder = e.getValue();
            if (outputOrder.size() > 1) {
                List<String> inputOrder = input.get(e.getKey());
                isStable = isSameOrder(outputOrder, inputOrder);
                if (!isStable) {
                    return isStable;
                }
            }
        }
        return isStable;
    }

    private boolean isSameOrder(List<String> outputOrder, List<String> inputOrder) {
        for (int i = 0; i < outputOrder.size(); i++) {
            if (!inputOrder.get(i).equals(outputOrder.get(i))) {
                return false;
            }
        }
        return true;
    }

    private Map<String, List<String>> mapByNumber(String[] list) {
        Map<String, List<String>> counter = new HashMap<>();
        for (String input : list) {
            String number = input.substring(1, 2);
            if (!counter.containsKey(number)) {
                counter.put(number, new ArrayList<>());
            }
            counter.get(number).add(input);
        }
        return counter;
    }

    void swap(int fromIndex, int toIndex) {
        String temp = cards[fromIndex];
        cards[fromIndex] = cards[toIndex];
        cards[toIndex] = temp;
    }

    private void print() {
        String str = Arrays.stream(cards)
                .collect(Collectors.joining(" "));

        result.append(str);
        result.append(System.lineSeparator());
        result.append(isStable() ? "Stable" : "Not stable");
    }

    @Override
    public String toString() {
        return result.toString();
    }
}
