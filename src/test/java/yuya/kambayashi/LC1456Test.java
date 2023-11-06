package yuya.kambayashi;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LC1456Test {
    void doTest(String s, int k, int expected) {

        var actual = new LC1456().maxVowels(s, k);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void Case1() {
        doTest("abciiidef", 3, 3);
    }
    @Test
    void Case2() {
        doTest("aeiou", 2, 2);
    }
    @Test
    void Case3() {
        doTest("leetcode", 3,   2);
    }
}

