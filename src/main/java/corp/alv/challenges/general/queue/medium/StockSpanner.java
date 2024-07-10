package corp.alv.challenges.general.queue.medium;

import java.util.ArrayDeque;
import java.util.Iterator;

class StockSpanner {

    ArrayDeque<Integer> prices;

    public StockSpanner() {
        this.prices = new ArrayDeque<>();
    }

    public int next(int price) {
        prices.addLast(price);

        int span = 0;
        Iterator<Integer> iterator = prices.descendingIterator();
        while (iterator.hasNext()) {
            int prevPrice = iterator.next();
            if (prevPrice <= price) {
                span++;
            } else {
                break;
            }
        }

        return span;
    }

    public static void main(String[] args) {
        StockSpanner ss = new StockSpanner();
        //
        int[] prices = new int[]{100, 80, 60, 70, 60, 75, 85};
        //[null,1,1,1,2,1,4,6]
        for (int price : prices) {
            System.out.print(ss.next(price) + ", ");
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
