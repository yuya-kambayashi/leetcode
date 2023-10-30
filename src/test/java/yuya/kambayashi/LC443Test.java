package yuya.kambayashi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LC443Test {
    void doTest(char[] nums, char[] expected) {

        var actual = new LC443().compress(nums);

        Assertions.assertArrayEquals(expected, nums);
    }

    @Test
    void Case1() {
        doTest(new char[]{'a','a','b','b','c','c','c'}, new char[]{'a', '2', 'b', '2', 'c', '3', 'c'});
    }
    @Test
    void Case2() {
        doTest(new char[]{'a'}, new char[]{'a'});
    }
    @Test
    void Case3() {
        doTest(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}, new char[]{'a', 'b', '1', '2','b','b','b','b','b','b','b','b','b'});
    }
}
