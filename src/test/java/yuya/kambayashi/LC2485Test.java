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
public class LC2485Test {
    public int pivotInteger(int n) {
        
        for(int i = 1; i <= n; i++){
            
            // 前半の和
            int before = 0;
            for(int j = 1; j <= i; j++){
                before += j;
            }
            
            // 後半の和
            int after = 0;
            for(int j = i; j <= n; j++){
                after += j;
            }
            
            if (before == after){
                return i;
            }
        }

        
        return -1;
    }
    @Disabled
    @Test
    void Case1() {
        
        int n = 8;
        
        var actual = pivotInteger(n);
        
        var expected = 6;
        
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    void Case2() {
        
        int n = 1;
        
        var actual = pivotInteger(n);
        
        var expected = 1;
        
        assertThat(actual).isEqualTo(expected);
    }
        @Disabled
    @Test
    void Case3() {
        
        int n = 4;
        
        var actual = pivotInteger(n);
        
        var expected = -1;
        
        assertThat(actual).isEqualTo(expected);
    }
}
