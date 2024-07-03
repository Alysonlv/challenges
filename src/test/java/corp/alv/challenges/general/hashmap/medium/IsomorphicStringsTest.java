package corp.alv.challenges.general.hashmap.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsomorphicStringsTest {

    private IsomorphicStrings task = new IsomorphicStrings();

    @Test
    void isIsomorphic() {
        String s;
        String t;

        s = "egg";
        t = "add";
        assertTrue(task.isIsomorphic(s, t));
    }
}