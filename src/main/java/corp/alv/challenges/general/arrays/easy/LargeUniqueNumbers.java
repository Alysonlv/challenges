package corp.alv.challenges.general.arrays.easy;

import java.util.HashMap;
import java.util.Map;

/*
1133. Largest Unique Number
Easy
Topics
Companies
Hint
Given an integer array nums, return the largest integer that only occurs once. If no integer occurs once, return -1.



Example 1:

Input: nums = [5,7,3,9,4,9,8,3,1]
Output: 8
Explanation: The maximum integer in the array is 9 but it is repeated. The number 8 occurs only once, so it is the answer.
Example 2:

Input: nums = [9,9,8,8]
Output: -1
Explanation: There is no number that occurs only once.


Constraints:

1 <= nums.length <= 2000
0 <= nums[i] <= 1000
 */
public class LargeUniqueNumbers {

    public int largestUniqueNumber(int[] nums) {
        Map<Integer, Integer> unique = new HashMap<>();

        for (int i : nums) {
            unique.put(i, unique.getOrDefault(i, 0) + 1);
        }

        return unique.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .max(Map.Entry.comparingByKey())
                .map(entry -> entry.getKey())
                .orElse(-1);
    }

    public static void main(String[] args) {
        LargeUniqueNumbers task = new LargeUniqueNumbers();
        int[] nums = new int[] {5,7,3,9,4,9,8,3,1};
        System.out.println(task.largestUniqueNumber(nums));
    }
}
