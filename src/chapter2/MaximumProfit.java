package chapter2;

import java.util.ArrayList;
import java.util.List;

public class MaximumProfit {
    static final int MIN_VALUE = -20000000;
    int round;
    List<Integer> list = new ArrayList<>();

    MaximumProfit(int[] r) {
        this.round = r[0];
        for (int i = 1; i < r.length; i++) {
            list.add(r[i]);
        }
    }

    int maximumProfit() {
        int maxProfit = MIN_VALUE;
        int min = list.get(0);

        for (int i = 1; i < round; i++) {
            maxProfit = Math.max(maxProfit, list.get(i) - min);
            min = Math.min(min, list.get(i));
            // System.out.println("" + list.get(i) + maxProfit + min);
        }

        return maxProfit;
    }
}
