package corp.alv.challenges.hackerrank;

import java.util.Arrays;
import java.util.List;

public class StockProblem {
    public static long maxProfit(List<Long> prices) {

/*
5 6 7 1 15 17 10 11 10 22 15 12 13
*/
        //0 1 2 3 4  5  6
        // 3 2 3 4 40 5 6


        if (prices == null || prices.size() < 6) {
            return 0;
        }

        long maxSellPrice = prices.get(5);
        long minBuyPrice = prices.get(0);
        long max = maxSellPrice - minBuyPrice;
        int start = 0;

        for (int i = 5; i < prices.size(); i++) {
            maxSellPrice = Math.max(maxSellPrice, prices.get(i));// 5x5 5x6
            while (start < i - 5) {
                start++;
                if (prices.get(start) < minBuyPrice) {
                    minBuyPrice = prices.get(start);
                    break;
                }
            }
            max = Math.max(max, maxSellPrice - minBuyPrice);
        }

        return max > 0 ? max : 0;
    }

    public static void main(String[] args) {
        List<Long> prices = Arrays.asList(3L, 2L, 3L, 4L, 40L, 5L, 6L);

        System.out.println(StockProblem.maxProfit(prices));
    }
}
