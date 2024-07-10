package corp.alv.challenges.general;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here
        int[] frequency = new int[100];
        for (int val : arr) {
            frequency[val] += 1;
        }

        return Arrays.stream(frequency)
                .boxed()
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();

        Collections.sort(A, Collections.reverseOrder());

        System.out.println("Alyson Lima Vasconcelos".toLowerCase().toCharArray());
    }
}
