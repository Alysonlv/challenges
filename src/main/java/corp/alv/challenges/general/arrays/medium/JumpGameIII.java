package corp.alv.challenges.general.arrays.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
Jump Game III
Solved
Medium
Topics
Companies
Hint
Given an array of non-negative integers arr, you are initially positioned at start index of the array. When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach any index with value 0.

Notice that you can not jump outside of the array at any time.



Example 1:

Input: arr = [4,2,3,0,3,1,2], start = 5
Output: true
Explanation:
All possible ways to reach at index 3 with value 0 are:
index 5 -> index 4 -> index 1 -> index 3
index 5 -> index 6 -> index 4 -> index 1 -> index 3
Example 2:

Input: arr = [4,2,3,0,3,1,2], start = 0
Output: true
Explanation:
One possible way to reach at index 3 with value 0 is:
index 0 -> index 4 -> index 1 -> index 3
Example 3:

Input: arr = [3,0,2,1,2], start = 2
Output: false
Explanation: There is no way to reach at index 1 with value 0.


Constraints:

1 <= arr.length <= 5 * 104
0 <= arr[i] < arr.length
0 <= start < arr.length
 */
public class JumpGameIII {
    public boolean canReachDFS(int[] arr, int start) {
        if (start < 0 || start >= arr.length || arr[start] < 0) {
            return false;
        }

        if (arr[start] == 0) {
            return true;
        }

        arr[start] *= -1;

        return canReachDFS(arr, start - arr[start]) || canReachDFS(arr, start + arr[start]);
    }

    public boolean canReachBFS(int[] arr, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int node = q.poll();
            if (arr[node] == 0) {
                return true;
            }

            if (arr[node] < 0) {
                continue;
            }

            if (node - arr[node] >= 0) {
                q.offer(node - arr[node]);
            }

            if (node + arr[node] < arr.length) {
                q.add(node + arr[node]);
            }

            arr[node] = -arr[node];
        }

        return false;
    }

    public static void main(String[] args) {
        JumpGameIII jg = new JumpGameIII();
        int[] arr = new int[] {4,2,3,0,3,1,2};
        System.out.println("Can reach from 5" + Arrays.toString(arr) + " is: " + jg.canReachDFS(arr, 5));

        arr = new int[] {4,2,3,0,3,1,2};
        System.out.println("Can reach from 0 " + Arrays.toString(arr) + " is: " + jg.canReachDFS(arr, 0));

        arr = new int[] {3,0,2,1,2};
        System.out.println("Can reach from 2 " + Arrays.toString(arr) + " is: " + jg.canReachDFS(arr, 2));
    }
}
