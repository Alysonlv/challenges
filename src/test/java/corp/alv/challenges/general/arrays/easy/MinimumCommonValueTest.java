package corp.alv.challenges.general.arrays.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumCommonValueTest {
/*
Input: nums1 = [1,2,3], nums2 = [2,4]
Output: 2
Explanation: The smallest element common to both arrays is 2, so we return 2.
Example 2:

Input: nums1 = [1,2,3,6], nums2 = [2,3,4,5]
Output: 2
 */

    MinimumCommonValue task = new MinimumCommonValue();
    @Test
    void getCommon() {
        int[] nums1 = new int[] {1,2,3};
        int[] nums2 = new int[] {2,4};
        assertEquals(2, task.getCommon(nums1, nums2));

        nums1 = new int[] {1,2,3,6};
        nums2 = new int[] {2,3,4,5};
        assertEquals(2, task.getCommon(nums1, nums2));
    }
}