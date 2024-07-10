package corp.alv.challenges.general.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/*
2434. Using a Robot to Print the Lexicographically Smallest String
Solved
Medium
Topics
Companies
Hint
You are given a string s and a robot that currently holds an empty string t. Apply one of the following operations until s and t are both empty:

Remove the first character of a string s and give it to the robot. The robot will append this character to the string t.
Remove the last character of a string t and give it to the robot. The robot will write this character on paper.
Return the lexicographically smallest string that can be written on the paper.



Example 1:

Input: s = "zza"
Output: "azz"
Explanation: Let p denote the written string.
Initially p="", s="zza", t="".
Perform first operation three times p="", s="", t="zza".
Perform second operation three times p="azz", s="", t="".
Example 2:

Input: s = "bac"
Output: "abc"
Explanation: Let p denote the written string.
Perform first operation twice p="", s="c", t="ba".
Perform second operation twice p="ab", s="c", t="".
Perform first operation p="ab", s="", t="c".
Perform second operation p="abc", s="", t="".
Example 3:

Input: s = "bdda"
Output: "addb"
Explanation: Let p denote the written string.
Initially p="", s="bdda", t="".
Perform first operation four times p="", s="", t="bdda".
Perform second operation four times p="addb", s="", t="".


Constraints:

1 <= s.length <= 105
s consists of only English lowercase letters.
 */
public class UsingRobotPrintLexicographicallySmallestString {

    public String robotWithString(String s) {
        int n = s.length();
        int[] dp = new int[n];
        dp[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            dp[i] = s.charAt(i) <= s.charAt(dp[i + 1]) ? i : dp[i + 1];
        }
        Deque<Character> stack = new ArrayDeque<>();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < n) {
            if (!stack.isEmpty()) sb.append(stack.pop());
            if (stack.isEmpty() || s.charAt(dp[i]) < stack.peek()) {
                int smallestIndex = dp[i];
                for (; i <= smallestIndex; i++) {
                    stack.push(s.charAt(i));
                }
            }
        }
        while (!stack.isEmpty()) sb.append(stack.pop());
        return sb.toString();
    }

    public static void main(String[] args) {
        UsingRobotPrintLexicographicallySmallestString t = new UsingRobotPrintLexicographicallySmallestString();

        String s = "zza";
        System.out.println(t.robotWithString(s));
    }
}
