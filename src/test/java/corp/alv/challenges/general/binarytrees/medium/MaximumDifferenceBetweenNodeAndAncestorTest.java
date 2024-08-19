package corp.alv.challenges.general.binarytrees.medium;

import corp.alv.challenges.domain.TreeNode;
import corp.alv.challenges.general.binarytrees.dfs.medium.MaximumDifferenceBetweenNodeAndAncestor;
import corp.alv.challenges.utils.BinaryTreeUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumDifferenceBetweenNodeAndAncestorTest {

    @Test
    void maxAncestorDiff() {
        MaximumDifferenceBetweenNodeAndAncestor t = new MaximumDifferenceBetweenNodeAndAncestor();

        TreeNode node = BinaryTreeUtils.createBinaryTree(new Integer[]{8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13});
        assertEquals(7, t.maxAncestorDiff(node));
    }
}