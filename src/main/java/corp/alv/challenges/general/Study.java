package corp.alv.challenges.general;

import org.springframework.cache.annotation.Cacheable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Callable;

public class Study implements Callable<Integer> {

    /*
     Find the longest subarray that the sum is <= k
     [3, 2, 1, 3, 1, 1]
     */
    public static int solution(int [] nums, int k) {
        int left = 0;
        int currentSum = 0; // currentSum is the current sum of the window
        int largestSubarray = 0;

        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];
            while (currentSum > k) {
                currentSum -= nums[left];
                left++;
            }

            largestSubarray = Math.max(largestSubarray, right - left + 1);
        }

        return largestSubarray;
    }

    public static boolean checkIfPangram(String sentence) {
        Set<Character> letters = new HashSet<>();

        for (int i = 0; i < sentence.length(); i++) {
            letters.add(sentence.charAt(i));
        }

        return letters.size() == 26;
    }

    public int countElements(int[] arr) {
        Set<Integer> arrSet = new HashSet<>();

        for (int n : arr) {
            arrSet.add(n);
        }

        int count = 0;
        for (int n : arr) {
            if (arrSet.contains(n + 1)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {3, 2, 1, 3, 1, 1};
        System.out.println(solution(arr, 5));

        Study s = new Study();
        s.test();
    }

    public void test() {
        Map<MyObject, MyObject> map = new HashMap<>();
        MyObject myObject = new MyObject("Alyson");
        map.put(myObject, myObject);
        System.out.println(map.size());
        System.out.println(map.values());
        System.out.println(map.get(myObject));

        MyObject myObject2 = new MyObject("ALYSON");
        map.put(myObject2, myObject2);
        System.out.println(map.size());
        System.out.println(map.values());
        System.out.println(map.get(myObject2));
    }

    @Override
    public Integer call() throws Exception {
        return null;
    }

    class MyObject {
        String text;

        public MyObject(String a) {
            this.text = a;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MyObject myObject = (MyObject) o;
            return Objects.equals(text, myObject.text);
        }

        @Override
        public int hashCode() {
            return Objects.hash("my-hash" + text.toLowerCase());
        }

        @Override
        public String toString() {
            return "MyObject{" +
                    "text='" + text + '\'' +
                    '}';
        }
    }
}

