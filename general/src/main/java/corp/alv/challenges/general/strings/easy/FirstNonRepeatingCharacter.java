package corp.alv.challenges.general.strings.easy;

import java.util.HashMap;

public class FirstNonRepeatingCharacter {

    public static int firstNonRepeatingCharacter(String string) {
        HashMap<Character, Integer> frequencies = new HashMap<>();

        for (int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);
            frequencies.put(character, frequencies.getOrDefault(character, 0) + 1);
        }

        for (int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);
            if (frequencies.get(character) == 1) {
                return i;
            }
        }

        return -1;
    }
}
