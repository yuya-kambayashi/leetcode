/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yuya.kambayashi;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

/**
 *
 * @author kamba
 */
public class LC0100Test {
       
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        if (p == null && q == null){
            return true;
        }
        if (p == null || q == null){
            return false;
        }
        
        if (p.val != q.val){
            return false;
        }
        
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    @Test
    void Case1() {
        
        var p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        var q = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        var actual = isSameTree(p, q);
        
        var expected = true;
        assertThat(actual).isEqualTo(expected);
    }

}
