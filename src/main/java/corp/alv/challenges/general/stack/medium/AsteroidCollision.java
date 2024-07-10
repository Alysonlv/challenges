package corp.alv.challenges.general.stack.medium;

import java.util.Stack;

/*
735. Asteroid Collision
Medium
Topics
Companies
Hint
We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.



Example 1:

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
Example 2:

Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.
Example 3:

Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
 */
public class AsteroidCollision {

    public int[] asteroidCollision_Better(int[] asteroids) {
        //10, 9, 8, 7, 6, -8, 5
        // 0  1  2  3. 4.  5. 6
        int peek = -1;
        loop:
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0) {
                asteroids[++peek] = asteroids[i];
                continue;
            }
            //once found out that the asteroids is negative: check is there is a positive asteroid available in the stack which we can hit
            while (peek >= 0 && asteroids[peek] > 0) {
                if (asteroids[peek] < Math.abs(asteroids[i])) peek--;
                else if (asteroids[peek] > Math.abs(asteroids[i])) continue loop;
                else {
                    peek--;
                    continue loop;
                }

            }
            // if the asteroid is negative or destroyed every positive asteroid add this giant asteroid in the virtual stack
            asteroids[++peek] = asteroids[i];

        }

        int[] ans = new int[peek + 1];
        for (int i = 0; i <= peek; i++) ans[i] = asteroids[i];

        return ans;
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<Integer>();

        for (int asteroid : asteroids) {
            boolean selfDestruction = true;
            while (!stack.isEmpty() && (stack.peek() > 0 && asteroid < 0)) {
                // If the top asteroid in the stack is smaller, then it will explode.
                // Hence pop it from the stack, also continue with the next asteroid in the stack.
                if (Math.abs(stack.peek()) < Math.abs(asteroid)) {
                    stack.pop();
                    continue;
                }
                // If both asteroids have the same size, then both asteroids will explode.
                // Pop the asteroid from the stack; also, we won't push the current asteroid to the stack.
                else if (Math.abs(stack.peek()) == Math.abs(asteroid)) {
                    stack.pop();
                }

                // If we reach here, the current asteroid will be destroyed
                // Hence, we should not add it to the stack
                selfDestruction = false;
                break;
            }

            if (selfDestruction) {
                stack.push(asteroid);
            }
        }

        // Add the asteroids from the stack to the vector in the reverse order.
        int[] remainingAsteroids = new int[stack.size()];
        for (int i = remainingAsteroids.length - 1; i >= 0; i--) {
            remainingAsteroids[i] = stack.pop();
        }

        return remainingAsteroids;
    }
}
