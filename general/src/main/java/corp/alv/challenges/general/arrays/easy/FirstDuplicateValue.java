package corp.alv.challenges.general.arrays.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers between 1 and n, inclusive, where n is the length of the array.
 * Write a function that return the first integer that appears more than once (left to right).
 * If none, return -1
 */
public class FirstDuplicateValue {

    public static int firstDuplicateValueSolution1(int[] array) {
        Set<Integer> nums = new HashSet<>();

        for (int value : array) {
            if (!nums.add(value)){
                return value;
            }
        }
        return -1;
    }

    //best solution
    public static int firstDuplicateValueSolution2(int[] array) {
        for (int value : array) {
            int abs = Math.abs(value);
            if (array[abs - 1] < 0) {
                return abs;
            }

            array[abs - 1] *= -1;
        }
        return -1;
    }

}
