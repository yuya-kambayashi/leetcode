/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yuya.kambayashi;

import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

/**
 *
 * @author kamba
 */
public class LC0713 {
       
    public int numSubarrayProductLessThanK(int[] nums, int k){

        if (k <= 1){
            return 0;
        }
        
        int totalCount = 0;
        int product = 1;
        for(int left = 0, right = 0; right < nums.length; right++){
            
            product *= nums[right];
            
            while(product >= k){
                product /= nums[left++];
            }
            
            totalCount += right - left + 1;
        }
        
        return totalCount;
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
