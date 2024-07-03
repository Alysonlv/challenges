package corp.alv.challenges.general.arrays.medium;

import java.util.Arrays;

/*
Jump Game II
Medium
Topics
Companies
You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].

Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:

0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].



Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2


Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 1000
It's guaranteed that you can reach nums[n - 1].
 */
public class JumpGameII {

    public int jump(int[] nums) {
        int jumps = 0;
        int index = 0;
        while (index < nums.length - 1) {
            index = findBestJump(index, nums);
            jumps++;
        }
        return jumps;
    }

    public int findBestJump(int index, int[] nums) {
        int currentElement = nums[index];
        if (index + currentElement >= nums.length - 1) {
            return nums.length;
        }

        int maxIndex = Integer.MIN_VALUE;
        int bestIndexToJump = 0;
        for (int i = index; i <= index + currentElement; i++) {
            if (nums[i] + i >= maxIndex) {
                bestIndexToJump = i;
                maxIndex = nums[i] + i;
            }
        }
        return bestIndexToJump;
    }

    public static void main(String[] args) {
        JumpGameII jg = new JumpGameII();
        int[] arr = new int[] {2,3,1,1,4};
        System.out.println("Minimum jump for " + Arrays.toString(arr) + " is: " + jg.jump(arr));

        arr = new int[] {2,3,0,1,4};
        System.out.println("Minimum jump for " + Arrays.toString(arr) + " is: " + jg.jump(arr));
    }
}
