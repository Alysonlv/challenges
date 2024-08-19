package corp.alv.challenges.hackerrank;

/*
Louise and Richard have developed a numbers game. They pick a number and check to see if it is a power of . If it is, they divide it by . If not, they reduce it by the next lower number which is a power of . Whoever reduces the number to  wins the game. Louise always starts.

Given an initial value, determine who wins the game.

Example

It's Louise's turn first. She determines that  is not a power of . The next lower power of  is , so she subtracts that from  and passes  to Richard.  is a power of , so Richard divides it by  and passes  to Louise. Likewise,  is a power so she divides it by  and reaches . She wins the game.

Update If they initially set counter to , Richard wins. Louise cannot make a move so she loses.

Function Description

Complete the counterGame function in the editor below.

counterGame has the following parameter(s):

int n: the initial game counter value
Returns

string: either Richard or Louise
Input Format

The first line contains an integer , the number of testcases.
Each of the next  lines contains an integer , the initial value for each game.

Constraints

Sample Input

1
6
Sample Output

Richard
Explanation

As  is not a power of , Louise reduces the largest power of  less than  i.e., , and hence the counter reduces to .
As  is a power of , Richard reduces the counter by half of  i.e., . Hence the counter reduces to .
As we reach the terminating condition with , Richard wins the game.
 */
public class CounterGame {

    public static String counterGame(long n) {

        int turn = 0;
        do {
            turn++;

            if (!isPowerOfTwo(n)) {
                long nextLowerPowerOfTwo = getNextLowerPowerOfTwo(n);
                n = n - nextLowerPowerOfTwo;
                continue;
            }

            n = n / 2;
        } while (n != 1);

        return turn % 2 == 0 ? "Richard" : "Louise";
    }

    private static boolean isPowerOfTwo(Long n) {
        return n > 0 && ((n & (n - 1)) == 0);
    }

    private static long getNextLowerPowerOfTwo(Long n) {
        long power = 1;
        while (power <= n) {
            power <<= 1;
        }
        return power >> 1;
    }

    public static long getNextPowerOfTwo(long num) {
        return (num & (num - 1)) == 0 ? num : (long) Math.pow(2, Math.floor(Math.log(num) / Math.log(2)));
    }

    public static void main(String[] args) {
        Long n = null;

        n = 132l;
        System.out.println("For " + n + " winner is " + CounterGame.counterGame(n));

        n = 6l;
        System.out.println("For " + n + " winner is " + CounterGame.counterGame(n));
    }
}
