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
public class ABC319C {

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

        //final int n = sc.nextInt();
        int n = 3;
        int[][] gg = new int[3][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                gg[i][j] = sc.nextInt();
            }
        }
        int[] seeds = new int[9];
        for (int i = 0; i < 9; i++) {
            seeds[i] = i;
        }
        var perms = permutation(seeds);
        int dis = 0;
        for (var perm : perms) {

            int[][] open = new int[n][n];
            for (int i = 0; i < 3; i++) {
                Arrays.fill(open[i], -1);
            }

            boolean dist = false;

            for (var i : perm) {
                int row = i / 3;
                int col = i % 3;
                if (disappointed(open, row, col)) {
                    dis++;
                    break;
                }
                open[row][col] = gg[row][col];
            }
        }

        System.out.println((double) (perms.size() - dis) / perms.size());
    }

    static boolean disappointed(int[][] open, int row, int col) {
        // 列
        if (col == 0) {
            if (open[row][1] != -1 && open[row][2] != -1 && open[row][1] == open[row][2]) {
                return true;
            }
        } else if (col == 1) {
            if (open[row][0] != -1 && open[row][2] != -1 && open[row][0] == open[row][2]) {
                return true;
            }
        } else if (col == 2) {
            if (open[row][0] != -1 && open[row][1] != -1 && open[row][0] == open[row][1]) {
                return true;
            }
        }

        // 行
        if (row == 0) {
            if (open[1][col] != -1 && open[2][col] != -1 && open[1][col] == open[2][col]) {
                return true;
            }
        } else if (row == 1) {
            if (open[0][col] != -1 && open[2][col] != -1 && open[0][col] == open[2][col]) {
                return true;
            }
        } else if (row == 2) {
            if (open[0][col] != -1 && open[1][col] != -1 && open[0][col] == open[1][col]) {
                return true;
            }
        }
        // 斜め
        if (row == 0 && col == 0) {
            if (open[1][1] != -1 && open[2][2] != -1 && open[1][1] == open[2][2]) {
                return true;
            }
        }
        if (row == 1 && col == 1) {
            if (open[0][0] != -1 && open[2][2] != -1 && open[0][0] == open[2][2]) {
                return true;
            }
            if (open[0][2] != -1 && open[2][0] != -1 && open[0][2] == open[2][0]) {
                return true;
            }
        }
        if (row == 2 && col == 2) {
            if (open[0][0] != -1 && open[1][1] != -1 && open[0][0] == open[1][1]) {
                return true;
            }
        }
        if (row == 0 && col == 2) {
            if (open[1][1] != -1 && open[2][0] != -1 && open[1][1] == open[2][0]) {
                return true;
            }
        }
        if (row == 2 && col == 0) {
            if (open[1][1] != -1 && open[0][2] != -1 && open[1][1] == open[0][2]) {
                return true;
            }
        }
        return false;
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
                       3 1 9
2 5 6
2 7 1
                    """;

        String expected = """
                          0.666666666666666666666666666667
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC319C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       7 7 6
8 6 8
7 7 6
                    """;

        String expected = """
                          0.004982363315696649029982363316
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC319C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       3 6 7
1 9 7
5 7 5
                    """;

        String expected = """
                          0.4
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC319C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC319C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
