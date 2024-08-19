package corp.alv.challenges.interview.microsoft;

/*
We are provided with a plan of an industrial village, represented by an array A consisting of N integers. The K-th value (for K within the range 0...N-1) represents a field which may contain:

a forest consisting of A[K] trees (if A[K] is positive); or
an industrial building (if A[K] is non-positive), producing -A[K] units of pollution.
One tree is able to neutralize one unit of pollution. Our goal is to make every neighborhood sustainable, i.e. for every field, the sum of its value and the values of its neighbors (adjacent fields to the left and right) should be greater than or equal to zero. To achieve this goal, we can plant additional trees in any chosen field (note that we can plant trees in fields containing industrial buildings).

For example, given A = [1, -3, 2], there is one tree in the field number 0, an industrial building producing 3 units of pollution in field number 1 and two trees in field number 2. The sums of values of the fields and their neighbors are 1 + (-3) = -2 for field number 0, 1 + (-3) + 2 = 0 for field number 1, and (-3) + 2 = -1 for field number 2. The neighborhoods of fields 0 and 2 are not sustainable, as their sums are negative. After planting two trees in field 1, we obtain A = [1, -1, 2]. In the new array, the sums are respectively 0, 2, and 1, which makes every neighborhood sustainable.

What is the minimum number of trees we have to plant in order to make every field's neighborhood sustainable?

Write a function:

java
Copy code
class Solution { public int solution(int[] A); }
that, given an array A consisting of N integers, returns the minimum number of trees we have to plant in order to make every field's neighborhood sustainable.

Examples:

Given A = [1, -3, 2], the function should return 2, as described above.
Given A = [-3, 2, 4, -5, 3], the function should return 3. We can plant one tree in field number 0 and two trees in field number 4, achieving [-2, 2, 4, -5, 5].
Given A = [-2, 1, -3, 1], the function should return 4. We can plant two trees each in fields number 1 and 2. After that, we obtain values [-2, 3, -1, 1].
 */
public class Microsoft_SustainableNeighborhoodPlanning {

    public static int solution(int[] A) {
        if (A.length == 1) {
            if (A[0] < 0) {
                return Math.abs(A[0]);
            } else {
                return 0;
            }
        }
        int trees = 0;

        for (int i = 0; i < A.length; i++) {
            if (i == 0) {
                int balance = A[i] + A[i + 1];
                if (balance < 0) {
                    A[i + 1] = A[i + 1] + Math.abs(balance);
                    trees += Math.abs(balance);
                }
            } else if (i == A.length - 1) {
                int balance = A[i] + A[i - 1];
                if (balance < 0) {
                    A[i] = A[i] + Math.abs(balance);
                    trees += Math.abs(balance);
                }
            } else {
                int balance = A[i - 1] + A[i] + A[i + 1];
                if (balance < 0) {
                    if (A[i] < 0) {
                        A[i] = A[i] + Math.abs(balance);
                    } else {
                        A[i + 1] = A[i + 1] + Math.abs(balance);
                    }
                    trees += Math.abs(balance);
                }
            }
        }

        return trees;
    }

    public static void main(String[] args) {
        //-3,2,4,-5,3
        System.out.println(Microsoft_SustainableNeighborhoodPlanning.solution(new int[]{-3, 2, 4, -5, 3}));
        System.out.println(Microsoft_SustainableNeighborhoodPlanning.solution(new int[]{1, -3, 2}));
        System.out.println(Microsoft_SustainableNeighborhoodPlanning.solution(new int[]{-2, 1, -3, 1}));
    }

}
