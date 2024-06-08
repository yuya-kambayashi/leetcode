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
public class ABC214C {

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
        int[] ss = new int[n];
        int[] tt = new int[n];
        int[] bb = new int[n];
        int mint = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ss[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            tt[i] = sc.nextInt();
            bb[i] = tt[i];
            mint = Math.min(mint, tt[i]);
        }

        // 3人
        // 1:xxx
        // 2:xxx
        // 3:oxx
        // 4:oxx
        // 5:oxx
        // 6:oxx
        // 7:xox
        // 8:xxo
        // 9:xxo
        //10:xoo
        int cnt = 0;
        while (cnt < 10) {
            cnt++;

            if ((bb[n - 1] + ss[n - 1]) < bb[0]) {
                bb[0] = bb[n - 1] + ss[n - 1];
            }

            for (int i = 1; i < n; i++) {
                if ((bb[i - 1] + ss[i - 1]) < bb[i]) {
                    bb[i] = bb[i - 1] + ss[i - 1];
                }
            }
        }

        for (var b : bb) {

            System.out.println(b);
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                       3
4 1 5
3 10 100
                    """;

        String expected = """
                          3
7
8
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC214C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       4
100 100 100 100
1 1 1 1
                    """;

        String expected = """
                          1
1
1
1
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC214C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       4
1 2 3 4
1 2 4 7
                    """;

        String expected = """
                          1
2
4
7
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC214C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    @Test
    public void Case4() {

        String input = """
                       3
1 1 1
10 5 1
                    """;

        String expected = """
                          2
3
1
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC214C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    @Test
    public void Case5() {

        String input = """
                       3
1 1 1
10 1 5
                    """;

        String expected = """
                          3
1
2
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC214C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }
}
