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
public class ABC352D {

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
        final int k = sc.nextInt();
        int[] pp = new int[n];
        for (int i = 0; i < n; i++) {
            pp[i] = sc.nextInt();
        }

        int[] seeds = new int[n];
        for (int i = 0; i < n; i++) {
            seeds[i] = i;
        }
        var perms = permutation(seeds);

        List<List<Pair>> oks = new ArrayList<>();

        HashSet<List<Integer>> targetIndecies = new HashSet<>();
        for (var perm : perms) {

            List<Integer> targets = new ArrayList<>();
            for (int i = 0; i < perm.size(); i++) {

                // pのインデックス
                int t = perm.get(i);

                // 1～ｋまでをチェック
                if (t >= k) {
                    continue;
                }
                targets.add(i);
            }
            targetIndecies.add(targets);
        }
        for (var targetIndex : targetIndecies) {

            // チェック対象のPのリスト
            List<Pair> fileteredPP = new ArrayList<>();
            List<Integer> fileteredPPValue = new ArrayList<>();

            for (int i : targetIndex) {
                // Pの値
                int p = pp[i]; // チェック対象のＰの値を保持

                Pair pair = new Pair(i, p);
                fileteredPP.add(pair);
                fileteredPPValue.add(p);
            }

            Collections.sort(fileteredPPValue);

            boolean ok = true;
            for (int j = 0; j < fileteredPP.size() - 1; j++) {
                if (fileteredPPValue.get(j + 1) - fileteredPPValue.get(j) != 1) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                oks.add(fileteredPP);
            }

            int a = 0;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < oks.size(); i++) {

            List<Pair> ok = oks.get(i);

            int mini = Integer.MAX_VALUE;
            int maxi = Integer.MIN_VALUE;

            for (Pair pair : ok) {
                mini = Math.min(mini, pair.index);
                maxi = Math.max(maxi, pair.index);
            }
            min = Math.min(min, maxi - mini);

        }

        System.out.println(min);
    }

    static class Pair {

        int index, pvalue;

        Pair(int index, int pvalue) {
            this.index = index;
            this.pvalue = pvalue;
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

    //  @Test
    public void Case1() {

        String input = """
                       4 2
                       2 3 1 4
                    """;

        String expected = """
                          1
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC352D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

//    @Test
    public void Case2() {

        String input = """
                    4 1
                       2 3 1 4   
                    """;

        String expected = """
                          0
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC352D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       10 5
                       10 1 6 8 7 2 5 9 3 4
                    """;

        String expected = """
                          5
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC352D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
