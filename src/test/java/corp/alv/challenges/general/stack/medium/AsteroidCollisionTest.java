package corp.alv.challenges.general.stack.medium;

import corp.alv.challenges.utils.Utils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AsteroidCollisionTest {

    @Test
    void asteroidCollision() {
        AsteroidCollision t = new AsteroidCollision();
        int[] arr;

        arr = new int[]{10, 9, 8, 7, 6, -8, 5};
        assertEquals("[10, 9, 5]", Utils.arrayToString(t.asteroidCollision(arr)));

        arr = new int[]{5, 10, -5};
        assertEquals("[5, 10]", Utils.arrayToString(t.asteroidCollision(arr)));

        arr = new int[]{8, -8};
        assertEquals("[]", Utils.arrayToString(t.asteroidCollision(arr)));

        arr = new int[]{10, 2, -5};
        assertEquals("[10]", Utils.arrayToString(t.asteroidCollision(arr)));

        arr = new int[]{10, 9, 8, 7, 6, -11, 5};
        assertEquals("[-11, 5]", Utils.arrayToString(t.asteroidCollision(arr)));
    }
}