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
public class ABC259C {

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

        final String s = sc.next();
        final String t = sc.next();

        List<Pair> ts = compess(s);
        List<Pair> tt = compess(t);

        String ret = "Yes";
        if (ts.size() != tt.size()) {
            System.out.println("No");
            return;
        }

        for (int i = 0; i < ts.size(); i++) {
            var ps = ts.get(i);
            var pt = tt.get(i);

            if (ps.c != pt.c) {
                System.out.println("No");
                return;
            }
            if (ps.cnt == 1 && ps.cnt != pt.cnt) {
                System.out.println("No");
                return;
            }
            if (ps.cnt > pt.cnt) {

                System.out.println("No");
                return;
            }

        }

        System.out.println("Yes");

    }

    static List<Pair> compess(String s) {
        List<Pair> ll = new ArrayList<>();

        char t = s.charAt(0);
        int cnt = 1;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);

            if (i < s.length() - 1) {

                if (t == c) {
                    cnt++;
                } else {
                    ll.add(new Pair(t, cnt));
                    t = c;
                    cnt = 1;
                }
            } else {
                if (t == c) {
                    cnt++;
                    ll.add(new Pair(t, cnt));

                } else {
                    ll.add(new Pair(t, cnt));
                    ll.add(new Pair(c, 1));

                }
            }
        }
        return ll;
    }

    static class Pair {

        char c;
        int cnt;

        Pair(char c, int cnt) {
            this.c = c;
            this.cnt = cnt;
        }
    }
    //}

    @Test
    public void Case1() {

        String input = """
                       abbaac
abbbbaaac
                    """;

        String expected = """
                          Yes
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC259C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       xyzz
xyyzz
                    """;

        String expected = """
                          No
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC259C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       aab
                       aaba
                    """;

        String expected = """
                          No
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC259C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case4() {

        String input = """
                       aaa
                       aaa
                    """;

        String expected = """
                          Yes
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC259C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
