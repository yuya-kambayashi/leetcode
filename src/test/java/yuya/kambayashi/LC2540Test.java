/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yuya.kambayashi;

import java.util.HashSet;
import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

/**
 *
 * @author kamba
 */
public class LC2540Test {
     
    public int getCommon(int[] nums1, int[] nums2) {
  
        Set<Integer> set1 = new HashSet<>();
        for(int n : nums1){
            set1.add(n);
        }
        
        int min = Integer.MAX_VALUE;
        for(int n : nums2){
            if (set1.contains(n)){
                min = Math.min(min, n);
            }
        }
        
        if (min == Integer.MAX_VALUE){
            return -1;
        }
        return min;
    }
  

    @Test
    void Case1(){
            
        int[] nums1 = {1,2,3};    
        int[] nums2 = {2,4};

        
        var actual = getCommon(nums1, nums2);
        
        var expected = 2;
        
        assertThat(actual).isEqualTo(expected);
    }
        @Test
    void Case2(){
            
        int[] nums1 = {1,2,3,6};    
        int[] nums2 = {2,3,4,5};

        
        var actual = getCommon(nums1, nums2);
        
        var expected = 2;
        
        assertThat(actual).isEqualTo(expected);
    }

}
