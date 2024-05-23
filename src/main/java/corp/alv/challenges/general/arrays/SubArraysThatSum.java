package corp.alv.challenges.general.arrays;

import java.util.HashMap;

/*
you are given an areray arr[] of size n. Find the total co8unt of sub-arrays having their sum equal to 0.

Example [0,0,5,5,0,0]
Output 6
Explanation: [0], [0], [0,0], [0], [0], [0,0]


 */
public class SubArraysThatSum {

    public static int findZeroSumSubarrays(int[] arr) {
        // Initialize a hashmap to store the cumulative sum and its frequency
        HashMap<Integer, Integer> sumFrequency = new HashMap<>();

        int cumulativeSum = 0;
        int count = 0;

        // Initialize the hashmap with zero sum having one occurrence
        sumFrequency.put(0, 1);

        for (int i = 0; i < arr.length; i++) {
            // Update the cumulative sum
            cumulativeSum += arr[i];

            // If the cumulative sum has been seen before, it means there is a subarray summing to zero
            if (sumFrequency.containsKey(cumulativeSum)) {
                count += sumFrequency.get(cumulativeSum);
            }

            // Update the frequency of the cumulative sum in the hashmap
            sumFrequency.put(cumulativeSum, sumFrequency.getOrDefault(cumulativeSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 5, 5, 0, 0};
        System.out.println("Total count of subarrays [0, 0, 5, 5, 0, 0] with sum equal to 0: " + findZeroSumSubarrays(arr));

        arr = new int[]{6, -3, -1, 4, 0};
        System.out.println("Total count of subarrays [6, -3, -1, 4, 0] with sum equal to 0: " + findZeroSumSubarrays(arr));
    }
}
