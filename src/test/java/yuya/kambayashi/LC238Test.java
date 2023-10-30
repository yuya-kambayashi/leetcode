package yuya.kambayashi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LC238Test {
    void doTest(int[] nums, int[] expected) {

        var actual = new LC238().productExceptSelf(nums);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void Case1() {
        doTest(new int[]{1,2,3,4}, new int[]{24,12,8,6});
    }
    @Test
    void Case2() {
        doTest(new int[]{-1,1,0,-3,3}, new int[]{0,0,9,0,0});
    }
}