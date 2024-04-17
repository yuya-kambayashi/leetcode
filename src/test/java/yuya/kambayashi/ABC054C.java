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
public class ABC054C {

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
        final int m = sc.nextInt();
        int[] vertices = new int[n * 2];
        int[] edges = new int[n * 2];
        for (int i = 0; i < n; i++) {
            vertices[i] = sc.nextInt();
            edges[i] = sc.nextInt();
        }
        for (int i = n; i < 2 * n; i++) {
            vertices[i] = edges[i - n];
            edges[i] = vertices[i - n];
        }

        int[] seeds = new int[n];
        for (int i = 0; i < n; i++) {
            seeds[i] = i + 1;
        }
        var perms = permutation(seeds);
        int ans = 0;
        // 頂点の順列を生成し、入力データが適合するかをチェックする
        for (var perm : perms) {

            if (perm.get(0).intValue() != 1) {
                continue;
            }

            boolean ok = true;

            List<Integer> next = new ArrayList<>();
            for (int i = 0; i < perm.size(); i++) {

                int t = perm.get(i);

                if (i == 0) {
                    for (int j = 0; j < vertices.length; j++) {
                        if (vertices[j] == t) {
                            next.add(edges[j]);
                        }
                    }
                } else {
                    // nextにいるかチェック
                    if (next.contains(t)) {
                        next.clear();
                        for (int j = 0; j < vertices.length; j++) {
                            if (vertices[j] == t) {
                                next.add(edges[j]);
                            }
                        }

                    } else {
                        ok = false;
                        break;
                    }
                }
                if (!ok) {
                    break;
                }
            }
            if (ok) {
                ans++;
            }

        }
        System.out.println(ans);

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

        in.inputln("3 3");
        in.inputln("1 2");
        in.inputln("1 3");
        in.inputln("2 3");
        var expected = "2";

        ABC054C.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void Case2() {
        in.inputln("7 7");
        in.inputln("1 3");
        in.inputln("2 7");
        in.inputln("3 4");
        in.inputln("4 5");
        in.inputln("4 6");
        in.inputln("5 6");
        in.inputln("6 7");
        var expected = "1";

        ABC054C.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

    // @Test
    public void Case3() {

        in.inputln("");
        var expected = "";

        ABC054C.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }
}

//import java.util.*;
//public class Main {
