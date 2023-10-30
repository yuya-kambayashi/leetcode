package yuya.kambayashi;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LC392Test {
    void doTest(String s, String t, boolean expected) {

        var actual = new LC392().isSubsequence(s, t);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void Case1() {
        doTest("abc", "ahbgdc", true);
    }
    @Test
    void Case2() {
        doTest("axc", "ahbgdc", false);
    }
}
