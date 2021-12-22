package corp.alv.challenges.general.dynamicprogramming;

/**
 * Given an array of positive integers, return the maximum sum of non-adjacent elements in the array
 * If the array is empty, return 0
 * -> Given array = [75, 105, 120, 75, 90, 135]
 *      return 330, where 75 + 120 + 135, it is ignored and 90 is the adjacent)
 */
public class MaxSubsetSumNoAdjacent {

    public static int maxSubsetSumNoAdjacent(int... array) {
        if (array.length == 0) {
            return 0;
        } else if (array.length == 1) {
            return array[0];
        }

        int second = array[0];
        int first = Math.max(array[0], array[1]);

        for (int i = 2; i < array.length; i++) {
            int current = Math.max(first, second + array[i]);
            second = first;
            first = current;
        }

        return first;
    }

    public static void main(String... args) {
        System.out.println(MaxSubsetSumNoAdjacent.maxSubsetSumNoAdjacent(75, 105, 120, 75, 90, 135)); //330
        System.out.println(MaxSubsetSumNoAdjacent.maxSubsetSumNoAdjacent(30,25,50,55,100,120)); //205
    }

}
