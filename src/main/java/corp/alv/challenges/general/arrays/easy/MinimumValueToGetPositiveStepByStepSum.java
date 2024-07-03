package corp.alv.challenges.general.arrays.easy;

import static corp.alv.challenges.utils.Utils.arrayToString;

/**
 * PREFIX SUM
 */

/*
Given an array of integers nums, you start with an initial positive value startValue.

In each iteration, you calculate the step by step sum of startValue plus elements in nums (from left to right).

Return the minimum positive value of startValue such that the step by step sum is never less than 1.



Example 1:

Input: nums = [-3,2,-3,4,2]
Output: 5
Explanation: If you choose startValue = 4, in the third iteration your step by step sum is less than 1.
step by step sum
startValue = 4 | startValue = 5 | nums
  (4 -3 ) = 1  | (5 -3 ) = 2    |  -3
  (1 +2 ) = 3  | (2 +2 ) = 4    |   2
  (3 -3 ) = 0  | (4 -3 ) = 1    |  -3
  (0 +4 ) = 4  | (1 +4 ) = 5    |   4
  (4 +2 ) = 6  | (5 +2 ) = 7    |   2
Example 2:

Input: nums = [1,2]
Output: 1
Explanation: Minimum start value should be positive.
Example 3:

Input: nums = [1,-2,-3]
Output: 5


Constraints:

1 <= nums.length <= 100
-100 <= nums[i] <= 100
 */
public class MinimumValueToGetPositiveStepByStepSum {

    public static int minStartValue(int[] nums) {
        // We use "total" for current step-by-step total, "minVal" for minimum
        // step-by-step total among all sums. Since we always start with
        // startValue = 0, therefore the initial current step-by-step total is 0,
        // thus we set "total" and "minVal" be 0.
        int minVal = 0;
        int total = 0;

        // Iterate over the array and get the minimum step-by-step total.
        for (int num : nums) {

            total += num;
            minVal = Math.min(minVal, total);
        }

        // We have to let the minimum step-by-step total equals to 1,
        // by increasing the startValue from 0 to -minVal + 1,
        // which is just the minimum startValue we want.
        return -minVal + 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {-3,2,-3,4,2};
        System.out.println("Minimal start value for " + arrayToString(arr) + " is " + minStartValue(arr));

        arr = new int[] {1, 2};
        System.out.println("Minimal start value for " + arrayToString(arr) + " is " + minStartValue(arr));

        arr = new int[] {1,-2,-3};
        System.out.println("Minimal start value for " + arrayToString(arr) + " is " + minStartValue(arr));
    }
}
