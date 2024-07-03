package corp.alv.challenges.general.strings.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrossingPathTest {

    private CrossingPath task = new CrossingPath();
    @Test
    void isPathCrossing() {
        String paths = "NESWW";
        assertTrue(task.isPathCrossing(paths));

        assertFalse(task.isPathCrossing("ENNNNNNNNNNNEEEEEEEEEESSSSSSSSSS"));
    }
}