package yuya.kambayashi;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
