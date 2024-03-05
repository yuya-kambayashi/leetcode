/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yuya.kambayashi;

import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

/**
 *
 * @author kamba
 */
public class LC1750Test {
        
    public int minimumLength(String s) {
        
        return 1;
    }
    @Test
    void Case1() {
        
        String s = "ca";
      
        var actual = minimumLength(s);
        
        var expected = 2;
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    void Case2() {
        
        String s = "cabaabac";
      
        var actual = minimumLength(s);
        
        var expected = 0;
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    void Case3() {
        
        String s = "aabccabba";
      
        var actual = minimumLength(s);
        
        var expected = 3;
        assertThat(actual).isEqualTo(expected);
    }
}
