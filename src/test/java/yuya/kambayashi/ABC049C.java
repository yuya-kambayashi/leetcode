/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yuya.kambayashi;

import java.util.*;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

/**
 *
 * @author kamba
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC049C {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final String s = sc.next();

        String ret = s;
        ret = ret.replaceAll("eraser", "");
        ret = ret.replaceAll("erase", "");
        ret = ret.replaceAll("dreamer", "");
        ret = ret.replaceAll("dream", "");

        String ans = "";
        if (ret.isEmpty()) {
            ans = "YES";
        } else {
            ans = "NO";
        }

        System.out.println(ans);
    }

    private StandardInputSnatcher in = new StandardInputSnatcher();
    private StandardOutputSnatcher out = new StandardOutputSnatcher();

    @BeforeAll
    public void beforeAll() {
        System.setIn(in);
        System.setOut(out);
    }

    @AfterAll
    public void afterAll() {
        System.setIn(null);
        System.setOut(null);
    }

    //@Disabled
    @Test
    public void Case1() {

        in.inputln("erasedream");

        ABC049C.main(null);

        var actual = out.readLine();

        var expected = "YES";

        assertThat(actual).isEqualTo(expected);
    }

    //@Disabled
    @Test
    public void Case2() {

        in.inputln("dreameraser");

        ABC049C.main(null);

        var actual = out.readLine();

        var expected = "YES";

        assertThat(actual).isEqualTo(expected);
    }

    //@Disabled
    @Test
    public void Case3() {

        in.inputln("dreamerer");

        ABC049C.main(null);

        var actual = out.readLine();

        var expected = "NO";

        assertThat(actual).isEqualTo(expected);
    }
}

//import java.util.*;
//public class Main {
