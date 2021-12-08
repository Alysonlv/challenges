package corp.alv.challenges.general.others;

import java.util.Arrays;
import java.util.stream.Stream;

public class ModifiedSubSetSum {
    /*
    A = {23,54,55,54,-70,-20}
B = {-19,-4,-55,54,90}

Create subsets such that sum of subset is zero.

For example, In above example, following can be a sample solution:


S = {{23,-19,-4}, {55, -55}, {-70,-20,90}}
     */

    public static void printSubsets_BruteForce(int[] set1, int[] set2) {
        Integer[] set = Stream.concat(Arrays.stream(set1).boxed(), Arrays.stream(set2).boxed()).toArray(Integer[]::new);
        int totalSet = set.length;

        int totalSubSets = (1 << totalSet);
        for (int i = 1; i < totalSubSets; ++i) {
            int curSum = 0;
            for (int j = totalSet - 1; j >= 0; --j) {
                if (((i >> j) & 1) > 0) {
                    curSum +=set[j];
                }
            }
            if (curSum == 0) {
                for (int j = totalSet - 1; j >= 0; --j) {
                    if (((i >> j) & 1) > 0) {
                        System.out.print(set[j] + " ");
                    }
                }
                System.out.println("");
            }
        }
    }

    public static void main(String[] args) {
        int set1[] = {23,54,55,54,-70,-20};
        int set2[] = {-19,-4,-55,54,90};

        printSubsets_BruteForce(set1, set2);
    }
}
