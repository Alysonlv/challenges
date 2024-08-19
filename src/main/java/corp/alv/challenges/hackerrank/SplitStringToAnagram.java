package corp.alv.challenges.hackerrank;

import java.util.HashMap;
import java.util.Map;

public class SplitStringToAnagram {
    public static int anagram(String s) {
        String a = "";
        String b = "";
        if (s.length() % 2 == 0) {
            a = s.substring(0, s.length() / 2);
            b = s.substring((s.length() / 2), s.length());
        }

        if (s.length() % 2 != 0) {
            a = s.substring(0, s.length() / 2);
            b = s.substring((s.length() / 2), s.length());
        }
        if (a.length() == b.length()) {
            char[] aArray = a.toCharArray();
            char[] bArray = b.toCharArray();
            Map<Character, Integer> aMap = new HashMap<>();
            Map<Character, Integer> bMap = new HashMap<>();
            for (char c : aArray) { // prepare a Hashmap of <char>,<count> for first string
                if (aMap.containsKey(c)) {
                    aMap.put(c, aMap.get(c) + 1);
                } else {
                    aMap.put(c, 1);
                }
            }

            for (char c : bArray) {// prepare a Hashmap of <char>,<count> for second string
                if (bMap.containsKey(c)) {
                    bMap.put(c, bMap.get(c) + 1);
                } else {
                    bMap.put(c, 1);
                }
            }
            int change = 0;
            for (Map.Entry<Character, Integer> entry : bMap.entrySet()) {
                if (!aMap.containsKey(entry.getKey())) {
                    change += entry.getValue();
                } else {
                    if (entry.getValue() > aMap.get(entry.getKey())) {
                        change += entry.getValue() - aMap.get(entry.getKey());
                    }
                }
            }
            return change;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println("3 = " + SplitStringToAnagram.anagram("aaabbb"));
        System.out.println("1 = " + SplitStringToAnagram.anagram("ab"));
        System.out.println("-1 = " + SplitStringToAnagram.anagram("abc"));
        System.out.println("2 = " + SplitStringToAnagram.anagram("mnop"));
        System.out.println("0 = " + SplitStringToAnagram.anagram("xyyx"));
        System.out.println("1 = " + SplitStringToAnagram.anagram("xaxbbbxx"));
    }
}
