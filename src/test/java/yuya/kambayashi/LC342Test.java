package yuya.kambayashi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LC342Test {
    void doTest(int n, boolean expected) {

        var actual = new LC342().isPowerOfFour(n);

        Assertions.assertEquals(expected, actual);
    }
    @Test
    void Case1() {
        doTest(16, true);
    }
    @Test
    void Case2() {
        doTest(5, false);
    }
    @Test
    void Case3() {
        doTest(1, true);
    }
}