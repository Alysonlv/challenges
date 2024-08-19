package corp.alv.challenges.general.graphs.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumGeneticMutationTest {

    private MinimumGeneticMutation t = new MinimumGeneticMutation();

    @Test
    void minMutation_Case01() {
        String startGene = "AACCGGTT";
        String endGene = "AACCGGTA";
        String[] bank = new String[]{"AACCGGTA"};

        assertEquals(1, t.minMutation(startGene, endGene, bank));
    }

    @Test
    void minMutation_Case02() {
        String startGene = "AACCGGTT";
        String endGene = "AAACGGTA";
        String[] bank = new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"};

        assertEquals(2, t.minMutation(startGene, endGene, bank));
    }

    @Test
    void minMutation_Case03() {
        String startGene = "AACCTTGG";
        String endGene = "AATTCCGG";
        String[] bank = new String[]{"AATTCCGG", "AACCTGGG", "AACCCCGG", "AACCTACC"};

        assertEquals(-1, t.minMutation(startGene, endGene, bank));
    }
}