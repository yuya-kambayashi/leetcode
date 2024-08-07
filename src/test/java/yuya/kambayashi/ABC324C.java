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
public class ABC324C {

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
        String t = sc.next();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = sc.next();

            boolean ok = false;
            if (isEqual(s, t)) {
                ok = true;
            } else if (isEqualAsAdd(s, t)) {
                ok = true;
            } else if (isEqualAsAdd(t, s)) {
                ok = true;
            } else if (isEqualAsDiff(t, s)) {
                ok = true;
            }

            if (ok) {
                ans.add(i + 1);
            }
        }
        System.out.println(ans.size());
        for (var a : ans) {
            System.out.print(a);
            System.out.print(" ");
        }

    }

    static boolean isEqual(String s, String t) {
        return s.equals(t);
    }

    static boolean isEqualAsAdd(String s, String t) {
        if (s.length() + 1 != t.length()) {
            return false;
        }

        int si = 0, ti = 0;
        boolean hasDiff = false;

        while (true) {

            if (si == s.length() || ti == t.length()) {
                break;
            }

            char sc = s.charAt(si);
            char tc = t.charAt(ti);

            if (sc != tc) {
                if (hasDiff) {
                    return false;
                } else {
                    si--;
                    hasDiff = true;
                }
            }

            si++;
            ti++;
        }
        return true;
    }

    static boolean isEqualAsDiff(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int si = 0, ti = 0;
        int diff = 0;

        while (true) {

            if (si == s.length() || ti == t.length()) {
                break;
            }

            char sc = s.charAt(si);
            char tc = t.charAt(ti);

            if (sc != tc) {
                diff++;
            }

            si++;
            ti++;
        }
        return diff == 1;
    }
//}

    @Test
    public void Case1() {

        String input = """
                       5 ababc
ababc
babc
abacbc
abdbc
abbac
                    """;

        String expected = """
                          4
1 2 3 4
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC324C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       1 aoki
takahashi
                    """;

        String expected = """
                          0
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC324C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       9 atcoder
atoder
atcode
athqcoder
atcoder
tacoder
jttcoder
atoder
atceoder
atcoer
                    """;

        String expected = """
                          6
1 2 4 7 8 9
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC324C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case4() {

        String input = """
                       1 abc
                       bcd
                    """;

        String expected = """
                          1
                          1                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC324C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
