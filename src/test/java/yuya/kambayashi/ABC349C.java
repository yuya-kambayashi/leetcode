/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yuya.kambayashi;

import java.util.*;
import java.util.stream.Stream;
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
//import java.math.*;
//import java.util.*;
//import java.util.stream.*;
//public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next().toUpperCase();
        final String t = sc.next();

        if (t.charAt(2) == 'X') {

            List<Integer> i0 = new ArrayList<>();
            List<Integer> i1 = new ArrayList<>();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == t.charAt(0)) {
                    i0.add(i);
                }
                if (c == t.charAt(1)) {
                    i1.add(i);
                }
            }
            if (i0.isEmpty() || i1.isEmpty()) {
                System.out.println("No");
            } else {

                int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

                for (var i : i0) {
                    min = Math.min(min, i);
                }
                for (var i : i1) {
                    max = Math.max(max, i);
                }

                if (min < max) {
                    System.out.println("Yes");

                } else {
                    System.out.println("No");
                }
            }
        } else {
            List<Integer> i1 = new ArrayList<>();
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == t.charAt(0)) {
                    min = Math.min(min, i);
                }
                if (c == t.charAt(1)) {
                    i1.add(i);
                }
                if (c == t.charAt(2)) {
                    max = Math.max(max, i);
                }
            }
            if (min == Integer.MAX_VALUE || i1.isEmpty() || max == Integer.MIN_VALUE) {
                System.out.println("No");
            } else {

                for (var i : i1) {
                    if (min < i && i < max) {
                        System.out.println("Yes");
                        return;
                    }
                }
                System.out.println("No");
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
