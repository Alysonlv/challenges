package corp.alv.challenges.interview;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {

    public static void findZigZagSequence(int[] a, int n) {
        Arrays.sort(a);
        int mid = n / 2;
        int temp = a[mid];
        a[mid] = a[n - 1];
        a[n - 1] = temp;

        int st = mid + 1;
        int ed = n - 2;
        while (st <= ed) {
            temp = a[st];
            a[st] = a[ed];
            a[ed] = temp;
            st++;
            ed--;
        }
        for (int i = 0; i < n; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(a[i]);
        }
        System.out.println();
    }

    public static void main(String... args) {

        String s = "middle-Outz";
        int k = 2;

        int firstUpper = 'A';
        int lastUpper = 'Z';

        int firstLower = 'a';
        int lastLower = 'z';

        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if ((firstLower <= c && c <= lastLower) || (firstUpper <= c && c <= lastUpper)) {
                int newChar = c + k;

                if (newChar > lastLower && Character.isLowerCase(c)) {
                    newChar = newChar - lastLower + firstLower - 1;
                } else if (newChar > lastUpper && Character.isUpperCase(c)) {
                    newChar = newChar - lastUpper + firstUpper - 1;
                }
                sb.append((char) newChar);
            } else {
                sb.append(c);
            }
        }

        System.out.println(sb.toString());

    }

}
