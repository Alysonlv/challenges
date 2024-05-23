package corp.alv.challenges.general.math;

import java.math.BigInteger;

/*
 Factorial Trailing Zeroes
Medium
Topics
Companies
Given an integer n, return the number of trailing zeroes in n!.

Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.



Example 1:

Input: n = 3
Output: 0
Explanation: 3! = 6, no trailing zero.
Example 2:

Input: n = 5
Output: 1
Explanation: 5! = 120, one trailing zero.
Example 3:

Input: n = 0
Output: 0


Constraints:

0 <= n <= 104


Follow up: Could you write a solution that works in logarithmic time complexity?
 */
public class FactorialTrailingZeroes {

    public int trailingZeroesAlgo(int n) {
        int trailingZeroes = 0;

        if (n == 0) {
            return trailingZeroes;
        }
        BigInteger factorial = BigInteger.valueOf(n);
        for (int i = 1; i < n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(n -1));
        }
        System.out.println("Factorial of " + n + " = " + factorial.longValueExact());

        boolean hasNext = true;
        String factorialStr = String.valueOf(factorial);
        int index = factorialStr.length() - 1;
        while (hasNext) {
            if (factorialStr.charAt(index) == '0') {
                trailingZeroes++;
            } else {
                hasNext = false;
            }

            if (index == 0) {
                hasNext = false;
            }
            index--;
        }

        return trailingZeroes;
    }

    public int trailingZeroes(int n) {
        int c = 0;
        while(n != 0) {
            c += n/5;
            n /= 5;
        }
        return c;
    }

    public static void main(String[] args) {
        FactorialTrailingZeroes f = new FactorialTrailingZeroes();
        int n = 3;
        System.out.println(f.trailingZeroes(n) + " == " + f.trailingZeroesAlgo(n));
        n = 4;
        System.out.println(f.trailingZeroes(n) + " == " + f.trailingZeroesAlgo(n));
        n = 5;
        System.out.println(f.trailingZeroes(n) + " == " + f.trailingZeroesAlgo(n));
    }
}
