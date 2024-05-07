package corp.alv.challenges.general;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CustomHashMapTest {

    @Test
    void put() {
        CustomHashMap<String, String> customHashMap = new CustomHashMap<String, String>();
        customHashMap.put("key_a", "value_a");

        assertEquals(1, customHashMap.size());
        assertEquals("value_a", customHashMap.get("key_a"));
        assertNull(customHashMap.get("key_b"));


        customHashMap.put("key_b", "value_b");
        customHashMap.put("key_c", "value_c");
        customHashMap.put("key_d", "value_d");
        customHashMap.put("key_e", "value_e");

        assertEquals(5, customHashMap.size());
        assertEquals("value_c", customHashMap.get("key_c"));
    }
}