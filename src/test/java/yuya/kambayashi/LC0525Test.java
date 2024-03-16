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
public class LC0525Test {
    
    public int findMaxLength(int[] nums) {
        
        return 2;
    }

    @Test
    void Case1() {
        
        int[] nums = {0,1};
        
        var actual = findMaxLength(nums);
        
        var expected = 2;
        
        assertThat(actual).isEqualTo(expected);
    }
}
