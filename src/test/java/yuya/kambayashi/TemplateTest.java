package yuya.kambayashi;

import java.util.*;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class TemplateTest {

    public boolean XXX() {

        return true;
    }

    @Test
    void Case1() {

        //String s =
        //int n = 
        var expected = true;

        var actual = XXX();

        assertThat(actual).isEqualTo(expected);
    }

}
