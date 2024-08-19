package corp.alv.challenges.general.graphs.medium;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/*
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

    private class JumpGameState {
        private int index;
        private boolean up;
        private boolean down;

        public JumpGameState(int index) {
            this.index = index;
            this.up = true;
            this.down = true;
        }

        public JumpGameState(int index, boolean up, boolean down) {
            this.index = index;
            this.up = up;
            this.down = down;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            JumpGameState that = (JumpGameState) o;
            return index == that.index && up == that.up && down == that.down;
        }

        @Override
        public int hashCode() {
            int idxUp = up ? 1 : 0;
            int idxDown = down ? 1 : 0;
            return Objects.hash(index, idxUp, idxDown);
        }
    }

    public boolean canReach(int[] arr, int start) {
        if (arr[start] == 0) {
            return true;
        }


        return false;
    }

    public static void main(String[] args) {
        
    }
}
