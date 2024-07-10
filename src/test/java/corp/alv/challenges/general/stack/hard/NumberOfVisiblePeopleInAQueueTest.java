package corp.alv.challenges.general.stack.hard;

import corp.alv.challenges.utils.Utils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfVisiblePeopleInAQueueTest {

    private NumberOfVisiblePeopleInAQueue t = new NumberOfVisiblePeopleInAQueue();

    @Test
    void canSeePersonsCount() {

        int[] arr = new int[]{10, 6, 8, 5, 11, 9};
//        assertEquals("[3,1,2,1,1,0]", Utils.arrayToString(t.canSeePersonsCount(arr)).replace(" ", ""));

//        arr = new int[]{4, 3, 2, 1};
//        assertEquals("[1,1,1,0]", Utils.arrayToString(t.canSeePersonsCount(arr)).replace(" ", ""));

//        arr = new int[]{11, 19, 12, 15, 14, 18, 7, 1, 8, 9};
//        assertEquals("[1,3,1,2,1,3,2,1,1,0]", Utils.arrayToString(t.canSeePersonsCount(arr)).replace(" ", ""));

        arr = new int[]{11, 19, 12, 15, 14, 18, 7, 1, 8, 19};
        assertEquals("[1,4,1,2,1,3,2,1,1,0]", Utils.arrayToString(t.canSeePersonsCount(arr)).replace(" ", ""));
    }
}