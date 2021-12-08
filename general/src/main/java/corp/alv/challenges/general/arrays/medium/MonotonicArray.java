package corp.alv.challenges.general.arrays.medium;

/*
    FInd if an array is monotonic.
    a monotonic array is entirely non-increasing or non-decreasing when read from left to right
    It means the numbers can be equal and/or greater, or equal and/or lesser
    e.i: [0,1,2] is Monotonic, all numbers are greater than the previous one
         [0,0,1] is Monotonic, the first two are equal but the third one is greater. There is no lesser in the sequence
         [0,2,1] is NON-Monotonic, because 0 to 2 is increasing, but 2 to 1 is drecreasing
         [] is Monotonic
         [1] is Monotonic
 */

public class MonotonicArray {

    private static final int INCREASING = 0;
    private static final int DECREASING = 1;

    public static boolean isMonotonic(int[] array) {
        if (array.length <= 2) {
            return true;
        }

        int direction = -1;
        boolean isMonotonic = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (direction == -1) {
                direction = array[i] == array[i + 1] ? direction : array[i] < array[i + 1] ? DECREASING : INCREASING;
            }
            if (direction == DECREASING && array[i] > array[i + 1]) {
                return false;
            } else if (direction == INCREASING && array[i] < array[i + 1]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String... args) {
        int[] case01 = new int[] {1,2,3};//true
        int[] case02 = new int[] {3,2,1};//true
        int[] case03 = new int[] {};//true
        int[] case04 = new int[] {1};//true
    }
}
