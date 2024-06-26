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
public class ABC299C {

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

        final int n = sc.nextInt();
        final String s = sc.next();

        int max = -1;
        int level = 0;
        boolean start = false;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '-') {
                level = 0;
                start = true;
            } else if (c == 'o' && start) {
                level++;
                max = Math.max(max, level);
            }
        }
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String t = sb.toString();

        level = 0;
        start = false;
        for (int i = 0; i < n; i++) {
            char c = t.charAt(i);
            if (c == '-') {
                level = 0;
                start = true;
            } else if (c == 'o' && start) {
                level++;
                max = Math.max(max, level);
            }
        }

        System.out.println(max);
    }
//}

    @Test
    public void Case1() {

        String input = """
                       10
o-oooo---o
                    """;

        String expected = """
                          4
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC299C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       1
-
                    """;

        String expected = """
                          -1
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC299C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       30
-o-o-oooo-oo-o-ooooooo--oooo-o
                    """;

        String expected = """
                          7
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC299C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
