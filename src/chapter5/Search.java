package chapter5;

public abstract class Search {
    protected int size;

    Search(int n, Integer[] a) {
        this.size = n;
    }

    public int countMatch(Integer[] t) {
        int total = 0;
        for (int key : t) {
            if (isFound(key)) total++;
        }
        return total;
    }

    abstract boolean isFound(int key);
}
