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
public class ABC358C {

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
        final int m = sc.nextInt();
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) {
            ss[i] = sc.next();
        }

        int min = Integer.MAX_VALUE;
        for (int bit = 0; bit < 1 << n; bit++) {

            boolean[] has = new boolean[m];
            int cnt = 0;
            for (int i = 0; i < n; i++) {

                if ((bit & (1 << i)) >= 1) {
                    cnt++;

                    String s = ss[i];
                    for (int j = 0; j < s.length(); j++) {
                        char c = s.charAt(j);
                        if (c == 'o') {
                            has[j] = true;
                        }
                    }
                }
            }
            boolean allhas = true;
            for (var h : has) {
                if (!h) {
                    allhas = false;
                    break;
                }
            }
            if (!allhas) {
                continue;
            }
            min = Math.min(min, cnt);
        }

        System.out.println(min);
    }
//}

    @Test
    public void Case1() {

        String input = """
                       3 5
                       oooxx
                       xooox
                       xxooo
                    """;

        String expected = """
                          2
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC358C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       3 2
                       oo
                       ox
                       xo
                    """;

        String expected = """
                          1
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC358C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       8 6
                       xxoxxo
                       xxoxxx
                       xoxxxx
                       xxxoxx
                       xxoooo
                       xxxxox
                       xoxxox
                       oxoxxo
                    """;

        String expected = """
                          3
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC358C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }
}
