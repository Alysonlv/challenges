package corp.alv.challenges.general.stack.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemovingStarsFromStringTest {

    private RemovingStarsFromString t = new RemovingStarsFromString();

    @Test
    void removeStars() {
        String input = "erase*****";
        assertEquals("", t.removeStars(input));
    }
}