package corp.alv.challenges.general.stack.hard;

import corp.alv.challenges.utils.Utils;

import java.util.Stack;

/*
1063. Number of Valid Subarrays
Hard
Topics
Companies
Hint
Given an integer array nums, return the number of non-empty subarrays with the leftmost element of the subarray not larger than other elements in the subarray.

A subarray is a contiguous part of an array.



Example 1:

Input: nums = [1,4,2,5,3]
Output: 11
Explanation: There are 11 valid subarrays: [1],[4],[2],[5],[3],[1,4],[2,5],[1,4,2],[2,5,3],[1,4,2,5],[1,4,2,5,3].
Example 2:

Input: nums = [3,2,1]
Output: 3
Explanation: The 3 valid subarrays are: [3],[2],[1].
Example 3:

Input: nums = [2,2,2]
Output: 6
Explanation: There are 6 valid subarrays: [2],[2],[2],[2,2],[2,2],[2,2,2].


Constraints:

1 <= nums.length <= 5 * 104
0 <= nums[i] <= 105
 */
public class NumberOfValidSubarrays {//1 4 2 5 3

    public int validSubarrays(int[] nums) {
        int ans = 0, stack_ptr = 0;
        for (int num : nums) {
            while (stack_ptr > 0 && num < nums[stack_ptr - 1]) {
                stack_ptr--;
            }
            nums[stack_ptr++] = num;
            ans += stack_ptr;
        }
        return ans;
    }

    public int validSubarrays_2(int[] nums) {
        int count = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                //remo from stack add in the count
                count += i - stack.pop();
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            count += nums.length - stack.pop();
        }

        return count;
    }

    public int validSubarrays_3(int[] nums) {
        int count = 0;

        int left = 0;
        int right = 0;

        while (left < nums.length) {
            int leftMost = nums[left];
            int curr = nums[right];
            if (leftMost <= curr) {
                count++;
                right++;
            } else {
                left++;
                right = left;
            }

            if (right == nums.length) {
                left++;
                right = left;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        NumberOfValidSubarrays t = new NumberOfValidSubarrays();

        System.out.println(t.validSubarrays(new int[]{1, 4, 2, 5, 3}));
        System.out.println(t.validSubarrays(new int[]{15, 1, 15, 20, 10, 17, 19, 17}));
    }
}
