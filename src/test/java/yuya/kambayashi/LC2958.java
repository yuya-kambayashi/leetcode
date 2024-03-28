/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yuya.kambayashi;

import java.util.HashMap;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

/**
 *
 * @author kamba
 */
public class LC2958 {
    
    public int maxSubarrayLength(int[] nums, int k) {
        
       int ans = 0, start = -1;
       
       Map<Integer, Integer> freq = new HashMap<>();
       
       for(int end = 0; end < nums.length; end++){
           freq.put(nums[end], freq.getOrDefault(nums[end], 0) + 1);
           
           while(freq.get(nums[end]) > k){
               start++;
               freq.put(nums[start], freq.get(nums[start]) -1);
           }
           ans = Math.max(ans, end - start);
       }
        
        return ans;
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