package corp.alv.challenges.general.arrays.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindHighestAltitudeTest {

    private FindHighestAltitude task = new FindHighestAltitude();

    @Test
    void largestAltitude() {
        int[] gain = new int[] {-5,1,5,0,-7};
        int output = 1;
        assertEquals(output, task.largestAltitude(gain));

        gain = new int[] {-4,-3,-2,-1,4,3,2};
        output = 0;
        assertEquals(output, task.largestAltitude(gain));
    }
}