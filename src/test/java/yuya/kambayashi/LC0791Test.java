/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yuya.kambayashi;

import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 *
 * @author kamba
 */
public class LC0791Test {
    
    public String customSortString(String order, String s) {
        
        // Create char array for editing
        int N = s.length();
        Character[] result = new Character[N];
        for (int i = 0; i < N; i++) {
            result[i] = s.charAt(i);
        }

        // Define the custom comparator
        Arrays.sort(result, (c1, c2) -> {
            // The index of the character in order determines the value to be sorted by
            return order.indexOf(c1) - order.indexOf(c2);
        });

        // Return the result
        String resultString = "";
        for (Character c: result) {
            resultString += c;
        }
        return resultString;
    }

    @Test @Disabled
    void Case1() {
        
        String order = "cba";
        String s = "abcd";
        
        var actual = customSortString(order, s);
        
        var expected = "cbad";
        
        assertThat(actual).isEqualTo(expected);
    }
    @Test @Disabled
    void Case2() {
        
        String order = "bcafg";
        String s = "abcd";
        
        var actual = customSortString(order, s);
        
        var expected = "bcad";
        
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    void Case3() {
        
        String order = "kqep";
        String s = "pekeq";
        
        var actual = customSortString(order, s);
        
        var expected = "kqeep";
        
        assertThat(actual).isEqualTo(expected);
    }

}
