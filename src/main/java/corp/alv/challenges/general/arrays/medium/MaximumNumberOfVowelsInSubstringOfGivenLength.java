package corp.alv.challenges.general.arrays.medium;

import java.util.HashSet;
import java.util.Set;

/*
Maximum Number of Vowels in a Substring of Given Length
Solved
Medium
Topics
Companies
Hint
Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.



Example 1:

Input: s  =  "abciiidef", k  =  3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.
Example 2:

Input: s  =  "aeiou", k  =  2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.
Example 3:

Input: s  =  "leetcode", k  =  3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels.


Constraints:

1 < =  s.length < =  105
s consists of lowercase English letters.
1 < =  k < =  s.length
 */
public class MaximumNumberOfVowelsInSubstringOfGivenLength {

    public static int maxVowels(String s, int k) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int i = 0;
        int j = 0;
        int ans = 0;
        int max = Integer.MIN_VALUE;
        while (j<s.length()) {
            if (set.contains(s.charAt(j))){
                ans++;
            }
            if (j-i+1<k) {

                j++;
            } else if (j - i + 1 == k) {
                max = Math.max(max,ans);
                if (set.contains(s.charAt(i))) {
                    ans--;
                }
                i++;
                j++;
            }
        }
        return max;

    }

    public static int maxVowels_Better(String s, int k) {
        int maxLen  =  0;

        int[] vowels  =  new int[26];
        vowels['a'-'a']  =  1;
        vowels['e'-'a']  =  1;
        vowels['i'-'a']  =  1;
        vowels['o'-'a']  =  1;
        vowels['u'-'a']  =  1;

        int count  =  0;
        int left  =  0;

        for (int right  =  0; right < s.length(); right++) {

            char ch  =  s.charAt(right);
            count +=  vowels[ch-'a'];


            if (right >=  k-1) {

                maxLen = Math.max(maxLen, count);
                char c = s.charAt(left);

                if (vowels[c-'a'] != 0) {
                    count--;
                }
                left++;
            }
        }
        return maxLen;
    }
}
