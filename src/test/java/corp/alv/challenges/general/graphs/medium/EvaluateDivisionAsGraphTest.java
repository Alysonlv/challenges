package corp.alv.challenges.general.graphs.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EvaluateDivisionAsGraphTest {

    private EvaluateDivisionAsGraph t = new EvaluateDivisionAsGraph();

    @Test
    void calcEquation_Case01() {
        List<List<String>> equations = Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c"));
        double[] values = new double[]{2.0, 3.0};
        List<List<String>> queries = Arrays.asList(
                Arrays.asList("a", "c"),
                Arrays.asList("b", "a"),
                Arrays.asList("a", "e"),
                Arrays.asList("a", "a"),
                Arrays.asList("x", "x")
        );

        double[] expectedResult = new double[]{6.0, 0.5, -1.0, 1.0, -1.0};
        assertArrayEquals(expectedResult, t.calcEquation(equations, values, queries));
    }

    @Test
    void calcEquation_Case02() {
        List<List<String>> equations = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("b", "c"),
                Arrays.asList("bc", "cd"));
        double[] values = new double[]{1.5, 2.5, 5.0};
        List<List<String>> queries = Arrays.asList(
                Arrays.asList("a", "c"),
                Arrays.asList("c", "b"),
                Arrays.asList("bc", "cd"),
                Arrays.asList("cd", "bc")
        );

        double[] expectedResult = new double[]{3.75, 0.4, 5.0, 0.2};
        assertArrayEquals(expectedResult, t.calcEquation(equations, values, queries));
    }

    @Test
    void calcEquation_Case03() {
        List<List<String>> equations = Arrays.asList(
                Arrays.asList("a", "b"));
        double[] values = new double[]{0.5};
        List<List<String>> queries = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("b", "a"),
                Arrays.asList("a", "c"),
                Arrays.asList("x", "y")
        );

        double[] expectedResult = new double[]{0.5, 2.0, -1.0, -1.0};
        assertArrayEquals(expectedResult, t.calcEquation(equations, values, queries));
    }

    @Test
    void calcEquation_Case04() {
        List<List<String>> equations = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("c", "d"));
        double[] values = new double[]{1.0, 1.0};
        List<List<String>> queries = Arrays.asList(
                Arrays.asList("a", "c"),
                Arrays.asList("b", "d"),
                Arrays.asList("b", "a"),
                Arrays.asList("d", "c")
        );

        double[] expectedResult = new double[]{-1.0, -1.0, 1.0, 1.0};
        assertArrayEquals(expectedResult, t.calcEquation(equations, values, queries));
    }

    @Test
    void calcEquation_Case05() {
        List<List<String>> equations = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("b", "c"),
                Arrays.asList("a", "c"),
                Arrays.asList("d", "e"));
        double[] values = new double[]{2.0, 3.0, 6.0, 1.0};
        List<List<String>> queries = Arrays.asList(
                Arrays.asList("a", "c"),
                Arrays.asList("b", "c"),
                Arrays.asList("a", "e"),
                Arrays.asList("a", "a"),
                Arrays.asList("x", "x"),
                Arrays.asList("a", "d")
        );

        double[] expectedResult = new double[]{6.0, 3.0, -1.0, 1.0, -1.0, -1.0};
        assertArrayEquals(expectedResult, t.calcEquation(equations, values, queries));
    }
}