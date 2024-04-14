package yuya.kambayashi;

import java.util.*;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class LC100270 {

    public int scoreOfString(String s) {

        int ans = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int t = Math.abs(s.charAt(i) - s.charAt(i + 1));
            ans += t;
        }

        return ans;
    }

    @Test
    void Case1() {

        String s = "hello";
        var expected = 13;

        var actual = scoreOfString(s);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void Case2() {

        String s = "zaz";
        var expected = 50;

        var actual = scoreOfString(s);

        assertThat(actual).isEqualTo(expected);
    }

}
