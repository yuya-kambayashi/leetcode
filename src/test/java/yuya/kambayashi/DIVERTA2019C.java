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
public class DIVERTA2019C {

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

        final int n = sc.nextInt();
        String[] sa = new String[n];
        for (int i = 0; i < n; i++) {
            sa[i] = sc.next();
        }

        int t = 0;

        for (String s : sa) {

            for (int i = 0; i < s.length() - 1; i++) {
                String tt = s.substring(i, i + 2);

                if (tt.equals("AB")) {
                    t++;
                }
            }
        }

        int c1 = 0, c2 = 0, c3 = 0;
        for (var s : sa) {
            if (s.charAt(0) == 'B' && s.charAt(s.length() - 1) == 'A') {
                c1++;
            } else if (s.charAt(0) == 'B') {
                c2++;
            } else if (s.charAt(s.length() - 1) == 'A') {
                c3++;
            }
        }

        int ans = 0;

        if (c2 == 0 && c3 == 0) {
            ans = t + Math.max(c1 - 1, 0);
        } else {
            ans = t + c1 + Math.min(c2, c3);
        }

        System.out.println(ans);
    }

//}
    @Test
    public void Case1() {

        String input = """
                       3
                       ABCA
                       XBAZ
                       BAD
                    """;

        String expected = """
                          2
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        DIVERTA2019C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       9
                       BEWPVCRWH
                       ZZNQYIJX
                       BAVREA
                       PA
                       HJMYITEOX
                       BCJHMRMNK
                       BP
                       QVFABZ
                       PRGKSPUNA
                    """;

        String expected = """
                          4
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        DIVERTA2019C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       7
                       RABYBBE
                       JOZ
                       BMHQUVA
                       BPA
                       ISU
                       MCMABAOBHZ
                       SZMEHMA
                    """;

        String expected = """
                          4
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        DIVERTA2019C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }
}

//import java.util.*;
//public class Main {
