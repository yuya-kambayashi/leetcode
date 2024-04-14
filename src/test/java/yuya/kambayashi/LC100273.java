package yuya.kambayashi;

import java.util.*;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class LC100273 {

    public long numberOfSubarrays(int[] nums) {

        long ans = 0L;

        for (int bit = 0; bit < 1 << nums.length; bit++) {

            List<Integer> sub = new ArrayList<>();

            int before = -1;

            for (int i = 0; i < nums.length; i++) {

                if ((1 & bit >> i) == 1) {
                    if (before == -1) {
                        sub.add(nums[i]);
                        before = i;
                    } else if (Math.abs(before - i) > 1) {
                        break;
                    } else {
                        sub.add(nums[i]);
                        before = i;
                    }
                }
            }

            boolean ok = false;

            if (sub.isEmpty()) {
                continue;
            }

            if (sub.get(0) == sub.get(sub.size() - 1)) {
                int max = 0;
                for (int s : sub) {
                    max = Math.max(max, s);
                }
                if (max == sub.get(0)) {
                    ok = true;
                }
            }
            if (ok) {
                ans++;
            }

        }

        return ans;
    }

    @Test
    void Case1() {

        int[] nums = {1, 4, 3, 3, 2};
        //int n = 
        var expected = 6;

        var actual = numberOfSubarrays(nums);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void Case2() {

        int[] nums = {3, 3, 3};
        //int n = 
        var expected = 6;

        var actual = numberOfSubarrays(nums);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void Case3() {

        int[] nums = {1};
        //int n = 
        var expected = 1;

        var actual = numberOfSubarrays(nums);

        assertThat(actual).isEqualTo(expected);
    }

}
