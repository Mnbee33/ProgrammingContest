package chapter11;

public class MatrixChainMultiplication {
    int size;
    static final int MAX_N = 100;
    private int[][] m;
    private int[] sequence;

    MatrixChainMultiplication(int n) {
        size = n;
        m = new int[MAX_N + 1][MAX_N + 1];
        sequence = new int[MAX_N + 1];

    }

    int minCount(String[] lines) {
        int i = 0;
        for (String line : lines) {
            String[] inputs = line.split(" ");
            sequence[i] = Integer.parseInt(inputs[0]);
            sequence[i + 1] = Integer.parseInt(inputs[1]);
            i += 1;
        }

        for (int l = 2; l <= size; l++) {
            for (i = 1; i <= size; i++) {
                int j = i + l - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    m[i][j] = Integer.min(m[i][j], cost(i, j, k) + sequence[i - 1] * sequence[k] * sequence[j]);
                }
            }
        }

        return m[1][size];
    }

    int cost(int i, int j, int k) {
        return m[i][k] + m[(k + 1)][j];
    }

}
