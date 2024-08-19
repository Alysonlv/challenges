package corp.alv.challenges.hackerrank;

public class PalindromeIndex {
    public static int palindromeIndex(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right && s.charAt(left) == s.charAt(right)) {
            left++;
            right--;
        }
        if (left >= right) {
            return -1;
        }

        if (isPalindrome(s, left + 1, right)) {
            return left;
        }
        if (isPalindrome(s, left, right - 1)) {
            return right;
        }

        return -1;
    }

    public static boolean isPalindrome(String s, int start, int end) {
        while (start < end && s.charAt(start) == s.charAt(end)) {
            start++;
            end--;
        }
        return start >= end;
    }

    public static void main(String[] args) {
        System.out.println(PalindromeIndex.palindromeIndex("aaa"));
    }
}
