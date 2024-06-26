/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yuya.kambayashi;

import java.awt.geom.Point2D;
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
public class ABC304C {

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
        final int d = sc.nextInt();
        int[] xx = new int[n];
        int[] yy = new int[n];
        for (int i = 0; i < n; i++) {
            xx[i] = sc.nextInt();
            yy[i] = sc.nextInt();
        }

        boolean[] bb = new boolean[n];

        int d2 = d * d;

        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);

        while (!q.isEmpty()) {
            int t = q.poll();
            if (bb[t]) {
                continue;
            }
            bb[t] = true;

            for (int i = 0; i < n; i++) {
                if (i == t) {
                    continue;
                }
                if (bb[i]) {
                    continue;
                }

                int dist = (xx[t] - xx[i]) * (xx[t] - xx[i]) + (yy[t] - yy[i]) * (yy[t] - yy[i]);
                if (dist <= d2) {
                    q.add(i);
                }
            }
        }
        for (var b : bb) {
            String ret = "No";
            if (b) {
                ret = "Yes";
            }
            System.out.println(ret);
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                       4 5
2 -1
3 1
8 8
0 5
                    """;

        String expected = """
                          Yes
Yes
No
Yes
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC304C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       3 1
0 0
-1000 -1000
1000 1000
                    """;

        String expected = """
                          Yes
No
No
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC304C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       9 4
3 2
6 -1
1 6
6 5
-2 -3
5 3
2 -3
2 1
2 6
                    """;

        String expected = """
                          Yes
No
No
Yes
Yes
Yes
Yes
Yes
No
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC304C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
