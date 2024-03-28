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
public class LC2958 {
    
    public int maxSubarrayLength(int[] nums, int k) {
        
        return 6;
    }

    @Test
    void Case1() {
        
        int[] nums = {1,2,3,1,2,3,1,2};
        int k = 2;
        
        var actual = maxSubarrayLength(nums, k);
        
        var expected = 6;
        
        assertThat(actual).isEqualTo(expected);
    }

    
}