package corp.alv.challenges.general.arrays.easy;

import java.util.Arrays;

import static java.lang.Math.abs;

/**
 * Given a sorted array of integers return a new array with the values of the square of each element, also sorted
 */
public class SortedSquaredArray {

    public static int[] sortedSquaredArraySolution1(int[] array) {
        int[] sortedSquaredArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            sortedSquaredArray[i] = array[i] * array[i];
        }

        Arrays.sort(sortedSquaredArray);
        return sortedSquaredArray;
    }

    public static  int[] sortedSquaredArraySolution2(int[] array) {
        int[] sortedSquaredArray = new int[array.length];

        int smallestIndex = 0;
        int largestIndex = array.length - 1;

        for (int i = array.length - 1; i >= 0; i--) {
            int smallest = array[smallestIndex];
            int largest = array[largestIndex];

            if (abs(smallest) > abs(largest)) {
                sortedSquaredArray[i] = smallest * smallest;
                smallestIndex++;
            } else {
                sortedSquaredArray[i] = largest * largest;
                largestIndex--;
            }
        }

        return sortedSquaredArray;
    }

}
