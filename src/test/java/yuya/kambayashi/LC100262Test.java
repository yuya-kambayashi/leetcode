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
public class LC100262Test {
    
    public int sumOfEncryptedInt(int[] nums) {
        
        return 1;
    }

    @Test
    void Case1() {
        
        int[] nums = {1,2,3};
        
        var actual = sumOfEncryptedInt(nums);
        
        var expected = 6;
        
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    void Case2() {
        
        int[] nums = {10,21,31};
        
        var actual = sumOfEncryptedInt(nums);
        
        var expected = 66;
        
        assertThat(actual).isEqualTo(expected);
    }
}
