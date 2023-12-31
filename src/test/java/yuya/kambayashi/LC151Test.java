package yuya.kambayashi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LC151Test {
    void doTest(String s, String expected) {

        var actual = new LC151().reverseWords(s);

        Assertions.assertEquals(expected, actual);
    }
    @Test
    void Case1() {
        doTest("the sky is blue", "blue is sky the");
    }
    @Test
    void Case2() {
        doTest("  hello world  ", "world hello");
    }

    @Test
    void Case3() {
        doTest("a good   example", "example good a");
    }
}
