package corp.alv.challenges.general.sliding_window.medium;

import java.util.HashMap;

/*
#Hash Table
#Two Pointers
#String
#Sliding Window

567. Permutation in String
Medium
Topics
Companies
Hint
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.



Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false


Constraints:

1 <= s1.length, s2.length <= 104
s1 and s2 consist of lowercase English letters.
 */
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {

        int map[] = new int[26]; // to store the count of characters in s1

        for (char c : s1.toCharArray()) {
            map[c - 'a']++;//increasing the count of the char ar it's index
        }

        int j = 0, i = 0;

        int count_chars = s1.length();//it stores the count of chars which we need to find in s2

        while (j < s2.length()) {
            //if after decrementing char at j index in s2 is still greater than 0 means we have found 1 char
            if (map[s2.charAt(j++) - 'a']-- > 0) {
                count_chars--;//decrease the count of chars we need to find //found the s1 char on s2, remove it from map
            }

            if (count_chars == 0) {// we have found all the chars
                return true;
            }
            //shifting of the window. Here we need to do 2 things
            // j- i = s1.length then we have to remove what is present at i'th index in s2
            //2: increase the count of s2.charAt(i) because we have to find it again as it was removed
            if (j - i == s1.length() && map[s2.charAt(i++) - 'a']++ >= 0) {
                count_chars++;
            }
        }
        return false;
    }

    public boolean checkInclusion_B(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        HashMap<Character, Integer> s1map = new HashMap<>();

        for (int i = 0; i < s1.length(); i++)
            s1map.put(s1.charAt(i), s1map.getOrDefault(s1.charAt(i), 0) + 1);

        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            HashMap<Character, Integer> s2map = new HashMap<>();
            for (int j = 0; j < s1.length(); j++) {
                s2map.put(s2.charAt(i + j), s2map.getOrDefault(s2.charAt(i + j), 0) + 1);
            }
            if (matches(s1map, s2map))
                return true;
        }
        return false;
    }

    private boolean matches(HashMap<Character, Integer> s1map, HashMap<Character, Integer> s2map) {
        for (char key : s1map.keySet()) {
            if (s1map.get(key) - s2map.getOrDefault(key, -1) != 0)
                return false;
        }
        return true;
    }

}
