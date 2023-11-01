package yuya.kambayashi;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LC011Test {
    void doTest(int[] height, int expected) {

        var actual = new LC011().maxArea(height);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void Case1() {
        doTest(new int[]{1,8,6,2,5,4,8,3,7}, 49);
    }
    @Test
    void Case2() {
        doTest(new int[]{1,1}, 1);
    }
}