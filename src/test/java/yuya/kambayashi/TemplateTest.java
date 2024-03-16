package yuya.kambayashi;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TemplateTest {
    
    public String minimizeStringValue(String s) {
        
      
        return "abs";
    }

    @Test
    void Case1() {
        
        String s = "???";
        
        var actual = minimizeStringValue(s);
        
        var expected = "abs";
        
        assertThat(actual).isEqualTo(expected);
    }

    
}
