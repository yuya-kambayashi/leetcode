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
public class LC2540Test {
     
    public int getCommon(int[] nums1, int[] nums2) {
        
        return 2;
    }

    @Test
    void Case1(){
            
        int[] nums1 = {1,2,3};    
        int[] nums2 = {2,4};

        
        var actual = getCommon(nums1, nums2);
        
        var expected = 2;
        
        assertThat(actual).isEqualTo(expected);
    }

}
