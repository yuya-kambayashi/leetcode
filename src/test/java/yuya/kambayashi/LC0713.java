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
public class LC0713 {
       
    public int numSubarrayProductLessThanK(int[] nums, int k){
        return 8;
    }

    @Test
    void Case1() {
        
        int[] nums = {10,5,2,6};
        int k = 100;
        
        var actual = numSubarrayProductLessThanK(nums, k);
        
        var expected = 8;
        
        assertThat(actual).isEqualTo(expected);
    }

}
