package chapter7;

import java.util.Arrays;

public class MinimumCostSort {
    int size;
    int[] a;
    boolean[] hadSorted;
    private static final int VALUE_MAX = 10000;

    public MinimumCostSort(int n, int[] a) {
        size = n;
        this.a = a;
        hadSorted = new boolean[size];
    }

    int solve() {
        int answer = 0;
        int[] costs = createCostByNumbers(a);

        for (int i = 0; i < size; i++) {
            if (hadSorted[i]) continue;
            int current = i;
            int sum = 0;
            int min = VALUE_MAX;
            int elements = 0;
            while (true) {
                hadSorted[current] = true;
                elements++;
                int value = a[current];
                min = Integer.min(min, value);
                sum += value;
                current = costs[value];
                if (hadSorted[current]) break;
            }

            answer += calculateCosts(sum, min, elements);
        }

        return answer;
    }

    private int calculateCosts(int sum, int min, int elements) {
        return Integer.min(calculateCostsByCycle(sum, min, elements), calculateCostsByMinimum(sum, min, elements));
    }

    private int calculateCostsByCycle(int sum, int min, int elements) {
        return sum + (elements - 2) * min;
    }

    private int calculateCostsByMinimum(int sum, int min, int elements) {
        return min + sum + (elements + 1) * sum;
    }

    private int[] createCostByNumbers(int[] a) {
        int[] b = a.clone();
        Arrays.sort(b);

        int[] costByNumbers = new int[VALUE_MAX + 1];
        for (int i = 0; i < size; i++) {
            costByNumbers[b[i]] = i;
        }
        return costByNumbers;
    }
}
