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
public class ABC269C {

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

        final long n = sc.nextLong();

        String s = Long.toBinaryString(n);

        char[] cc = s.toCharArray();

        List<Integer> is = new ArrayList<>();
        for (int i = 0; i < cc.length; i++) {
            if (cc[i] == '1') {
                is.add(i);
            }
        }

        List<Long> ans = new ArrayList<>();

        for (long bit = 0; bit < 1 << is.size(); bit++) {
            char[] tt = new char[cc.length];
            Arrays.fill(tt, '0');
            for (int i = 0; i < is.size(); i++) {
                if ((bit & (1 << i)) >= 1) {
                    tt[is.get(i)] = '1';
                }
            }
            String t = String.valueOf(tt);

            Long t2 = Long.parseLong(t, 2);

            ans.add(t2);
        }
        Collections.sort(ans);

        for (var a : ans) {
            System.out.println(a);
        }

    }
//}

    @Test
    public void Case1() {

        String input = """
                       11
                    """;

        String expected = """
                          0
1
2
3
8
9
10
11
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC269C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       0
                    """;

        String expected = """
                          0
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC269C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       576461302059761664
                    """;

        String expected = """
                          0
524288
549755813888
549756338176
576460752303423488
576460752303947776
576461302059237376
576461302059761664
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC269C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
