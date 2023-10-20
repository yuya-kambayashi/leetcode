package yuya.kambayashi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LC345Test {
    @Test
    void Case1() {

        var s = "hello";

        var actual = new LC345().reverseVowels(s);

        var expected = "holle";

        Assertions.assertEquals(expected, actual);
    }
    @Test
    void Case2() {

        var s = "leetcode";

        var actual = new LC345().reverseVowels(s);

        var expected = "leotcede";

        Assertions.assertEquals(expected, actual);
    }
    @Test
    void Case3() {

        var s = "a";

        var actual = new LC345().reverseVowels(s);

        var expected = "a";

        Assertions.assertEquals(expected, actual);
    }
    @Test
    void Case4() {

        var s = "ab";

        var actual = new LC345().reverseVowels(s);

        var expected = "ab";

        Assertions.assertEquals(expected, actual);
    }
    @Test
    void Case5() {

        var s = "aba";

        var actual = new LC345().reverseVowels(s);

        var expected = "aba";

        Assertions.assertEquals(expected, actual);
    }
    @Test
    void Case6() {

        var s = "ae";

        var actual = new LC345().reverseVowels(s);

        var expected = "ea";

        Assertions.assertEquals(expected, actual);
    }
    @Test
    void Case7() {

        var s = "aiue";

        var actual = new LC345().reverseVowels(s);

        var expected = "euia";

        Assertions.assertEquals(expected, actual);
    }
    @Test
    void Case8() {

        var s = "aibue";

        var actual = new LC345().reverseVowels(s);

        var expected = "eubia";

        Assertions.assertEquals(expected, actual);
    }
    @Test
    void Case9() {

        var s = "abiue";

        var actual = new LC345().reverseVowels(s);

        var expected = "ebuia";

        Assertions.assertEquals(expected, actual);
    }
}