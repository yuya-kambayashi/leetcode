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
public class ABC294C {

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

        int[] aa = new int[n];
        int[] bb = new int[m];
        for (int i = 0; i < n; i++) {
            aa[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            bb[i] = sc.nextInt();
        }

        int[] cc = new int[n];
        int[] dd = new int[m];

        for (int i = 0; i < n; i++) {
            int a = aa[i];

            int left = 0, right = m;
            while (left < right) {
                int mid = (left + right) / 2;
                if (a < bb[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            cc[i] = i + left + 1;
        }
        for (int i = 0; i < m; i++) {
            int b = bb[i];

            int left = 0, right = n;
            while (left < right) {
                int mid = (left + right) / 2;
                if (b < aa[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            dd[i] = i + left + 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(cc[i]);
            if (i != n - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
        sb.setLength(0);
        for (int i = 0; i < m; i++) {
            sb.append(dd[i]);
            if (i != m - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());

    }
//}

    @Test
    public void Case1() {

        String input = """
                       4 3
                       3 14 15 92
                       6 53 58
                    """;

        String expected = """
                          1 3 4 7
                          2 5 6
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC294C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       4 4
                       1 2 3 4
                       100 200 300 400
                    """;

        String expected = """
                          1 2 3 4
                          5 6 7 8
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC294C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       8 12
                       3 4 10 15 17 18 22 30
                       5 7 11 13 14 16 19 21 23 24 27 28
                    """;

        String expected = """
                          1 2 5 9 11 12 15 20
                          3 4 6 7 8 10 13 14 16 17 18 19
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC294C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
