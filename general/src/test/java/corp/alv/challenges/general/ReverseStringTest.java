package corp.alv.challenges.general;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseStringTest {

    @Test
    void reverseWhileLoop() {
        String text = "Alyson Vasconcelos";
        String reversedText = ReverseString.reverseWhileLoop(text);

        assertEquals(new StringBuffer(text).reverse().toString(), reversedText);
    }

    @Test
    void reverseForLoop() {
        String text = "Alyson Vasconcelos";
        String reversedText = ReverseString.reverseForLoop(text);

        assertEquals(new StringBuffer(text).reverse().toString(), reversedText);
    }
}