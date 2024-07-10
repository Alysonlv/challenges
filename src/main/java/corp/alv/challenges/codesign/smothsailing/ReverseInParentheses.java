package corp.alv.challenges.codesign.smothsailing;

import java.util.Stack;

/*
Write a function that reverses characters in (possibly nested) parentheses in the input string.

Input strings will always be well-formed with matching ()s.

Example

For inputString = "(bar)", the output should be
solution(inputString) = "rab";
For inputString = "foo(bar)baz", the output should be
solution(inputString) = "foorabbaz";
For inputString = "foo(bar)baz(blim)", the output should be
solution(inputString) = "foorabbazmilb";
For inputString = "foo(bar(baz))blim", the output should be
solution(inputString) = "foobazrabblim".
Because "foo(bar(baz))blim" becomes "foo(barzab)blim" and then "foobazrabblim".
Input/Output

[execution time limit] 3 seconds (java)

[memory limit] 1 GB

[input] string inputString

A string consisting of lowercase English letters and the characters ( and ). It is guaranteed that all parentheses in inputString form a regular bracket sequence.

Guaranteed constraints:
0 ≤ inputString.length ≤ 50.

[output] string

Return inputString, with all the characters that were in parentheses reversed.
 */
public class ReverseInParentheses {

    public static String solution(String inputString) {
        //foo(bar(baz)io)blim

        //foo(bar(baz))blim
        //bar(baz)
        //baz
        StringBuilder res = new StringBuilder();
        Stack<Character> charStack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < inputString.length(); i++) {
            char curr = inputString.charAt(i);

            if (curr != '(' && curr != ')') {
                sb.append(curr);
            } else if (curr == '(') {
                if (charStack.isEmpty()) {
                    if (sb.length() > 0 && sb.charAt(0) != '(') {
                        res.append(sb);
                    }
                    sb = new StringBuilder();
                }
                indexStack.push(sb.length());
                charStack.push(curr);
                sb.append(curr);

            } else if (curr == ')') {
                charStack.pop();
                int start = indexStack.pop();
                StringBuilder temp = new StringBuilder(sb.substring(start + 1)).reverse();
                sb = new StringBuilder(sb.substring(0, start));
                sb.append(temp);
            }
        }
        return res.append(sb).toString();
    }

    public static void main(String[] args) {
        System.out.println(ReverseInParentheses.solution("foo(bar(baz))blim"));
    }
}
