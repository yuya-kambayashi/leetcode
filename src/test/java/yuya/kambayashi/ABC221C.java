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
public class ABC221C {

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

        List<Integer> nn = new ArrayList<>();
        String t = String.valueOf(n);
        for (int i = 0; i < t.length(); i++) {
            nn.add(t.charAt(i) - '0');
        }
        int m = t.length();

        int max = 0;

        for (long bit = 0; bit < 1 << m; bit++) {
            List<Integer> in = new ArrayList<>();
            List<Integer> out = new ArrayList<>();
            for (int i = 0; i < m; i++) {

                if ((bit & (1 << i)) >= 1) {
                    in.add(nn.get(i));
                } else {
                    out.add(nn.get(i));
                }
            }

            if (in.isEmpty() || out.isEmpty()) {
                continue;
            }

            Collections.sort(in);
            Collections.sort(out);

            StringBuilder sbi = new StringBuilder();
            StringBuilder sbo = new StringBuilder();
            for (var k : in) {
                sbi.append(k);
            }
            for (var k : out) {
                sbo.append(k);
            }
            sbi.reverse();
            sbo.reverse();

            max = Math.max(max, Integer.parseInt(sbi.toString()) * Integer.parseInt(sbo.toString()));
        }

        System.out.println(max);
    }
//}

    @Test
    public void Case1() {

        String input = """
                       123
                    """;

        String expected = """
                          63
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC221C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       1010
                    """;

        String expected = """
                          100
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC221C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       998244353
                    """;

        String expected = """
                          939337176
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC221C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
