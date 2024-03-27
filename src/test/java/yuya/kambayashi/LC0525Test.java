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
public class LC0525Test {
    
    public int findMaxLength(int[] nums) {
 
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        int maxlen = 0, count = 0;
        
        for(int i = 0; i < nums.length; i++){
            count = count + (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(count)){
                maxlen = Math.max(maxlen, i - map.get(count));
            }else{
                map.put(count, i);
            }
        }
        return maxlen;
            }

    @Test
    void Case1() {
        
        int[] nums = {0,1,1};
        
        var actual = findMaxLength(nums);
        
        var expected = 2;
        
        assertThat(actual).isEqualTo(expected);
    }
}
