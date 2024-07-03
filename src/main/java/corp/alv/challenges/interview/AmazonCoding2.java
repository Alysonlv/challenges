package corp.alv.challenges.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AmazonCoding2 {
    public static long getMaximumPoints(List<Integer> days, int k) {
        List<Integer> extendedDays = new ArrayList<>();
        for (int d : days) {
            for (int i = 1; i <= d; i++) {
                extendedDays.add(i);
            }
        }

        List<Integer> prefix = new ArrayList<>();
        int sum = extendedDays.get(0);
        prefix.add(extendedDays.get(0));
        for (int i = 1; i < extendedDays.size(); i++) {
            sum += extendedDays.get(i);
            prefix.add(sum);
        }

        long maxSum = prefix.get(k - 1);
        int left = 0;
        for (int i = k; i < (prefix.size()); i++) {
            long subSum = prefix.get(i) - prefix.get(left);
            maxSum = Math.max(maxSum, subSum);
            left++;
//            currentSum += extendedDays.get(i);
//            if (i >= k - 1) {
//                maxSum = Math.max(maxSum, currentSum);
//                currentSum -= extendedDays.get(i - (k - 1));
//            }
        }

        return maxSum;

    }

    public static void main(String[] args) {
        System.out.println(AmazonCoding2.getMaximumPoints(Arrays.asList(2,3,2), 4));
    }
}
