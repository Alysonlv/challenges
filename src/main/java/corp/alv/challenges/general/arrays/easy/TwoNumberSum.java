package corp.alv.challenges.general.arrays.easy;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given an array of ints and a target sum, check if there is any two elements in the array
 * that the sum is equal to the target sum.
 * Solution 3 is the most optimal
 */
public class TwoNumberSum {

    public static int[] twoNumberSum_Solution1(int[] array, int targetSum) {

        HashMap<Integer, Integer> possiblePairs = new HashMap<>();

        for (int i : array) {
            possiblePairs.computeIfAbsent(i, value -> targetSum - value);
        }

        Set<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toSet());
        Optional<Map.Entry<Integer, Integer>> a = possiblePairs
                .entrySet()
                .stream()
                .filter(entry -> list.contains(entry.getValue()))
                .findAny();

        if (a.isPresent()) {
            return new int[] {a.get().getKey(), a.get().getValue()};
        }

        return new int[0];
    }

    public static int[] twoNumberSum_Solution2(int[] array, int targetSum) {
        Set<Integer> nums = new HashSet<>();

        for (int num : array) {
            int possiblePair = targetSum - num;

            if (nums.contains(possiblePair)) {
                return new int[] {num, possiblePair};
            } else {
                nums.add(num);
            }
        }

        return new int[0];
    }

    public static int[] twoNumberSum_Solution3(int[] array, int targetSum) {
        Arrays.sort(array);

        int first = 0;
        int second = array.length - 1;

        while (first < second) {
            int sum = array[first] + array[second];
            if (sum == targetSum) {
                return new int[] {first, second};
            } else if (sum < targetSum) {
                first++;
            } else if (sum > targetSum) {
                second--;
            }
        }

        return new int[0];
    }

    public static void main(String ...args) {
        int[] ints = {1,2,3};
        TwoNumberSum.twoNumberSum_Solution1(ints, 3);
    }

}
