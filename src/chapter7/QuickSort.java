package chapter7;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QuickSort {
    Card[] cardsForQuick;
    int baseIndex;
    int from = 0;
    int to;

    Card[] cardsForMerge;
    private int size;
    private Card[] leftList;
    private Card[] rightList;

    boolean isSuite = false;

    QuickSort(int n, String[] lines) {
        size = n;
        cardsForMerge = createCards(lines);
        cardsForQuick = Arrays.copyOf(cardsForMerge, size);
    }

    public String executeQuickSort() {
        divideAndMergeSort(0, size);
        quickSort(0, size - 1);
        isSuite = compareMergeToQuick();
        return editResult();
    }

    private Card[] createCards(String[] lines) {
        List<Card> cards = Arrays.stream(lines)
                .map(line -> line.split(" "))
                .map(args -> new Card(args[0], args[1]))
                .collect(Collectors.toList());
        cards.add(Card.sentinel());
        return cards.toArray(new Card[cards.size()]);
    }


    void quickSort(int start, int end) {
        if (start < end) {
            partition(start, end);
            quickSort(start, baseIndex - 1);
            quickSort(baseIndex + 1, end);
        }
    }

    void partition(int start, int end) {
        Card base = cardsForQuick[end];
        int smallerEnd = start - 1;
        for (int biggerStart = start; biggerStart < end; biggerStart++) {
            smallerEnd = moveSmallerToFront(base, smallerEnd, biggerStart);
        }
        baseIndex = smallerEnd + 1;
        swap(baseIndex, end);
    }

    private int moveSmallerToFront(Card base, int smallerEnd, int biggerStart) {
        if (cardsForQuick[biggerStart].isLessThan(base)) {
            smallerEnd++;
            swap(smallerEnd, biggerStart);
        }
        return smallerEnd;
    }

    private void swap(int fromIndex, int toIndex) {
        Card temp = cardsForQuick[fromIndex];
        cardsForQuick[fromIndex] = cardsForQuick[toIndex];
        cardsForQuick[toIndex] = temp;
    }

    void divideAndMergeSort(int left, int right) {
        if (left + 1 < right) {
            int middle = (left + right) / 2;
            divideAndMergeSort(left, middle);
            divideAndMergeSort(middle, right);
            mergeSort(left, middle, right);
        }
    }

    void mergeSort(int left, int middle, int right) {
        int leftSize = middle - left;
        int rightSize = right - middle;

        leftList = createPartList(left, leftSize);
        rightList = createPartList(middle, rightSize);

        merge(left, right);
    }

    private Card[] createPartList(int from, int size) {
        Card[] list = new Card[size + 1];
        for (int i = 0; i < size; i++) {
            list[i] = cardsForMerge[from + i];
        }
        list[size] = Card.sentinel();
        return list;
    }

    private void merge(int left, int right) {
        int leftIndex = 0;
        int rightIndex = 0;
        for (int k = left; k < right; k++) {
            if (leftList[leftIndex].isLessThan(rightList[rightIndex])) {
                cardsForMerge[k] = leftList[leftIndex++];
            } else {
                cardsForMerge[k] = rightList[rightIndex++];
            }
        }
    }

    private boolean compareMergeToQuick() {
        for (int i = 0; i < size; i++) {
            if (cardsForMerge[i].isEqualSuite(cardsForQuick[i])) {
                return false;
            }
        }
        return true;
    }

    private String editResult() {
        StringBuilder result = new StringBuilder();
        result.append(isSuite ? "Stable" : "Not stable");
        result.append(System.lineSeparator());

        String cardsLine = Arrays.stream(cardsForQuick)
                .map(Card::toString)
                .collect(Collectors.joining(System.lineSeparator()));
        result.append(cardsLine);

        return result.toString();
    }
}
