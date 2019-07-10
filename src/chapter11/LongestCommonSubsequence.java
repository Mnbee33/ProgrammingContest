package chapter11;

public class LongestCommonSubsequence {

    class Lcs {
        String x;
        String y;
        int m;
        int n;

        int[][] c;

        Lcs(String x, String y) {
            m = x.length();
            n = y.length();

            c = new int[m + 1][n + 1];

            this.x = " " + x;
            this.y = " " + y;
        }

        int get() {
            int maxLength = 0;

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (x.charAt(i) == y.charAt(j)) {
                        countUpLcs(c, i, j);
                    } else {
                        setLastLcs(c, i, j);
                    }
                    maxLength = Integer.max(maxLength, c[i][j]);
                }
            }

            return maxLength;
        }

        private void countUpLcs(int[][] c, int i, int j) {
            c[i][j] = c[i - 1][j - 1] + 1;
        }

        private void setLastLcs(int[][] c, int i, int j) {
            c[i][j] = Integer.max(c[i - 1][j], c[i][j - 1]);
        }
    }

    int count;

    LongestCommonSubsequence(int n) {
        count = n;
    }

    String checkPairLines(String[] lines) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i + 1 < count * 2; i += 2) {
            String x = lines[i];
            String y = lines[i + 1];
            result.append(new Lcs(x, y).get());
            result.append(System.lineSeparator());
        }
        return result.toString().trim();
    }
}
