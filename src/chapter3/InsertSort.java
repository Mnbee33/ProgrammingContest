package chapter3;

import java.util.Arrays;
import java.util.stream.Collectors;

public class InsertSort {
    int round;
    int[] list;
    int now;
    StringBuffer result = new StringBuffer();

    InsertSort(int n, int[] a) {
        round = n;
        list = a;
        setResultLineWithBr();
    }

    String sort() {
        for (now = 1; now < round; now++) {
            int j = now - 1;
            int base = list[now];

            j = swapToEnd(j, base);
            list[j + 1] = base;

            setResultLineWithBr();
        }

        return result.toString();
    }

    private int swapToEnd(int j, int base) {
        while (j >= 0 && list[j] > base) {
            list[j + 1] = list[j];
            j--;
        }
        return j;
    }

    private void setResultLine() {
        result.append(Arrays.stream(list)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));
    }

    private void setResultLineWithBr() {
        setResultLine();
        if (now < round - 1) {
            result.append(System.lineSeparator());
        }
    }
}
