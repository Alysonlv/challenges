package corp.alv.challenges.general.others;

import java.util.Arrays;

/*
    Given an array of N integers, returns true if A contains at least two elements which differ by 1, and false otherwise

    -> Give A = [7], should return false
    -> Giver A = [4,3], should return true
    -> Given A = [11,1,8,12,14], should return true. Pair of elements 11 an 12 differ by 1
    -> Given A = [1,4,7,90], should return false
 */
public class ArrayElementDifferByOne {
    public static boolean solution(int... A) {
        // write your code in Java SE 8
        Arrays.sort(A);

        if (A == null || A.length <= 1) {
            return false;
        }

        for (int i = 0, j = 1; i < A.length - 1; i++, j++) {
            if (A[j] - A[i] == 1) {
                return true;
            }
        }

        return false;
    }

    public static void main(String... args) {
        System.out.println(ArrayElementDifferByOne.solution(7));
        System.out.println(ArrayElementDifferByOne.solution(4,3));
        System.out.println(ArrayElementDifferByOne.solution(11,1,8,12,14));
        System.out.println(ArrayElementDifferByOne.solution(1,4,7,9));
    }
}
