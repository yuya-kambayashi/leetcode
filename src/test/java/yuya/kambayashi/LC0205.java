package yuya.kambayashi;

import java.util.*;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class LC0205 {

    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] sa = getIsomorphic(s);
        int[] ta = getIsomorphic(t);

        for (int i = 0; i < sa.length; i++) {
            if (sa[i] != ta[i]) {
                return false;
            }
        }
        return true;
    }

    public int[] getIsomorphic(String s) {

        int[] na = new int[s.length()];

        Map<Character, Integer> map = new HashMap<>();

        int last = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                na[i] = map.get(c);
            } else {
                na[i] = last;
                map.put(c, last);
                last++;
            }
        }
        return na;

    }

    @Test
    void Case1() {

        String s = "egg";
        String t = "add";

        var actual = isIsomorphic(s, t);

        var expected = true;

        assertThat(actual).isEqualTo(expected);
    }

}
