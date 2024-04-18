/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yuya.kambayashi;

import java.util.*;
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
public class ALDS1_13A {

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
        int[] rows = new int[n];
        int[] cols = new int[n];
        for (int i = 0; i < n; i++) {
            rows[i] = sc.nextInt();
            cols[i] = sc.nextInt();
        }

        // 上の行から列の組み合わせを順列にする
        int[] seeds = new int[8];
        for (int i = 0; i < 8; i++) {
            seeds[i] = i;
        }
        var perms = permutation(seeds);

        for (var perm : perms) {

            // 仮想の配列を作ってみる
            char[][] grid = new char[8][8];
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    grid[i][j] = '.';
                }
            }

            for (int i = 0; i < n; i++) {
                grid[rows[i]][cols[i]] = 'Q';
            }
            for (int i = 0; i < 8; i++) {

                grid[i][perm.get(i)] = 'Q';
            }

            // チェック
            // 1行にQが一つか
            boolean ok = true;
            for (int r = 0; r < 8; r++) {

                int q = 0;

                for (int c = 0; c < 8; c++) {

                    if (grid[r][c] == 'Q') {
                        q++;
                    }
                }
                if (q != 1) {
                    ok = false;
                    break;
                }
            }

            // 1列にQが一つか
            for (int c = 0; c < 8; c++) {

                int q = 0;

                for (int r = 0; r < 8; r++) {

                    if (grid[r][c] == 'Q') {
                        q++;
                    }
                }
                if (q != 1) {
                    ok = false;
                    break;
                }
            }
            if (!ok) {
                continue;
            }
            //　斜めのチェック

            for (int i = 0; i < 8; i++) {
                for (int j = i + 1; j < 8; j++) {

                    if (Math.abs(i - j) == Math.abs(perm.get(i) - perm.get(j))) {
                        ok = false;
                        break;
                    }
                }
            }

            if (!ok) {
                continue;
            }
            System.out.println(String.valueOf(grid[0]));
            System.out.println(String.valueOf(grid[1]));
            System.out.println(String.valueOf(grid[2]));
            System.out.println(String.valueOf(grid[3]));
            System.out.println(String.valueOf(grid[4]));
            System.out.println(String.valueOf(grid[5]));
            System.out.println(String.valueOf(grid[6]));
            System.out.println(String.valueOf(grid[7]));
            return;
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

    // @Test
    public void Case1() {

        in.inputln("2");
        in.inputln("2 2");
        in.inputln("5 3");
        // var expected = "......Q.";
        // expected = "Q.......";

        ALDS1_13A.main(null);
        //var actual = out.readLine();
        assertThat(out.readLine()).isEqualTo("......Q.");
        assertThat(out.readLine()).isEqualTo("Q.......");
        assertThat(out.readLine()).isEqualTo("..Q.....");
        assertThat(out.readLine()).isEqualTo(".......Q");
        assertThat(out.readLine()).isEqualTo(".....Q..");
        assertThat(out.readLine()).isEqualTo("...Q....");
        assertThat(out.readLine()).isEqualTo(".Q......");
        assertThat(out.readLine()).isEqualTo("....Q...");
    }

    //@Test
    public void Case2() {

        in.inputln("2");
        in.inputln("2 4");
        in.inputln("6 3");
        var expected = "";

        ALDS1_13A.main(null);
        assertThat(out.readLine()).isEqualTo(".......Q");
        assertThat(out.readLine()).isEqualTo(".Q......");
        assertThat(out.readLine()).isEqualTo("....Q...");
        assertThat(out.readLine()).isEqualTo("..Q.....");
        assertThat(out.readLine()).isEqualTo("Q.......");
        assertThat(out.readLine()).isEqualTo("......Q.");
        assertThat(out.readLine()).isEqualTo("...Q....");
        assertThat(out.readLine()).isEqualTo(".....Q..");
    }

    @Test
    public void Case3() {

        in.inputln("2");
        in.inputln("4 4");
        in.inputln("6 7");
        var expected = "";

        ALDS1_13A.main(null);
        assertThat(out.readLine()).isEqualTo("..Q.....");
        assertThat(out.readLine()).isEqualTo(".....Q..");
        assertThat(out.readLine()).isEqualTo(".Q......");
        assertThat(out.readLine()).isEqualTo("......Q.");
        assertThat(out.readLine()).isEqualTo("....Q...");
        assertThat(out.readLine()).isEqualTo("Q.......");
        assertThat(out.readLine()).isEqualTo(".......Q");
        assertThat(out.readLine()).isEqualTo("...Q....");
    }
}

//import java.util.*;
//public class Main {
