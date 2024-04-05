package yuya.kambayashi;

import java.util.*;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class LC1614 {

    public int maxDepth(String s) {

        int cnt = 0;
        int max = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                cnt++;
            } else if (c == ')') {
                cnt--;
            }
            max = Math.max(max, cnt);
        }

        return max;
    }

    @Test
    void Case1() {
        String s = "(1+(2*3)+((8)/4))+1";
        var expected = 3;
        var actual = maxDepth(s);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void Case2() {
        String s = "(1)+((2))+((( 3 )))";
        var expected = 3;
        var actual = maxDepth(s);
        assertThat(actual).isEqualTo(expected);
    }

}
