package yuya.kambayashi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LC334Test {
    void doTest(int[] nums, boolean expected) {

        var actual = new LC334().increasingTriplet(nums);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void Case1() {
        doTest(new int[]{1,2,3,4,5}, true);
    }
    @Test
    void Case2() {
        doTest(new int[]{5,4,3,2,1}, false);
    }
    @Test
    void Case3() {
        doTest(new int[]{2,1,5,0,4,6}, true);
    }
}
