package corp.alv.challenges.general.stack.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimplifyPathTest {

    private SimplifyPath t = new SimplifyPath();

    @Test
    void simplifyPath() {
        String path;
        String expected;

        path = "/home/";
        expected = "/home";
        assertEquals(expected, t.simplifyPath(path));

        path = "/home//foo/";
        expected = "/home/foo";
        assertEquals(expected, t.simplifyPath(path));

        path = "/home/user/Documents/../Pictures";
        expected = "/home/user/Pictures";
        assertEquals(expected, t.simplifyPath(path));

        path = "/.../a/../b/c/../d/./";
        expected = "/.../b/d";
        assertEquals(expected, t.simplifyPath(path));

        path = "/../";
        expected = "/";
        assertEquals(expected, t.simplifyPath(path));
    }
}