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
public class ABC371D {

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
        int[] xx = new int[n];
        int[] pp = new int[n];
        TreeSet<Pair> pairs = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            xx[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            pp[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            pairs.add(new Pair(xx[i], pp[i]));
        }

        long beforeSum = 0;
        for (var pair : pairs) {
            pair.sum += beforeSum + pair.p;
            beforeSum = pair.sum;
        }

        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();

            if (l == r) {
                if (pairs.contains(new Pair(l, 0))) {
                    var lp = pairs.ceiling(new Pair(l, 0));
                    System.out.println(lp.p);
                } else {
                    System.out.println(0);
                }
            } else {

                var lp = pairs.floor(new Pair(l - 1, 0));
                var rp = pairs.floor(new Pair(r, 0));

                long ans = 0;
                if (lp == null) {
                    ans = rp.sum;
                } else if (rp == null) {
                    ans = lp.sum;
                } else {

                    ans = rp.sum - lp.sum;
                }
                System.out.println(ans);
            }
        }
    }

    static class Pair implements Comparable<Pair> {

        int x, p;
        long sum;

        public Pair(int x, int p) {
            this.x = x;
            this.p = p;
        }

        public int getX() {
            return x;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.x, o.x);
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                       4
                       1 3 5 7
                       1 2 3 4
                       4
                       1 1
                       2 6
                       0 10
                       2 2
                    """;

        String expected = """
                          1
                          5
                          10
                          0
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC371D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       7
                       -10 -5 -3 -1 0 1 4
                       2 5 6 5 2 1 7
                       8
                       -7 7
                       -1 5
                       -10 -4
                       -8 10
                       -5 0
                       -10 5
                       -8 7
                       -8 -3
                    """;

        String expected = """
                          26
                          15
                          7
                          26
                          18
                          28
                          26
                          11
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC371D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC371D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC371D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
