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
public class ABC338C {

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

        int[] qq = new int[n];
        int[] aa = new int[n];
        int[] bb = new int[n];

        for (int i = 0; i < n; i++) {
            qq[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            aa[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            bb[i] = sc.nextInt();
        }

        // 料理Aを0～maxまで作ってみて、その時にbがどれだけ作れるかを考える
        int cntA = 0;
        int max = 0;
        while (true) {

            // 残ったqqでbを何人前作れるか?
            int cntB = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (bb[i] != 0) {
                    cntB = Math.min(cntB, qq[i] / bb[i]);
                }
            }

            max = Math.max(max, cntA + cntB);

            // 一人分減らす
            boolean fin = false;
            for (int i = 0; i < n; i++) {
                qq[i] -= aa[i];

                if (qq[i] < 0) {
                    fin = true;
                    break;
                }
            }
            if (fin) {
                break;
            }
            cntA++;

        }
        System.out.println(max);

    }

//}
    @Test
    public void Case1() {

        String input = """
                       2
800 300
100 100
200 10
                    """;

        String expected = """
                          5
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC338C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       2
800 300
100 0
0 10
                    """;

        String expected = """
                          38
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC338C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       2
800 300
801 300
800 301
                    """;

        String expected = """
                          0
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC338C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                       10
1000000 1000000 1000000 1000000 1000000 1000000 1000000 1000000 1000000 1000000
0 1 2 3 4 5 6 7 8 9
9 8 7 6 5 4 3 2 1 0
                    """;

        String expected = """
                          222222
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC338C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
