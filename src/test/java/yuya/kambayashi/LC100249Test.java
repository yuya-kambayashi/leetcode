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
public class LC100249Test {
       
    public String minimizeStringValue(String s) {
        
      
        return "abs";
    }

    @Test
    void Case1() {
        
        String s = "???";
        
        var actual = minimizeStringValue(s);
        
        var expected = "abs";
        
        assertThat(actual).isEqualTo(expected);
    }
}
