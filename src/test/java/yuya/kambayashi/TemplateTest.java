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

        var actual = XXX();

        var expected = true;

        assertThat(actual).isEqualTo(expected);
    }

}
