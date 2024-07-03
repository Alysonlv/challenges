package corp.alv.challenges.general.arrays.easy;

import static corp.alv.challenges.utils.Utils.arrayToString;

/**
 * PREFIX SUM
 */
/*
Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).

Return the running sum of nums.



Example 1:

Input: nums = [1,2,3,4]
Output: [1,3,6,10]
Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
Example 2:

Input: nums = [1,1,1,1,1]
Output: [1,2,3,4,5]
Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].
Example 3:

Input: nums = [3,1,2,10,1]
Output: [3,4,6,16,17]


Constraints:

1 <= nums.length <= 1000
-10^6 <= nums[i] <= 10^6
 */
public class RunningSumOf1dArray {

    public static int[] solution(int[] nums) {
        int[] runningSums = new int[nums.length];
        runningSums[0] = nums[0];

        int total = nums[0];
        for (int i = 1; i < nums.length; i++) {
            total += nums[i];
            runningSums[i] = total;
        }

        return runningSums;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4};
        System.out.println("Running sum for [1,2,3,4] =  " + arrayToString(RunningSumOf1dArray.solution(arr)));

        arr = new int[] {1,1,1,1,1};
        System.out.println("Running sum for [1,1,1,1,1] =  " + arrayToString(RunningSumOf1dArray.solution(arr)));

        arr = new int[] {3,1,2,10,1};
        System.out.println("Running sum for [3,1,2,10,1] =  " + arrayToString(RunningSumOf1dArray.solution(arr)));
    }
}
