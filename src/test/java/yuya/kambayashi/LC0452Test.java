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
public class LC0452Test {
    public int findMinArrowShots(int[][] points) {
        
        return 4;
    }

    @Test
    void Case1() {
        int[][] points = {{10,16},{2,8},{1,6},{7,12}};
        var actual = findMinArrowShots(points);
        
        var expected = 4;
        
        assertThat(actual).isEqualTo(expected);
    }
}
