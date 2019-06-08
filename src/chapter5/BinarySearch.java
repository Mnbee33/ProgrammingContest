package chapter5;

public class BinarySearch extends Search {
    int left;
    int right;
    int middle;

    Integer[] list;

    BinarySearch(int n, Integer[] a) {
        super(n, a);
        list = a;
    }

    public boolean isFound(int key) {
        left = 0;
        right = size;

        while (existsSearchRange()) {
            middle = middle(left, right);
            // printLog();
            if (key == list[middle]) return true;
            halveSearchRange(key);
        }
        return false;
    }

    private void printLog() {
        System.out.println("l:" + left);
        System.out.println("r:" + right);
        System.out.println("m:" + middle);
    }

    boolean existsSearchRange() {
        return left < right;
    }

    int middle(int left, int right) {
        return (left + right) / 2;
    }

    void halveSearchRange(int key) {
        if (key < list[middle]) {
            right = middle;
        } else {
            left = middle + 1;
        }
    }

}
