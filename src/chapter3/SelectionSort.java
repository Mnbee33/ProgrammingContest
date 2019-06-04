package chapter3;

public class SelectionSort extends Sort {

    SelectionSort(int n, int[] a) {
        super(n, a);
    }

    void sort() {
        for (int startIndex = 0; startIndex < size; startIndex++) {
            int minIndex = startIndex;
            for (int now = startIndex; now < size; now++) {
                if (a[now] < a[minIndex]) {
                    minIndex = now;
                }
            }
            // System.out.println(minIndex);
            // System.out.println(this);
            if (startIndex != minIndex) {
                swap(startIndex, minIndex);
                count++;
            }
        }
    }
}
