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
public class ABC323C {

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
        int[] aa = new int[m];
        for (int i = 0; i < m; i++) {
            aa[i] = sc.nextInt();
        }
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) {
            ss[i] = sc.next();
        }

        List<Problem> problems = new ArrayList<>();
        for (int i = 0; i < m; i++) {

            StringBuilder sb = new StringBuilder();
            for (var s : ss) {
                sb.append(s.charAt(i));
            }

            problems.add(new Problem(aa[i], sb.toString()));
        }

        int[] points = new int[n];
        for (int i = 0; i < n; i++) {
            for (var p : problems) {
                if (p.s.charAt(i) == 'o') {
                    points[i] += p.point;
                }
            }
            // ボーナス点
            points[i] += i + 1;
        }
        Collections.sort(problems, Comparator.comparingInt(Problem::getPoint));

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            // ほかの人の最高点を取得
            int max = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                max = Math.max(max, points[j]);
            }
            if (points[i] > max) {
                ans[i] = 0;
                continue;
            }

            int t = points[i];

            for (int j = problems.size() - 1; j >= 0; j--) {
                var problem = problems.get(j);
                // 正答済みなら対象外
                if (problem.s.charAt(i) == 'o') {
                    continue;
                }
                t += problem.point;
                ans[i]++;
                if (t > max) {
                    break;
                }
            }
        }
        for (var a : ans) {
            System.out.println(a);
        }
    }

    static class Problem {

        int point;
        String s;

        Problem(int point, String s) {
            this.point = point;
            this.s = s;
        }

        int getPoint() {
            return point;
        }
    }

//}
    @Test
    public void Case1() {

        String input = """
                       3 4
                       1000 500 700 2000
                       xxxo
                       ooxx
                       oxox
                    """;

        String expected = """
                          0
                          1
                          1
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC323C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       5 5
                       1000 1500 2000 2000 2500
                       xxxxx
                       oxxxx
                       xxxxx
                       oxxxx
                       oxxxx
                    """;

        String expected = """
                          1
                          1
                          1
                          1
                          0
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC323C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       7 8
                       500 500 500 500 500 500 500 500
                       xxxxxxxx
                       oxxxxxxx
                       ooxxxxxx
                       oooxxxxx
                       ooooxxxx
                       oooooxxx
                       ooooooxx
                    """;

        String expected = """
                          7
                          6
                          5
                          4
                          3
                          2
                          0
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC323C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                       2 1
                       500
                       x
                       x
                    """;

        String expected = """
                          1
                          1
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC323C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //   @Test
    public void Case5() {

        String input = """
                       2 2
                       500 2500
                       xo
                       xx
                    """;

        String expected = """
                          0
                          1
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC323C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
