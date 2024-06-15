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
public class ABC358B {

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
        final int a = sc.nextInt();
        int[] tt = new int[n];
        for (int i = 0; i < n; i++) {
            tt[i] = sc.nextInt();
        }

        long[] bb = new long[n];
        bb[0] = tt[0] + a;
        for (int i = 1; i < n; i++) {

            long before = bb[i - 1];
            if (before < tt[i]) {
                bb[i] = tt[i] + a;
            } else {
                bb[i] = before + a;
            }
        }

        for (long b : bb) {

            System.out.println(b);
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                       3 4
                       0 2 10
                    """;

        String expected = """
                          4
                          8
                          14
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC358B.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       3 3
                       1 4 7
                    """;

        String expected = """
                          4
                          7
                          10
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC358B.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       10 50000
                       120190 165111 196897 456895 540000 552614 561627 743796 757613 991216
                    """;

        String expected = """
                          170190
                          220190
                          270190
                          506895
                          590000
                          640000
                          690000
                          793796
                          843796
                          1041216
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC358B.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }
}
