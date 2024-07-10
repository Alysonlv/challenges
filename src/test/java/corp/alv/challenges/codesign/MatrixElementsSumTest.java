package corp.alv.challenges.codesign;

import corp.alv.challenges.codesign.edgeoftheoceon.MatrixElementsSum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixElementsSumTest {

    @Test
    void solution() {
        /*
        matrix:
        [[0,1,1,2],
         [0,5,0,0],
         [2,0,3,3]]
         */

        assertEquals(9, MatrixElementsSum.solution(new int[][]{
                {0, 1, 1, 2},
                {0, 5, 0, 0},
                {2, 0, 3, 3}
        }));

        assertEquals(9, MatrixElementsSum.solution(new int[][]{
                {1, 1, 1, 0},
                {0, 5, 0, 1},
                {2, 1, 3, 10}
        }));

        assertEquals(5, MatrixElementsSum.solution(new int[][]{
                {1, 0, 3},
                {0, 2, 1},
                {1, 2, 0}
        }));

        assertEquals(15, MatrixElementsSum.solution(new int[][]{
                {4, 0, 1},
                {10, 7, 0},
                {0, 0, 0},
                {9, 1, 2}
        }));
    }
}