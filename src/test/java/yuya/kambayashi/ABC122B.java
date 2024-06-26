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
public class ABC122B {
//import java.util.*;
//public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final String s = sc.next();

        int len = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (isACGT(c)) {
                len++;
            } else {
                max = Math.max(max, len);
                len = 0;
            }

            if (i == s.length() - 1) {
                max = Math.max(max, len);
            }

        }
        System.out.println(max);

    }

    public static boolean isACGT(char c) {
        return c == 'A' || c == 'C' || c == 'G' || c == 'T';
    }
//}

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

        in.inputln("ATCODER");
        var expected = "3";

        ABC122B.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

    //@Disabled
    @Test
    public void Case2() {

        in.inputln("HATAGAYA");
        var expected = "5";

        ABC122B.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

    //@Disabled
    @Test
    public void Case3() {

        in.inputln("SHINJUKU");
        var expected = "0";

        ABC122B.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }
}

//import java.util.*;
//public class Main {
