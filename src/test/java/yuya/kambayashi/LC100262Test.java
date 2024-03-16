/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yuya.kambayashi;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 *
 * @author kamba
 */
public class LC100262Test {
    
    public int sumOfEncryptedInt(int[] nums) {
        
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            int n = nums[i];
            
            String s = Integer.valueOf(n).toString();
            char[] ca = s.toCharArray();
                        
            int max = 0;
            for(char c : ca){
                int nn = (int)(c - '0');
                max = Math.max(max, nn);
            }
            
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < s.length(); j++){
                sb.append(max);
            }
            
            String ss = sb.toString();
            
            int nv = Integer.valueOf(ss);
               
            ans += nv;
            
        }
        
        return ans;
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
