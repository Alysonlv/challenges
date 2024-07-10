package corp.alv.challenges.codesign.smothsailing;

import java.util.Arrays;

/*
Some people are standing in a row in a park. There are trees between them which cannot be moved. Your task is to rearrange the people by their heights in a non-descending order without moving the trees. People can be very tall!

Example

For a = [-1, 150, 190, 170, -1, -1, 160, 180], the output should be
solution(a) = [-1, 150, 160, 170, -1, -1, 180, 190].

Input/Output

[execution time limit] 3 seconds (java)

[memory limit] 1 GB

[input] array.integer a

If a[i] = -1, then the ith position is occupied by a tree. Otherwise a[i] is the height of a person standing in the ith position.

Guaranteed constraints:
1 ≤ a.length ≤ 1000,
-1 ≤ a[i] ≤ 1000.

[output] array.integer

Sorted array a with all the trees untouched.
 */
public class SortbyHeight {

    public static int[] solution(int[] a) {

        int idx = -1;//previous index
        int left = 0;
        for (int i = 0; i < a.length; i++) {
            idx = i - 1;
            int curr = a[i];
            int index = i;

            if (i > 0 && curr > 0) {
                while (idx >= 0) {
                    int prev = a[idx];

                    if (prev > 0 && prev > curr) {
                        a[index] = prev;
                        a[idx] = curr;

                        index = idx;
                        idx--;
                    } else {
                        if (prev > 0 && prev < curr) {
                            break;
                        }
                        idx--;
                    }
                }

            }
        }

        return a;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(SortbyHeight.solution(new int[]{-1, 150, 190, 170, -1, -1, 160, 180})));
//        System.out.println(Arrays.toString(SortbyHeight.solution(new int[]{4, 2, 9, 11, 2, 16})));
        System.out.println(Arrays.toString(SortbyHeight.solution(new int[]{23, 54, -1, 43, 1, -1, -1, 77, -1, -1, -1, 3})));
    }
}
