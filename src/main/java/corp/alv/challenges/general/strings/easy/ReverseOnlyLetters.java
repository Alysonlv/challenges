package corp.alv.challenges.general.strings.easy;

import java.util.regex.Pattern;

/*
Reverse Only Letters
Easy
Topics
Companies
Hint
Given a string s, reverse the string according to the following rules:

All the characters that are not English letters remain in the same position.
All the English letters (lowercase or uppercase) should be reversed.
Return s after reversing it.



Example 1:

Input: s = "ab-cd"
Output: "dc-ba"
Example 2:

Input: s = "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"
Example 3:

Input: s = "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"


Constraints:

1 <= s.length <= 100
s consists of characters with ASCII values in the range [33, 122].
s does not contain '\"' or '\\'.
 */
public class ReverseOnlyLetters {

    public String reverseOnlyLetters(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        char[] arr = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            // find the leftmost English letter
            while (left < right && !Character.isLetter(s.charAt(left))) {
                left++;
            }
            // find the rightmost English letter
            while (left < right && !Character.isLetter(s.charAt(right))) {
                right--;
            }
            // swap characters if only pointers have valid values
            if (left < right) {
                char tmp = arr[left];
                arr[left++] = arr[right];
                arr[right--] = tmp;
            }
        }
        return new String(arr);
    }

    private static String regex = "^[a-zA-Z]$";

    public String reverseOnlyLetters_(String s) {
        char[] chars = s.toCharArray();

        int right = s.length() - 1;
        int left = 0;

        while (left < right) {

            if (Pattern.matches(regex, Character.toString(s.charAt(left))) &&
                    Pattern.matches(regex, Character.toString(chars[right]))) {
                char temp = chars[right];
                chars[right] = chars[left];
                chars[left] = temp;

                right--;
                left++;
            } else if (!Pattern.matches(regex, Character.toString(chars[left])) &&
                    Pattern.matches(regex, Character.toString(chars[right]))) {
                left++;
            } else if (Pattern.matches(regex, Character.toString(chars[left])) &&
                    !Pattern.matches(regex, Character.toString(chars[right]))) {
                right--;
            } else if (!Pattern.matches(regex, Character.toString(chars[left])) &&
                    !Pattern.matches(regex, Character.toString(chars[right]))) {
                right--;
                left++;
            }
        }

        return String.valueOf(chars);
    }

    private String reverse(char[] chars, int left, int right) {

        while (left < right - 1) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return String.valueOf(chars);
    }
}
