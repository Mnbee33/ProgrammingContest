package chapter13;

import chapter12.VisitStatus;

public class MinimumSpanningTree {
    int[][] matrics;
    int size;

    MinimumSpanningTree(int n) {
        size = n;
        matrics = new int[size][size];
    }

    int prim() {
        int[] d = new int[size];
        int[] p = new int[size];
        VisitStatus[] status = new VisitStatus[size];
        for (int i = 0; i < size; i++) {
            d[i] = Integer.MAX_VALUE;
            p[i] = -1;
            status[i] = VisitStatus.NOT_YET;
        }

        d[0] = 0;

        int u;
        int minv;
        while (true) {
            minv = Integer.MAX_VALUE;
            u = -1;
            for (int i = 0; i < size; i++) {
                if (minv > d[i] && !status[i].equals(VisitStatus.VISITED)) {
                    u = i;
                    minv = d[i];
                }
            }

            if (u == -1) {
                break;
            }

            status[u] = VisitStatus.VISITED;

            for (int v = 0; v < size; v++) {
                if (!status[v].equals(VisitStatus.VISITED) && matrics[u][v] != Integer.MAX_VALUE) {
                    if (d[v] > matrics[u][v]) {
                        d[v] = matrics[u][v];
                        p[v] = u;
                        status[v] = VisitStatus.VISITING;
                    }
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < size; i++) {
            if (p[i] != -1) {
                sum += matrics[i][p[i]];
            }
        }
        return sum;
    }

    int main(String[] lines) {
        for (int i = 0; i < size; i++) {
            String[] inputs = lines[i].split(" ");
            for (int j = 0; j < size; j++) {
                int weight = Integer.parseInt(inputs[j]);
                matrics[i][j] = (weight == -1 ? Integer.MAX_VALUE : weight);
            }
        }
        return prim();
    }
}
