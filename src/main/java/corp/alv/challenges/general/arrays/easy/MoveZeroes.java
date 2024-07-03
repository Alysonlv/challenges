package corp.alv.challenges.general.arrays.easy;

/*
Easy
Topics
Companies
Hint
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.



Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]


Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int nonZeroIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != nonZeroIndex) {
                    int temp = nums[nonZeroIndex];
                    nums[nonZeroIndex] = nums[i];
                    nums[i] = temp;
                }
                nonZeroIndex++;
            }
        }
    }
    public void moveZeroes_(int[] nums) {

        if (nums.length == 1) {
            return;
        }

        int nonZeroIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIndex] = nums[i];
                nonZeroIndex++;
            }
        }


        while(nonZeroIndex < nums.length){
            nums[nonZeroIndex] = 0;
            nonZeroIndex++;
        }

    }
}
