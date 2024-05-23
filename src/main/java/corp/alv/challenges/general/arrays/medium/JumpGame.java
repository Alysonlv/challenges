package corp.alv.challenges.general.arrays.medium;

/*
Jump Game
Medium
Topics
Companies
You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.



Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.


Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 105
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        int index = 0;

        while (index < nums.length) {
            int jump = nums[index];
            if (index + jump > nums.length - 1 || jump == 0) {
                break;
            }
            index += jump - 1;
        }

        return index == nums.length - 1;
    }

    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        System.out.println("[2,3,1,1,4] = " + jumpGame.canJump(new int[] {2,3,1,1,4}));
        System.out.println("[3,2,1,0,4] = " + jumpGame.canJump(new int[] {3,2,1,0,4}));
        System.out.println("[2, 0] = " + jumpGame.canJump(new int[] {2, 0}));
    }
}
