package yuya.kambayashi;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LC501Test {
    void doTest(TreeNode root, int[] expected) {

        var actual = new LC501().findMode(root);

        assertThat(actual).containsExactly(expected);
    }

    @Test
    void Case1() {
        TreeNode right = new TreeNode(2, new TreeNode(2), null);

        TreeNode root = new TreeNode(1, null, right);

        doTest(root, new int[]{2});
    }
    @Test
    void Case2() {
        TreeNode root = new TreeNode(0);
        doTest(root, new int[]{0});
    }
}
