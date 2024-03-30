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
public class ABC347B {
//import java.util.*;
//public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final String s = sc.next();

        Set<String> set = new HashSet();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length() + 1; j++) {
                String ss = s.substring(i, j);
                set.add(ss);
            }
        }

        System.out.println(set.size());
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

        in.inputln("yay");

        ABC347B.main(null);

        var actual = out.readLine();

        var expected = "5";

        assertThat(actual).isEqualTo(expected);
    }

    //@Disabled
    @Test
    public void Case2() {

        in.inputln("aababc");

        ABC347B.main(null);

        var actual = out.readLine();

        var expected = "17";

        assertThat(actual).isEqualTo(expected);
    }

    // @Disabled
    @Test
    public void Case3() {

        in.inputln("abracadabra");

        ABC347B.main(null);

        var actual = out.readLine();

        var expected = "54";

        assertThat(actual).isEqualTo(expected);
    }
}

//import java.util.*;
//public class Main {
