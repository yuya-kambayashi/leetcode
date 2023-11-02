package yuya.kambayashi;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LC2265Test {
    void doTest(TreeNode root, int expected) {

        var actual = new LC2265().averageOfSubtree(root);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void Case1() {
        TreeNode left = new TreeNode(8, new TreeNode(0), new TreeNode(1));
        TreeNode right = new TreeNode(5, null, new TreeNode(6));

        TreeNode root = new TreeNode(1, left, right);

        doTest(root, 5);
    }
    @Test
    void Case2() {
        TreeNode root = new TreeNode(1);
        doTest(root, 1);
    }
}
