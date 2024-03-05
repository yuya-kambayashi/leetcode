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
public class LC0948Test {
       
    public int bagOfTokensScore(int[] tokens, int power) {
        int low = 0;
        int high = tokens.length - 1;
        int score = 0;
        Arrays.sort(tokens);
        
        while(low <= high){
            if (power >= tokens[low]){
                score += 1;
                power -= tokens[low];
                low += 1;
            }
            else if (low < high && score > 0){
                score -= 1;
                power += tokens[high];
                high -= 1;
            }
            else{
                return score;
            }
        }
        return score;
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
    @Test
    void Case4() {
        
        int[] tokens = {25, 91};
        int power = 99;
        
        var actual = bagOfTokensScore(tokens, power);
        
        var expected = 1;
        assertThat(actual).isEqualTo(expected);
    }
}
