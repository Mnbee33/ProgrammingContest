package chapter3;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StableSort {
    int size;
    String[] source;
    String[] bubbleCards;
    String[] selectionCards;

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
        bubbleCards = Arrays.copyOf(source, size);
        bubbleSort(bubbleCards);
        print(bubbleCards, bubbleCards);
    }

    private void bubbleSort(String[] cards) {
        for (int i = 0; i < size; i++) {
            for (int j = size - 1; j >= i + 1; j--) {
                int from = Integer.valueOf(cards[j].substring(1, 2));
                int to = Integer.valueOf(cards[j - 1].substring(1, 2));

                if (from < to) {
                    swap(cards, j, j - 1);
                }
            }
        }
    }

    private void selectionSortAndPrint() {
        selectionCards = Arrays.copyOf(source, size);
        selectionSort(selectionCards);
        print(selectionCards, bubbleCards);
    }

    private void selectionSort(String[] cards) {
        for (int i = 0; i < size; i++) {
            int minIndex = i;
            for (int j = i; j < size; j++) {
                int from = Integer.valueOf(cards[j].substring(1, 2));
                int to = Integer.valueOf(cards[minIndex].substring(1, 2));

                if (from < to) {
                    minIndex = j;
                }
            }
            swap(cards, i, minIndex);
        }
    }

    private boolean isStable(String[] cards1, String[] cards2) {
        return Arrays.equals(cards1, cards2);
    }

    void swap(String[] cards, int fromIndex, int toIndex) {
        String temp = cards[fromIndex];
        cards[fromIndex] = cards[toIndex];
        cards[toIndex] = temp;
    }

    private void print(String[] cards1, String[] cards2) {
        String str = Arrays.stream(cards1)
                .collect(Collectors.joining(" "));

        result.append(str);
        result.append(System.lineSeparator());
        result.append(isStable(cards1, cards2) ? "Stable" : "Not stable");
    }

    @Override
    public String toString() {
        return result.toString();
    }
}
