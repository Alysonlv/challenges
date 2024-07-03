package corp.alv.challenges.utils;

import corp.alv.challenges.domain.ListNode;
import lombok.experimental.UtilityClass;

import java.util.Arrays;

@UtilityClass
public class Utils {

    public static String arrayToString(int[] arr) {
        return Arrays.toString(arr);
    }

    public static void printListNodeToString(ListNode head) {
        StringBuilder sb = new StringBuilder();

        ListNode curr = head;
        sb.append("{");
        while (curr != null) {
            sb.append(curr.val);
            if (curr.next != null) {
                sb.append(", ");
            }
        }
        sb.append("}");

        System.out.println(sb);
    }
}
