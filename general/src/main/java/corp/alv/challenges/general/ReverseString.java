package corp.alv.challenges.general;

public class ReverseString {

    public static String reverseWhileLoop(final String text) {
        char[] arr = text.toCharArray();

        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
            i++;
            j--;
        }

        return new String(arr);
    }

    public static String reverseForLoop(final String text) {
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];

        int length = original.length;
        for (char i : original) {
            reversed[--length] = i;
        }

        return new String(reversed);
    }

}
