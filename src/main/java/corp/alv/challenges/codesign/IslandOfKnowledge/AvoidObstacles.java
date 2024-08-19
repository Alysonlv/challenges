package corp.alv.challenges.codesign.IslandOfKnowledge;

import java.util.Arrays;

/*
You are given an array of integers representing coordinates of obstacles situated on a straight line.

Assume that you are jumping from the point with coordinate 0 to the right. You are allowed only to make jumps of the same length represented by some integer.

Find the minimal length of the jump enough to avoid all the obstacles.

Example

For inputArray = [5, 3, 6, 7, 9], the output should be
solution(inputArray) = 4.

Check out the image below for better understanding:

[0,1,2,3,4,5,6,7,8,9,10]
[0,0,0,3,0,5,6,7,0,9,0]
Jump from 0 to 4
     from 4 to 8
     from 8 to 12

Input/Output 4

[execution time limit] 3 seconds (java)

[memory limit] 1 GB

[input] array.integer inputArray

Non-empty array of positive integers.

Guaranteed constraints:
2 ≤ inputArray.length ≤ 1000,
1 ≤ inputArray[i] ≤ 1000.

[output] integer

The desired length.
 */
public class AvoidObstacles {

    public static int solution(int[] inputArray) {
        Arrays.sort(inputArray);

        int last = inputArray[inputArray.length - 1];
        int first = inputArray[0];
        int[] path = new int[1001];

        for (int obs : inputArray) {
            path[obs] = obs;
        }

        int jump = 1;
        int position = jump;
        while (position <= last) {
            int obs = path[position];
            if (path[position] == 0) {
                position += jump;
            } else {
                jump++;
                position = jump;
            }
        }

        //5, 3, 6, 7, 9
        return jump;
    }

    public static int findMinimumJump_ChatGPT(int[] obstacles) {
        for (int k = 2; k <= 1001; k++) {
            boolean isValid = true;
            for (int obstacle : obstacles) {
                if (obstacle % k == 0) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                return k;
            }
        }
        return -1; // This should never be reached given the problem constraints.
    }

    public static void main(String[] args) {
        System.out.println("4 = " + AvoidObstacles.solution(new int[]{5, 3, 6, 7, 9}) + " | gpt = " + AvoidObstacles.findMinimumJump_ChatGPT(new int[]{5, 3, 6, 7, 9}));
        System.out.println("7 = " + AvoidObstacles.solution(new int[]{1, 4, 10, 6, 2}) + " | gpt = " + AvoidObstacles.findMinimumJump_ChatGPT(new int[]{1, 4, 10, 6, 2}));
        System.out.println("6 = " + AvoidObstacles.solution(new int[]{1000, 999}) + " | gpt = " + AvoidObstacles.findMinimumJump_ChatGPT(new int[]{1000, 999}));
    }

}
