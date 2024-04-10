package yuya.kambayashi;

import java.util.*;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class LCWC391A {

    public int longestMonotonicSubarray(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }

        int before = nums[0];
        int increaceCnt = 1;
        int decreaceCnt = 1;

        int max = 0;

        for (int i = 1; i < nums.length; i++) {
            int t = nums[i];
            if (before == t) {
                increaceCnt = 1;
                decreaceCnt = 1;

            } else if (before < t) {
                increaceCnt++;
                decreaceCnt = 1;

            } else if (before > t) {
                increaceCnt = 1;
                decreaceCnt++;
            }
            before = t;

            max = Math.max(Math.max(increaceCnt, decreaceCnt), max);
        }

        return max;
    }

    @Test
    void Case1() {

        int[] nums = {1, 4, 3, 3, 2};
        var expected = 2;

        var actual = longestMonotonicSubarray(nums);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void Case2() {

        int[] nums = {3, 3, 3, 3};
        var expected = 1;

        var actual = longestMonotonicSubarray(nums);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void Case3() {

        int[] nums = {3, 2, 1};
        var expected = 3;

        var actual = longestMonotonicSubarray(nums);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void Case5() {

        int[] nums = {1, 1, 5};
        var expected = 2;

        var actual = longestMonotonicSubarray(nums);

        assertThat(actual).isEqualTo(expected);
    }

}
