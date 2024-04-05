/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yuya.kambayashi;

import java.util.*;
import java.util.stream.Collectors;
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
public class ABC150C {

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
        int[] pa = new int[n];
        int[] qa = new int[n];

        for (int i = 0; i < n; i++) {
            pa[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            qa[i] = sc.nextInt();
        }
        List<Integer> pl = Arrays.stream(pa).boxed().collect(Collectors.toList());
        List<Integer> ql = Arrays.stream(qa).boxed().collect(Collectors.toList());

        int[] aa = new int[n];
        for (int i = 0; i < n; i++) {
            aa[i] = i + 1;
        }

        var arrays = permutation(aa);

        int posA = 0, posB = 0;
        for (int i = 0; i < arrays.size(); i++) {
            ArrayList<Integer> array = arrays.get(i);

            if (array.equals(pl)) {
                posA = i + 1;
            }
            if (array.equals(ql)) {
                posB = i + 1;
            }
        }

        System.out.println(Math.abs(posA - posB));
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
        in.inputln("1 3 2");
        in.inputln("3 1 2");
        var expected = "3";

        ABC150C.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);

    }

    @Test
    public void Case2() {

        in.inputln("8");
        in.inputln("7 3 5 4 2 1 6 8");
        in.inputln("3 8 2 5 4 6 7 1");
        var expected = "17517";

        ABC150C.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void Case3() {

        in.inputln("3");
        in.inputln("1 2 3");
        in.inputln("1 2 3");
        var expected = "0";

        ABC150C.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }
}

//import java.util.*;
//public class Main {
