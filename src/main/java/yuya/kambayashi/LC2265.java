package yuya.kambayashi;

import org.apache.commons.lang3.tuple.Pair;

public class LC2265 {

    int count = 0;
    public int averageOfSubtree(TreeNode root) {

        postOrder(root);
        return count;

    }
    Pair<Integer, Integer> postOrder(TreeNode root){
        if (root == null){
            return Pair.of(0, 0);
        }

        Pair<Integer, Integer> left = postOrder(root.left);
        Pair<Integer, Integer> right = postOrder(root.right);

        int nodeSum = left.getLeft() + right.getLeft() + root.val;
        int nodeCount = left.getRight() + right.getRight() + 1;

        if (root.val == nodeSum / (nodeCount)){
            count++;
        }
        return Pair.of(nodeSum, nodeCount);
    }
}
