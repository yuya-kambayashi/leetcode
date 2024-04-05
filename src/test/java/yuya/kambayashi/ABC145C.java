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
        int[][] zaa = new int[n][2];
        for (int i = 0; i < n; i++) {
            zaa[i][0] = sc.nextInt();
            zaa[i][1] = sc.nextInt();
        }

        int[] aa = new int[n];
        for (int i = 0; i < n; i++) {
            aa[i] = i;
        }

        var arrays = permutation(aa);

        double sum = 0.0;
        int cnt = 0;

        for (int i = 0; i < arrays.size(); i++) {

            ArrayList<Integer> array = arrays.get(i);
            double sumt = 0.0;
            for (int j = 1; j < array.size(); j++) {

                Integer i0 = array.get(j - 1);
                Integer i1 = array.get(j);

                int[] za0 = zaa[array.get(j - 1).intValue()];
                int[] za1 = zaa[array.get(j).intValue()];

                double dist = Math.sqrt(Math.pow(za0[0] - za1[0], 2) + Math.pow(za0[1] - za1[1], 2));
                sumt += dist;
            }
            sum += sumt;
            cnt++;
        }

        System.out.println(sum / cnt);
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
