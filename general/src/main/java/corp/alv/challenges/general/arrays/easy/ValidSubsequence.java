package corp.alv.challenges.general.arrays.easy;

import java.util.List;

/*
 * Given two non-empty arrays of integers, write a function that determines whether the second array is a subsequence of the first one.
 * A subsequence of an array is a set of numbers that aren't necessarily adjacent in the array but that are in the same order as they appear in the array.
 * For instance, the numbers [1, 3, 4] form a subsequence of the array [1, 2, 3, 4], and so do the numbers [2, 4].
 * Note that a single number in an array and the array itself are both valid subsequence of the array.
 *
 ************ @author @AlgoExpert Solution https://www.algoexpert.io/
 */
public class ValidSubsequence {

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int arrIdx = 0;
        int seqIdx = 0;

        while(arrIdx < array.size() && seqIdx < sequence.size()) {
            if (array.get(arrIdx).equals(sequence.get(seqIdx))) {
                seqIdx++;
            }
            arrIdx++;
        }
        return seqIdx == sequence.size();
    }

}
