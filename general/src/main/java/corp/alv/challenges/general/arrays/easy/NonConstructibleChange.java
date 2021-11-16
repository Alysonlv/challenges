package corp.alv.challenges.general.arrays.easy;

import java.util.Arrays;

/**
 * Given an array of positive integers representing the values of coins in your possession, write a function
 * that returns the minimum amount of change that you cannot create.
 */
public class NonConstructibleChange {

    static int nonConstructibleChange(int[] coins) {
        Arrays.sort(coins);

        int currentChange = 0;

        for (int coin : coins) {
            if (coin > currentChange + 1) {
                return currentChange + 1;
            }
            currentChange += coin;
        }

        return currentChange + 1;
    }
}
