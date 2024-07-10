package corp.alv.challenges.hackerrank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecursiveDigitSumTest {

    @Test
    void superDigit() {

//        assertEquals(2, RecursiveDigitSum.superDigit("9875", 4));
//        assertEquals(3, RecursiveDigitSum.superDigit("148", 3));
        assertEquals(6, RecursiveDigitSum.superDigit("9875987598759875", 3));
    }
}