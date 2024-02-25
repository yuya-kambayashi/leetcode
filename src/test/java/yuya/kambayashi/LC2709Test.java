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
public class LC2709Test {
       
    public boolean canTraverseAllPairs(int[] nums) {
        
        return true;
    }

    @Test
    void Case1() {
        int[] nums = {2,3,6};
        var actual = canTraverseAllPairs(nums);
        
        var expected = true;
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    void Case2() {
        int[] nums = {3,9,5};
        var actual = canTraverseAllPairs(nums);
        
        var expected = false;
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    void Case3() {
        int[] nums = {4,3,12,8};
        var actual = canTraverseAllPairs(nums);
        
        var expected = true;
        assertThat(actual).isEqualTo(expected);
    }
}
