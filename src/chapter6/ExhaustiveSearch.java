package chapter6;

public class ExhaustiveSearch {
    int[] a;

    public ExhaustiveSearch(int[] a) {
        this.a = a;
    }

    boolean solve(int i, int m) {
        if (canMakeCombination(m)) return true;
        if (cannotMakeCombination(i)) return false;
        return nextWithoutSelectingThisNumber(i, m) || nextWithSelectingThisNumber(i, m);
    }

    private boolean cannotMakeCombination(int i) {
        return i >= a.length;
    }

    private boolean canMakeCombination(int m) {
        return m == 0;
    }

    private boolean nextWithoutSelectingThisNumber(int i, int m) {
        return solve(i + 1, m);
    }

    private boolean nextWithSelectingThisNumber(int i, int m) {
        return solve(i + 1, m - a[i]);
    }

    public String solveAll(int[] list) {
        StringBuilder result = new StringBuilder();

        for (int m : list) {
            result.append(solve(0, m) ? "yes" : "no");
            result.append(System.lineSeparator());
        }

        return result.toString().trim();
    }
}
