package corp.alv.challenges.general.arrays;

import java.util.HashMap;
import java.util.Map;

/*
169. Majority Element
Easy
Topics
Companies
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.



Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2


Constraints:

n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109


Follow-up: Could you solve the problem in linear time and in O(1) space?
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> numsCountMap = new HashMap<>();
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            numsCountMap.put(nums[i], numsCountMap.getOrDefault(nums[i], 0) + 1);
            if (numsCountMap.get(nums[i]) > size / 2) {
                return nums[i];
            }
        }
        return -1;
    }

    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int e : nums) {
            if (numMap.containsKey(e)) {
                numMap.put(e, numMap.get(e) + 1);
            } else {
                numMap.put(e, 1);
            }
        }

        int max = 0;
        int index = -1;

        for (Map.Entry entry : numMap.entrySet()) {
            if ((Integer) entry.getValue() > max) {
                max = (Integer)entry.getValue();
                index = (Integer)entry.getKey();
            }
        }

        return index;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};

        MajorityElement mj = new MajorityElement();
        System.out.println(mj.majorityElement(nums));
        System.out.println(mj.majorityElement2(nums));
    }
}
