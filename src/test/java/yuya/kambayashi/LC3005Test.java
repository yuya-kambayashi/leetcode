/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yuya.kambayashi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

/**
 *
 * @author kamba
 */
public class LC3005Test {
       
    public int maxFrequencyElements(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int max = 0;
        for(int v : map.values()){
            max = Math.max(v, max);
        }
        
        int ans = 0;
        for(int v : map.values()){
            if (v == max){
                ans += max;
            }
        }
        
        return ans;
    }

    @Test
    void Case1() {
        
        int[] nums = {1,2,2,3,1,4};
        
        var actual = maxFrequencyElements(nums);
        
        var expected = 4;
        
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    void Case2() {
        
        int[] nums = {1,2,3,4,5};
        
        var actual = maxFrequencyElements(nums);
        
        var expected = 5;
        
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    void Case3() {
        
        int[] nums = {1,1,1,1,1};
        
        var actual = maxFrequencyElements(nums);
        
        var expected = 5;
        
        assertThat(actual).isEqualTo(expected);
    }
}
