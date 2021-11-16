package corp.alv.challenges.general.strings.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstNonRepeatingCharacterTest {

    @Test
    void firstNonRepeatingCharacter() {
        assertEquals(4, FirstNonRepeatingCharacter.firstNonRepeatingCharacter("abcdeabcd"));
        assertEquals(0, FirstNonRepeatingCharacter.firstNonRepeatingCharacter("abbccddeeffghjghk"));
        assertEquals(6, FirstNonRepeatingCharacter.firstNonRepeatingCharacter("aabbccdffgghjhjl"));
        assertEquals(-1, FirstNonRepeatingCharacter.firstNonRepeatingCharacter("abcdefghabcdefgh"));
    }
}