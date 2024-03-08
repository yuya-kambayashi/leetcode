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
public class LC3005Test {
       
    public int maxFrequencyElements(int[] nums) {
        
        return 4;
    }

    @Test
    void Case1() {
        
        int[] nums = {1,2,2,3,1,4};
        
        var actual = maxFrequencyElements(nums);
        
        var expected = 4;
        
        assertThat(actual).isEqualTo(expected);
    }
}
