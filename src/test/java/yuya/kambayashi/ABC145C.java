/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yuya.kambayashi;

import java.util.*;
import org.assertj.core.api.Assertions;
import static org.assertj.core.api.Assertions.assertThat;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

/**
 *
 * @author kamba
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC145C {

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
//public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();

        int[] xx = new int[n];
        int[] yy = new int[n];
        for (int i = 0; i < n; i++) {
            xx[i] = sc.nextInt();
            yy[i] = sc.nextInt();
        }
        int[] seeds = new int[n];
        for (int i = 0; i < n; i++) {
            seeds[i] = i;
        }
        var perms = permutation(seeds);

        double sum = 0;
        int cnt = 0;

        for (var perm : perms) {
            for (int i = 0; i < perm.size() - 1; i++) {

                int from = perm.get(i);
                int to = perm.get(i + 1);
                double t = Math.sqrt((xx[from] - xx[to]) * (xx[from] - xx[to]) + (yy[from] - yy[to]) * (yy[from] - yy[to]));
                sum += t;
            }
        }
        System.out.println(sum / perms.size());

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

        in.inputln("3");
        in.inputln("0 0");
        in.inputln("1 0");
        in.inputln("0 1");
        double expected = 2.2761423749;

        ABC145C.main(null);
        var actual = out.readLine();
        double actuald = Double.valueOf(actual);
        assertThat(actuald).isCloseTo(expected, Assertions.within(0.0001));

    }

    @Test
    public void Case2() {

        in.inputln("2");
        in.inputln("-879 981");
        in.inputln("-866 890");
        var expected = 91.9238815543;

        ABC145C.main(null);
        var actual = out.readLine();
        double actuald = Double.valueOf(actual);
        assertThat(actuald).isCloseTo(expected, Assertions.within(0.0001));
    }

    @Test
    public void Case3() {

        in.inputln("8");
        in.inputln("-406 10");
        in.inputln("512 859");
        in.inputln("494 362");
        in.inputln("-955 -475");
        in.inputln("128 553");
        in.inputln("-986 -885");
        in.inputln("763 77");
        in.inputln("449 310");
        var expected = 7641.9817824387;

        ABC145C.main(null);
        var actual = out.readLine();
        double actuald = Double.valueOf(actual);
        assertThat(actuald).isCloseTo(expected, Assertions.within(0.0001));
    }
}

//import java.util.*;
//public class Main {
