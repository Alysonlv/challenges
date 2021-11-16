package corp.alv.challenges.general.arrays.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstDuplicateValueTest {

    int[] array01 = new int[] {2, 1, 5, 6, 2, 1, 7};
    int[] array02 = new int[] {2, 1, 5, 1, 2, 1, 7};
    int[] array03 = new int[] {2, 1, 5, -2, 4, 9, 7};

    @Test
    void firstDuplicateValueSolution1_Case01() {
        int firstDuplicatedValue = FirstDuplicateValue.firstDuplicateValueSolution1(array01);

        assertEquals(2, firstDuplicatedValue);
    }

    @Test
    void firstDuplicateValueSolution1_Case02() {
        int firstDuplicatedValue = FirstDuplicateValue.firstDuplicateValueSolution1(array02);

        assertEquals(1, firstDuplicatedValue);
    }

    @Test
    void firstDuplicateValueSolution1_Case03() {
        int firstDuplicatedValue = FirstDuplicateValue.firstDuplicateValueSolution1(array03);

        assertEquals(-1, firstDuplicatedValue);
    }

    @Test
    void firstDuplicateValueSolution2_Case01() {
        int firstDuplicatedValue = FirstDuplicateValue.firstDuplicateValueSolution2(array01);

        assertEquals(2, firstDuplicatedValue);
    }

    @Test
    void firstDuplicateValueSolution2_Case02() {
        int firstDuplicatedValue = FirstDuplicateValue.firstDuplicateValueSolution2(array02);

        assertEquals(1, firstDuplicatedValue);
    }

    @Test
    void firstDuplicateValueSolution2_Case03() {
        int firstDuplicatedValue = FirstDuplicateValue.firstDuplicateValueSolution1(array03);

        assertEquals(-1, firstDuplicatedValue);
    }
}