package yuya.kambayashi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LC443Test {
    void doTest(char[] nums, int expected) {

        var actual = new LC443().compress(nums);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void Case1() {
        doTest(new char[]{'a','a','b','b','c','c','c'}, 6);
    }
    @Test
    void Case2() {
        doTest(new char[]{'a'}, 1);
    }
    @Test
    void Case3() {
        doTest(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}, 4);
    }
}
