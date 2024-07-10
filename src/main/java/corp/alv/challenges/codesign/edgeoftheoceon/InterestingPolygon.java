package corp.alv.challenges.codesign.edgeoftheoceon;

public class InterestingPolygon {
    //https://app.codesignal.com/arcade/intro/level-2/yuGuHvcCaFCKk56rJ
    /*
Below we will define an n-interesting polygon. Your task is to find the area of a polygon for a given n.

A 1-interesting polygon is just a square with a side of length 1. An n-interesting polygon is obtained by taking
the n - 1-interesting polygon and appending 1-interesting polygons to its rim, side by side.
You can see the 1-, 2-, 3- and 4-interesting polygons in the picture below.


Example

For n = 2, the output should be
solution(n) = 5;
For n = 3, the output should be
solution(n) = 13.
Input/Output

[execution time limit] 3 seconds (java)

[memory limit] 1 GB

[input] integer n

Guaranteed constraints:
1 ≤ n < 104.

[output] integer

The area of the n-interesting polygon.
     */
    public static int solution(int n) {
        if (n == 1) {
            return 1;
        }

        int cols = 1;
        int sum = 0;
        int factor = 2;
        int total = 1 + (n - 1) * 2;
        int i = 1;
        while (cols > 0) {
            sum += cols;
            cols += factor;
            if (i == total / 2) {
                factor = -2;
            }
            i++;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println("N = 1 :: Size = " + InterestingPolygon.solution(1));
        System.out.println("N = 2 :: Size = " + InterestingPolygon.solution(2));
        System.out.println("N = 3 :: Size = " + InterestingPolygon.solution(3));
        System.out.println("N = 4 :: Size = " + InterestingPolygon.solution(4));
    }
}
