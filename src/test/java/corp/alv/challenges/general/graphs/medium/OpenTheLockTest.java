package corp.alv.challenges.general.graphs.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OpenTheLockTest {

    private OpenTheLock t = new OpenTheLock();

    @Test
    void openTheLock_Case01() {
        String[] deadends = new String[]{"0201", "0101", "0102", "1212", "2002"};
        assertEquals(6, t.openLock(deadends, "0202"));
    }

    @Test
    void openTheLock_Case02() {
        String[] deadends = new String[]{"8888"};
        assertEquals(1, t.openLock(deadends, "0009"));
    }

    @Test
    void openTheLock_Case03() {
        String[] deadends = new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
        assertEquals(-1, t.openLock(deadends, "8888"));
    }

}