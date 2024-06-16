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
public class ABC115D {

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
        final long x = sc.nextLong();

        long[] la = new long[n + 1];
        long[] sa = new long[n + 1];
        la[0] = 1;
        sa[0] = 1;
        for (int i = 1; i <= n; i++) {
            la[i] = la[i - 1] * 2 + 3;
            sa[i] = sa[i - 1] * 2 + 1;
        }

        System.out.println(rec(n, x, la, sa));
    }

    public static long rec(int n, long x, long[] la, long[] sa) {

        if (n == 0) {
            return 1;
        }

        if (x == 1) {
            return 0;
        } else if (x <= la[n - 1] + 1) {
            return rec(n - 1, x - 1, la, sa);
        } else if (x == la[n - 1] + 2) {
            return sa[n - 1] + 1;
        } else if (x <= la[n - 1] * 2 + 2) {
            return rec(n - 1, x - la[n - 1] - 2, la, sa) + sa[n - 1] + 1;
        } else {
            return sa[n - 1] * 2 + 1;
        }

    }

//}
    @Test
    public void Case1() {

        String input = """
                       2 7
                    """;

        String expected = """
                          4
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC115D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       1 1
                    """;

        String expected = """
                          0
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC115D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       50 4321098765432109
                    """;

        String expected = """
                          2160549382716056
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC115D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}

//import java.util.*;
//public class Main {

