package corp.alv.challenges.general.arrays.easy;

import java.util.Arrays;

/**
 * Write a function that takes in two non-empty arrays of integers, find the pair of numbers (one from each) whose
 * absolute difference is closest to zero, and return an array containing there two numbers, with the number from the
 * first array in the first position.
 * Note that the absolute difference of two integers is the distance between them on the real number line.
 * For example, the absolute difference of -5 and 5 is 10, and the absolute difference of -5 and -4 is 1.
 * You can assume that there will only be one pair of numbers with the smallest difference.
 */
public class SmallestDifference {

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        // Write your code here.
        int[] diffValues = new int[2];
        int left = 0;
        int right = 0;
        int currentDiff = Integer.MAX_VALUE;

        while (left < arrayOne.length && right < arrayTwo.length) {
            int first = arrayOne[left];
            int second = arrayTwo[right];

            int diff = Math.abs(first - second);
            if (first < second) {
                left++;
            } else if (first > second) {
                right++;
            } else {
                return new int[]{first, second};
            }

            if (diff < currentDiff) {
                currentDiff = diff;
                diffValues = new int[]{first, second};
            }
        }
        return diffValues;
    }

    public static void main(String... args) {
        System.out.println(Math.abs(1 - 3));
    }
}
