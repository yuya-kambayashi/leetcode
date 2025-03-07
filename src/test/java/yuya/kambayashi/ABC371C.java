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
public class ABC371C {

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
        int mg = sc.nextInt();
        boolean[][] gg = new boolean[n][n];
        for (int i = 0; i < mg; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            gg[u][v] = true;
        }
        int mh = sc.nextInt();
        boolean[][] hh = new boolean[n][n];
        for (int i = 0; i < mh; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            hh[u][v] = true;
        }
        int[][] aa = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < j) {
                    int t = sc.nextInt();
                    aa[i][j] = t;
                }
            }
        }
        long max = Integer.MAX_VALUE;

        int[] seeds = new int[n];
        for (int i = 0; i < n; i++) {
            seeds[i] = i;
        }
        var perms = permutation(seeds);
        for (var perm : perms) {
            long sum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {

                    int ii = perm.get(i);
                    int jj = perm.get(j);
                    if (ii > jj) {
                        jj = ii;
                        ii = perm.get(j);
                    }

                    if (gg[i][j] != hh[ii][jj]) {
                        sum += aa[ii][jj];
                    }
                }
            }
            max = Math.min(max, sum);

        }

        System.out.println(max);
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

    @Test
    public void Case1() {

        String input = """
                       5
                       4
                       1 2
                       2 3
                       3 4
                       4 5
                       4
                       1 2
                       1 3
                       1 4
                       1 5
                       3 1 4 1
                       5 9 2
                       6 5
                       3
                    """;

        String expected = """
                          9
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC371C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       5
                       3
                       1 2
                       2 3
                       3 4
                       4
                       1 2
                       2 3
                       3 4
                       4 5
                       9 1 1 1
                       1 1 1
                       1 1
                       9
                    """;

        String expected = """
                          3
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC371C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       5
                       3
                       1 2
                       2 3
                       3 4
                       4
                       1 2
                       2 3
                       3 4
                       4 5
                       5 4 4 4
                       4 4 4
                       4 4
                       5
                    """;

        String expected = """
                          5
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC371C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case4() {

        String input = """
                       2
                       0
                       0
                       371
                    """;

        String expected = """
                          0
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC371C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
    // @Test

    public void Case5() {

        String input = """
                       8
                       13
                       1 8
                       5 7
                       4 6
                       1 5
                       7 8
                       1 6
                       1 2
                       5 8
                       2 6
                       5 6
                       6 7
                       3 7
                       4 8
                       15
                       3 5
                       1 7
                       4 6
                       3 8
                       7 8
                       1 2
                       5 6
                       1 6
                       1 5
                       1 4
                       2 8
                       2 6
                       2 4
                       4 7
                       1 3
                       7483 1694 5868 3296 9723 5299 4326
                       5195 4088 5871 1384 2491 6562
                       1149 6326 2996 9845 7557
                       4041 7720 1554 5060
                       8329 8541 3530
                       4652 3874
                       3748
                    """;

        String expected = """
                          21214
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC371C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
