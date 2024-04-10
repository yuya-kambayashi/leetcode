package yuya.kambayashi;

import java.util.*;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class LCWC391B {

    public String getSmallestString(String s, int k) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (k == 0) {
                sb.append(c);
                continue;
            }

            if (c == 'a') {
                sb.append(c);
                continue;
            }

            int dist = c - 'a';
            if (dist > 13) {
                dist = 26 - dist;
            }

            if (dist <= k) {
                sb.append('a');
                k -= dist;

            } else if (dist > k) {
                char n = (char) (c - k);
                sb.append(n);
                k = 0;

            }
        }

        return sb.toString();
    }

    // @Test
    void Case1() {

        String s = "zbbz";
        int k = 3;
        var expected = "aaaz";

        var actual = getSmallestString(s, k);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void Case2() {

        String s = "xaxcd";
        int k = 4;
        var expected = "aawcd";

        var actual = getSmallestString(s, k);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void Case3() {

        String s = "lol";
        int k = 0;
        var expected = "lol";

        var actual = getSmallestString(s, k);

        assertThat(actual).isEqualTo(expected);
    }

}
