package corp.alv.challenges.general.stack.hard;

import java.util.Stack;

/*
1944. Number of Visible People in a Queue
Hard
Topics
Companies
Hint
There are n people standing in a queue, and they numbered from 0 to n - 1 in left to right order. You are given an array heights of distinct integers where heights[i] represents the height of the ith person.

A person can see another person to their right in the queue if everybody in between is shorter than both of them. More formally, the ith person can see the jth person if i < j and min(heights[i], heights[j]) > max(heights[i+1], heights[i+2], ..., heights[j-1]).

Return an array answer of length n where answer[i] is the number of people the ith person can see to their right in the queue.



Example 1:



Input: heights = [10,6,8,5,11,9]
Output: [3,1,2,1,1,0]
Explanation:
Person 0 can see person 1, 2, and 4.
Person 1 can see person 2.
Person 2 can see person 3 and 4.
Person 3 can see person 4.
Person 4 can see person 5.
Person 5 can see no one since nobody is to the right of them.
Example 2:

Input: heights = [5,1,2,3,10]
Output: [4,1,1,1,0]


Constraints:

n == heights.length
1 <= n <= 105
1 <= heights[i] <= 105
All the values of heights are unique.
 */
public class NumberOfVisiblePeopleInAQueue {

    public int[] canSeePersonsCount(int[] heights) {
        final int[] result = new int[heights.length], stack = new int[heights.length];
        int index = -1;

        for (int i = 0; i < heights.length; ++i) {
            int curr = heights[i];
            // if the current last observer (registred on the satck) is smaller than curr, we update stack to update the last observer possible
            // last observer is the last person behind the current that can see the curr
            // once we find someone taller or same height as curr we stop, because no one behind this position could see the curr
            // index has the taller blocker
            while (index > -1 && heights[stack[index]] <= curr) {
                // walk back with index adding the count of people that can see the curr
                result[stack[index--]]++;
            }

            // Here we have the last person in line that can see the curr, he is the taller
            if (index > -1) {
                result[stack[index]]++;
            }

            // Define who is the current last observer
            stack[++index] = i;
        }

        return result;
    }

}
