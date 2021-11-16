package corp.alv.challenges.general.strings.easy;

public class PalindromeCheck {

    public static boolean isPalindrome(String str) {
        // Write your code here.
        if (str.length() == 1) {
            return true;
        }

        int left = 0;
        int right = str.length() - 1;

        char[] chars = str.toCharArray();

        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

}
