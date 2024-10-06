/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yuya.kambayashi;

import java.math.*;
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
public class ABC374D {

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
        final int s = sc.nextInt();
        final int t = sc.nextInt();
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();

            Point pt1 = new Point(a, b);
            Point pt2 = new Point(c, d);

            lines.add(new Line(pt1, pt2));
        }
        int[] seeds = new int[n];
        for (int i = 0; i < n; i++) {
            seeds[i] = i;
        }
        var perms = permutation(seeds);

        double min = Double.MAX_VALUE;

        for (var perm : perms) {

            for (int bit = 0; bit < 1 << n; bit++) {

                double time = 0;
                Point ptBefore = new Point(0, 0);

                for (int i = 0; i < n; i++) {
                    int index = perm.get(i);

                    Line lt = lines.get(index);
                    if ((bit & (1 << i)) > 0) {
                        lt = lt.reverse();
                    }

                    time += ptBefore.getDistance(lt.ptS) / s;
                    time += lt.length() / t;
                    ptBefore = lt.ptE;
                }
                min = Math.min(min, time);
            }
        }
        System.out.println(min);
    }

    static class Line {

        Point ptS, ptE;

        public Line(Point ptS, Point ptE) {
            this.ptS = ptS;
            this.ptE = ptE;
        }

        public double length() {
            return ptS.getDistance(ptE);
        }

        public Line reverse() {
            return new Line(ptE, ptS);
        }
    }

    static class Point {

        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public double getDistance(Point other) {
            return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
        }
    }

    private static ArrayList<ArrayList<Integer>> permutation(int[] seed) {
        ArrayList<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>();
        int[] perm = new int[seed.length];
        boolean[] used = new boolean[seed.length];
        buildPerm(seed, perm, used, 0, array);
        return array;
    }

    private static void buildPerm(int[] seed, int[] perm, boolean[] used, int index, ArrayList<ArrayList<Integer>> array) {
        if (index == seed.length) {
            procPerm(perm, array);
            return;
        }

        for (int i = 0; i < seed.length; i++) {
            if (used[i]) {
                continue;
            }
            perm[index] = seed[i];
            used[i] = true;
            buildPerm(seed, perm, used, index + 1, array);
            used[i] = false;
        }
    }

    private static void procPerm(int[] perm, ArrayList<ArrayList<Integer>> array) {
        ArrayList<Integer> k = new ArrayList<>(perm.length);
        for (int i = 0; i < perm.length; i++) {
            k.add(perm[i]);
        }
        array.add(k);
    }
//}

    //@Test
    public void Case0() {

        String input = """
                       2 1 1
                       1 3 2 1
                       0 2 0 0
                       3 0 2 0
                    """;

        String expected = """
                          6.44317475868633722080
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC374D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case1() {

        String input = """
                       3 2 1
                       1 3 2 1
                       0 2 0 0
                       3 0 2 0
                    """;

        String expected = """
                          6.44317475868633722080
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC374D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       2 1 1
                       0 0 10 10
                       0 2 2 0
                    """;

        String expected = """
                          20.97056274847714058517
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC374D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       6 3 2
                       -1000 -1000 1000 1000
                       1000 -1000 -1000 1000
                       -1000 -1000 1000 1000
                       1000 -1000 -1000 1000
                       1000 1000 -1000 -1000
                       -1000 1000 1000 -1000
                    """;

        String expected = """
                          9623.35256169626864153344
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC374D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case4() {

        String input = """
                       6 10 8
                       1000 1000 -1000 -1000
                       1000 -1000 -1000 -1000
                       -1000 1000 1000 1000
                       -1000 1000 -1000 -1000
                       1000 1000 1000 -1000
                       1000 -1000 -1000 1000
                    """;

        String expected = """
                          2048.52813742385702910909
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC374D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
