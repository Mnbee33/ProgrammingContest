package chapter3;

public class BubbleSort extends Sort {

    BubbleSort(int n, int[] a) {
        super(n, a);
    }

    void sort() {
        boolean hasNext = true;

        while (hasNext) {
            hasNext = false;
            for (int j = size - 1; j > 0; j--) {
                // System.out.println(j);
                if (a[j] < a[j - 1]) {
                    swap(j, j - 1);
                    count++;
                    hasNext = true;
                    // System.out.println(toString());
                }
            }
        }
    }
}
