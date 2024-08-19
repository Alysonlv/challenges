package corp.alv.challenges.interview.microsoft;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 #MICROSOFT
 See image RoadFixPotHolesWithWidth.png

 Here is the extracted text from the image:

---

**Task 2**

There are N potholes on a straight road parallel to the y-axis. The positions of the potholes are described by two arrays of integers, X and Y. The K-th pothole (for K within the range [0..N-1]) is located at coordinates (X[K], Y[K]).

In order to fix the potholes, a road roller of width W will be used. The road roller can only drive along the street (parallel to the y-axis). It can start driving from any x coordinate at the beginning of the road (a point whose y coordinate is equal to 0). During one drive, for a chosen starting point (x, 0) of the road roller's left end, the road roller drives upwards and patches all potholes on its way that fall within the width of the road roller, W, and are to the right of its starting position, x. In other words, it patches all the potholes whose first coordinate is between x and x+W inclusive.

What is the minimum number of road roller drives required to patch all the potholes?

Write a function:

```java
class Solution {
    public int solution(int[] X, int[] Y, int W);
}
```

that, given two arrays of integers X and Y, describing the positions of the N potholes, and an integer W, specifying the width of the road roller, returns the minimum number of drives needed to patch all the potholes.

**Examples:**

1. Given X = [2, 4, 2, 6, 7, 1], Y = [0, 5, 3, 2, 1, 5] and W = 2, the answer is 3. At least three drives will be needed to patch all the potholes. For example, the drives could start respectively at points (1, 0), (4, 0) and (6, 0). During the first drive, the road roller would patch the potholes located at (2, 0), (2, 3) and (1, 5). During the second drive, the potholes located at (4, 5) and (6, 2) would be patched. Finally, in the third drive, the pothole located at (7, 1) would be patched.

2. Given X = [4, 8, 2, 2, 1, 4], Y = [1, 2, 3, 1, 2, 3] and W = 3, the answer is 2. If the first drive of the road roller started at point (1, 0) and the second drive at the point (6, 0), all the potholes would be patched.

3. Given X = [0, 3, 6, 5], Y = [0, 3, 2, 4] and W = 1, the answer is 3. The first drive of the road roller could start at point (0, 0), the second drive at point (3, 0) and the third drive at point (5, 0).

Write an efficient algorithm for the following assumptions:
- N is an integer within the range [1..100,000];
- each element of arrays X and Y is an integer within the range [0..1,000,000,000];
- W is an integer within the range [1..1,000,000,000].

---

Let me know if you need any help with solving this challenge!
 */
class RoadFixPotHolesWithWidth {
    public int solution(int[] X, int[] Y, int W) {
        Set<Integer> uniqueXPositions = new HashSet<>();

        for (int x : X) {
            uniqueXPositions.add(x);
        }

        Integer[] uniques = uniqueXPositions.toArray(new Integer[0]);
        Arrays.sort(uniques);

        int numberOfDrives = 0;
        int left = 0;

        while (left < uniques.length) {
            numberOfDrives++;
            int currentStart = uniques[left];

            while (left < uniques.length && uniques[left] <= currentStart + W) {
                left++;
            }
        }

        return numberOfDrives;
    }

    // Example main method to test the solution
    public static void main(String[] args) {
        RoadFixPotHolesWithWidth solution = new RoadFixPotHolesWithWidth();

        // Test case 1
        System.out.println("3 = " + solution.solution(new int[]{2, 4, 2, 6, 7, 1}, new int[]{0, 5, 3, 2, 1, 5}, 2)); // Expected: 3
        // Test case 2
        System.out.println("2 = " + solution.solution(new int[]{4, 8, 2, 2, 1, 4}, new int[]{1, 2, 3, 1, 2, 3}, 3)); // Expected: 2
        // Test case 3
        System.out.println("3 = " + solution.solution(new int[]{0, 3, 6, 5}, new int[]{0, 3, 2, 4}, 1)); // Expected: 3
    }
}

