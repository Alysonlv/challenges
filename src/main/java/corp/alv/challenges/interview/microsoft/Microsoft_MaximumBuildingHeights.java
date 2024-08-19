package corp.alv.challenges.interview.microsoft;

import java.util.HashSet;
import java.util.Set;

/*
You are given an array A of N integers, representing the maximum heights of N skyscrapers to be built.

Your task is to specify the actual heights of the skyscrapers, given that:

the height of the K-th skyscraper should be positive and not bigger than A[K];
no two skyscrapers should be of the same height;
the total sum of the skyscrapers' heights should be the maximum possible.
Write a function:

java
Copy code
class Solution { public int[] solution(int[] A); }
that, given an array A of N integers, returns an array B of N integers where B[K] is the assigned height of the K-th skyscraper satisfying the above conditions.

If there are several possible answers, the function may return any of them. You may assume that it is always possible to build all skyscrapers while fulfilling all the requirements.

Examples:

Given A = [1, 2, 3], your function should return [1, 2, 3], as all of the skyscrapers may be built to their maximum height.
Given A = [9, 4, 3, 7, 7], your function may return [9, 4, 3, 7, 6]. Note that [9, 4, 3, 6, 7] is also a valid answer. It is not possible for the last two skyscrapers to have the same height. The height of one of them should be 7 and the other should be 6.
Given A = [2, 5, 4, 5, 5], your function should return [1, 2, 3, 4, 5].
Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..50,000];
each element of array A is an integer within the range [1..1,000,000,000];
there is always a solution for the given input.
 */
public class Microsoft_MaximumBuildingHeights {

    public static int[] solution(int[] A) {
        int[] result = new int[A.length];

        Set<Integer> heights = new HashSet<>();

        //9,4,3,7,7
        int index = 0;
        for (int height : A) {
            boolean duplicated = heights.add(height);
            int newHeight = height;
            while (!duplicated) {
                newHeight--;
                duplicated = heights.add(newHeight);
            }
            result[index++] = newHeight;
        }

        return result;
    }

    public static void main(String[] args) {

        System.out.println(Microsoft_MaximumBuildingHeights.solution(new int[]{9, 4, 3, 7, 7}));
    }
}
