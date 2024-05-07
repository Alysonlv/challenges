package corp.alv.challenges.general.graphs;

import corp.alv.challenges.general.graphs.easy.RiverSizes;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
class RiverSizesTest {

    @Test
    void riverSizes_case01() {
        int[][] matrix = {
                {1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 0}
        };

        List<Integer> sizes = RiverSizes.riverSizes(matrix);

        assertEquals(5, sizes.size());
    }

    @Test
    void riverSizes_case02() {
        int[][] matrix = {
                {0}
        };

        List<Integer> sizes = RiverSizes.riverSizes(matrix);

        assertEquals(0, sizes.size());
    }

    @Test
    void riverSizes_case03() {
        int[][] matrix = {
                {1}
        };

        List<Integer> sizes = RiverSizes.riverSizes(matrix);

        assertEquals(1, sizes.size());
    }

    @Test
    void riverSizes_case04() {
        int[][] matrix = {
                {1, 1}
        };

        List<Integer> sizes = RiverSizes.riverSizes(matrix);

        assertEquals(1, sizes.size());
    }

    @Test
    void riverSizes_case05() {
        int[][] matrix = {
                {0, 1}
        };

        List<Integer> sizes = RiverSizes.riverSizes(matrix);

        assertEquals(1, sizes.size());
    }


    @Test
    void riverSizes_case07() {
        int[][] matrix = {
                {1, 1, 0, 0, 1, 0, 1, 1},
                {1, 0, 1, 1, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 1, 1, 1},
                {0, 1, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 1, 0, 1, 0, 0},
                {1, 0, 1, 0, 0, 1, 0, 1},
                {1, 1, 0, 1, 0, 1, 1, 1},
                {0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 1, 1, 0, 0, 0},
                {1, 0, 1, 1, 0, 1, 1, 0}
        };

        List<Integer> sizes = RiverSizes.riverSizes(matrix);

        assertEquals(10, sizes.size());
    }
}