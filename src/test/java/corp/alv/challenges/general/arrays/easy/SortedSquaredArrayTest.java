package corp.alv.challenges.general.arrays.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortedSquaredArrayTest {

    @Test
    void case01() {
        int[] array = {-1, 2, 3};

        int[] arrSolution1 = SortedSquaredArray.sortedSquaredArraySolution1(array);
        int[] arrSolution2 = SortedSquaredArray.sortedSquaredArraySolution2(array);

        int[] expected = new int[] {1, 4, 9};

        doTest(expected, arrSolution1, arrSolution2);
    }

    @Test
    void case02() {
        int[] array = {-5, -4, 2, 3};

        int[] arrSolution1 = SortedSquaredArray.sortedSquaredArraySolution1(array);
        int[] arrSolution2 = SortedSquaredArray.sortedSquaredArraySolution2(array);

        int[] expected = new int[] {4, 9, 16, 25};

        doTest(expected, arrSolution1, arrSolution2);
    }

    @Test
    void case03() {
        int[] array = {-5, -5, 2, 3};

        int[] arrSolution1 = SortedSquaredArray.sortedSquaredArraySolution1(array);
        int[] arrSolution2 = SortedSquaredArray.sortedSquaredArraySolution2(array);

        int[] expected = new int[] {4, 9, 25, 25};

        doTest(expected, arrSolution1, arrSolution2);
    }

    void doTest(int[] expected, int[] arrSolution1, int[] arrSolution2) {
        assertArrayEquals(expected, arrSolution1);
        assertArrayEquals(expected, arrSolution1);
    }

}
