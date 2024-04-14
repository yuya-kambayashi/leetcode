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
public class ABC349C {

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
//import java.util.*;
//import java.util.stream.Collectors;
//public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next().toUpperCase();
        final String t = sc.next();

        char t1 = t.charAt(0);
        char t2 = t.charAt(1);
        char t3 = t.charAt(2);

        int i1 = s.indexOf(t1);
        if (i1 == -1) {
            System.out.println("No");
            return;
        }
        s = s.substring(i1 + 1);

        int i2 = s.indexOf(t2);
        if (i2 == -1) {
            System.out.println("No");
            return;
        }
        s = s.substring(i2 + 1);

        if (t3 == 'X') {
            System.out.println("Yes");
            return;
        } else {
            int i3 = s.indexOf(t3);
            if (i3 == -1) {
                System.out.println("No");
                return;
            } else {
                System.out.println("Yes");

            }
        }

    }

//}
    @Test
    public void Case1() {

        in.inputln("narita");
        in.inputln("NRT");
        var expected = "Yes";

        ABC349C.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

    @Test

    public void Case2() {

        in.inputln("losangeles");
        in.inputln("LAX");
        var expected = "Yes";

        ABC349C.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void Case3() {

        in.inputln("snuke");
        in.inputln("RNG");
        var expected = "No";

        ABC349C.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }
}

//import java.util.*;
//public class Main {
