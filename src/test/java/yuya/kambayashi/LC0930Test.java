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
public class LC0930Test {
    public int numSubarraysWithSum(int[] nums, int goal) {
        
        return 4;
    }

    @Test
    void Case1() {
        
        int[] nums = {1,0,1,0,1};
        int goal = 2;
        
        var actual = numSubarraysWithSum(nums ,goal);
        
        var expected = 4;
        
        assertThat(actual).isEqualTo(expected);
    }

}
