package yuya.kambayashi;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LC1679Test {
    void doTest(int[] nums, int k, int expected) {

        var actual = new LC1679().maxOperations(nums, k);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void Case1() {
        doTest(new int[]{1,2,3,4}, 5, 2);
    }
    @Test
    void Case2() {
        doTest(new int[]{3,1,3,4,3}, 6, 1);
    }
}