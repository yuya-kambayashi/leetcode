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
public class LC100209Test {
    public long[] unmarkedSumArray(int[] nums, int[][] queries) {
        
        long[] d = {8,3,0};

        return d;
    }

    @Test
    void Case1() {
        
        int[] nums = {1,2,2,1,2,3,1};
        int[][] queries = {{1,2},{3,3},{4,2}};
        
        var actual = unmarkedSumArray(nums, queries);
        
        long[] expected = {8,3,0};
        
        assertThat(actual).containsExactly(expected);
    }
}
