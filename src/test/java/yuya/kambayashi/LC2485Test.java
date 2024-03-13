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
public class LC2485Test {
    public int pivotInteger(int n) {

        
        return 1;
    }

    @Test
    void Case1() {
        
        int n = 8;
        
        var actual = pivotInteger(n);
        
        var expected = 6;
        
        assertThat(actual).isEqualTo(expected);
    }
}
