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
public class ABC192C {

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

        int n = sc.nextInt();
        final int k = sc.nextInt();

        int cnt = 0;
        while (cnt < k) {
            if (n < 10) {
                System.out.println(0);

                return;
            }

            String t = String.valueOf(n);
            Integer[] nn = new Integer[t.length()];
            int i = 0;
            for (char c : t.toCharArray()) {
                nn[i] = c - '0';
                i++;
            }

            Arrays.sort(nn, Collections.reverseOrder());
            StringBuilder sb = new StringBuilder();
            for (var r : nn) {
                sb.append(r);
            }
            int g1 = Integer.parseInt(sb.toString());

            Arrays.sort(nn);
            sb.setLength(0);
            for (var r : nn) {
                sb.append(r);
            }
            int g2 = Integer.parseInt(sb.toString());

            n = g1 - g2;
            cnt++;
        }

        System.out.println(n);
    }
//}

    @Test
    public void Case1() {

        String input = """
                       314 2
                    """;

        String expected = """
                          693
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC192C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       1000000000 100
                    """;

        String expected = """
                          0
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC192C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                       6174 100000
                    """;

        String expected = """
                          6174
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC192C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
