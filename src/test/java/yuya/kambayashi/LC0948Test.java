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
public class LC0948Test {
       
    public int bagOfTokensScore(int[] tokens, int power) {
        
        return 1;
    }
    @Test
    void Case1() {
        
        int[] tokens = {100};
        int power = 50;
      
        var actual = bagOfTokensScore(tokens, power);
        
        var expected = 0;
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    void Case2() {
        
        int[] tokens = {200, 100};
        int power = 150;
        
        
        var actual = bagOfTokensScore(tokens, power);
        
        var expected = 1;
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    void Case3() {
        
        int[] tokens = {100,200,300,400};
        int power = 200;
        
        var actual = bagOfTokensScore(tokens, power);
        
        var expected = 2;
        assertThat(actual).isEqualTo(expected);
    }
}
