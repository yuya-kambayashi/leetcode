package yuya.kambayashi;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LC2092Test {
    void doTest(int n, int[][] meetings, int firstPerson, List<Integer> expected) {

        var actual = new LC2092().findAllPeople(n, meetings, firstPerson);

        assertThat(actual).containsAnyElementsOf(expected);
        
    }

    @Test
    void Case1() {
        int n = 6;
        int[][] mettings = {{1,2,5},{2,3,8},{1,5,10}};
        int firstPerson = 4;
        
        List<Integer> expected = Arrays.asList(0,1,2,3,5);
        
        doTest(n, mettings, firstPerson, expected);
    }
    @Test
    void Case2() {
        int n = 4;
        int[][] mettings = {{3,1,3},{1,2,2},{0,3,3}};
        int firstPerson = 3;
        
        List<Integer> expected = Arrays.asList(0,1,3);
        
        doTest(n, mettings, firstPerson, expected);
    }
    @Test
    void Case3() {
        int n = 5;
        int[][] mettings = {{3,4,2},{1,2,1},{2,3,1}};
        int firstPerson = 1;
        
        List<Integer> expected = Arrays.asList(0,1,2,3,4);
        
        doTest(n, mettings, firstPerson, expected);
    }
}
