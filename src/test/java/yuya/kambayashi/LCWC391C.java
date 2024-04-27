package yuya.kambayashi;

import java.util.*;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class LCWC391C {

    public long minOperationsToMakeMedianK(int[] nums, int k) {

        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);

        int medianc = copy[copy.length / 2];

        if (medianc == k) {
            return 0L;
        }

        int mid = copy.length / 2;

        long ans = 0;

        while (true) {

            int dist = Math.abs(k - copy[mid]);

            copy[mid] = k;
            ans += dist;

            int[] t = Arrays.copyOf(copy, copy.length);
            Arrays.sort(t);
            if (Arrays.equals(copy, t)) {
                break;
            }
            copy = t;
        }

        return ans;
    }

    @Test
    void Case1() {

        int[] nums = {2, 5, 6, 8, 5};
        int k = 4;
        var expected = 2L;

        var actual = minOperationsToMakeMedianK(nums, k);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void Case2() {

        int[] nums = {2, 5, 6, 8, 5};
        int k = 7;
        var expected = 3L;

        var actual = minOperationsToMakeMedianK(nums, k);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void Case3() {

        int[] nums = {1, 2, 3, 4, 5, 6};
        int k = 4;
        var expected = 0L;

        var actual = minOperationsToMakeMedianK(nums, k);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void Case4() {

        int[] nums = {1, 2, 3, 4, 5, 6};
        int k = 4;
        var expected = 0L;

        var actual = minOperationsToMakeMedianK(nums, k);

        assertThat(actual).isEqualTo(expected);
    }

}
