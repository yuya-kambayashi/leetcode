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
public class ABC366B {

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
        String[] ss = new String[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            ss[i] = sc.next();
            max = Math.max(max, ss[i].length());
        }

        char[][] aa = new char[max][n];
        for (int i = 0; i < max; i++) {
            Arrays.fill(aa[i], '*');
        }
        //Arrays.sort(ss, Collections.reverseOrder());
        int index = 0;
        for (int i = ss.length - 1; i >= 0; i--, index++) {
            String s = ss[i];
            for (int j = 0; j < s.length(); j++) {
                aa[j][index] = s.charAt(j);
            }
        }
        String[] ans = new String[max];
        for (int i = 0; i < max; i++) {
            String s = String.valueOf(aa[i]);

            while (s.charAt(s.length() - 1) == '*') {
                s = s.substring(0, s.length() - 1);
            }
            ans[i] = s;
        }

        for (var a : ans) {
            System.out.println(a);
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                       3
                       abc
                       de
                       fghi
                    """;

        String expected = """
                          fda
                          geb
                          h*c
                          i
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC366B.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       3
                       atcoder
                       beginner
                       contest
                    """;

        String expected = """
                          cba
                          oet
                          ngc
                          tio
                          end
                          sne
                          ter
                          *r
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC366B.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       2
                       b
                       aa
                    """;

        String expected = """
                          ab
                          a                           
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC366B.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                       3
                       aa
                       b
                       aa
                    """;

        String expected = """
                          aba
                          a*a                            
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC366B.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
