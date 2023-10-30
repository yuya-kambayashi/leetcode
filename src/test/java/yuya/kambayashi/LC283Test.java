package yuya.kambayashi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LC283Test {
    void doTest(int[] nums, int[] expected) {

        new LC283().moveZeroes(nums);

        assertThat(nums).containsExactly(expected);
    }

    @Test
    void Case1() {
        doTest(new int[]{0,1,0,3,12}, new int[]{1,3,12,0,0});
    }
    @Test
    void Case2() {
        doTest(new int[]{0}, new int[]{0});
    }
}
