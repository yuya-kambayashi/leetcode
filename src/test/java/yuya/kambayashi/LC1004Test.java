package yuya.kambayashi;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;

import static org.assertj.core.api.Assertions.assertThat;

public class LC1004Test {
    void doTest(int[] nums, int k, int expected) {

        var actual = new LC1004().longestOnes(nums, k);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @Disabled
    void Case1() {
        doTest(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2, 6);
    }
    @Test
    @Disabled
    void Case2() {
        doTest( new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3, 10);
    }
}
