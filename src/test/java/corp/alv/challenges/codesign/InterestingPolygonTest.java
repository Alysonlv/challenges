package corp.alv.challenges.codesign;

import corp.alv.challenges.codesign.edgeoftheoceon.InterestingPolygon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InterestingPolygonTest {

    @Test
    void solution_Size1() {
        assertEquals(1, InterestingPolygon.solution(1));
    }

    @Test
    void solution_Size2() {
        assertEquals(5, InterestingPolygon.solution(2));
    }

    @Test
    void solution_Size3() {
        assertEquals(13, InterestingPolygon.solution(3));
    }

    @Test
    void solution_Size4() {
        assertEquals(25, InterestingPolygon.solution(4));
    }

    @Test
    void solution_Size5() {
        assertEquals(41, InterestingPolygon.solution(5));
    }
}