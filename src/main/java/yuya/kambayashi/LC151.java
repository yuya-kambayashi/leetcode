package yuya.kambayashi;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LC151 {
    public String reverseWords(String s) {

        s = s.trim();

        List<String> words = Arrays.asList(s.split("\\s+"));

        Collections.reverse(words);
        return String.join(" ", words );

    }
}
