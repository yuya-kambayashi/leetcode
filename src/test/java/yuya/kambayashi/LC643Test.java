package yuya.kambayashi;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LC643Test {
    void doTest(int[] nums, int k, double expected) {

        var actual = new LC643().findMaxAverage(nums, k);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void Case1() {
        doTest(new int[]{1,12,-5, -6, 50, 3}, 4, 12.75000);
    }
    @Test
    void Case2() {
        doTest(new int[]{5}, 1,  5.00000);
    }
}

