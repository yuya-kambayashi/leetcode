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
public class LC0791Test {
    
    public String customSortString(String order, String s) {
        
        return true;
    }

    @Test
    void Case1() {
        
        String order = "cba";
        String s = "abcd";
        
        var actual = customSortString(order, s);
        
        var expected = "cbad";
        
        assertThat(actual).isEqualTo(expected);
    }

}
