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
public class ABC167C {

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
        final int x = sc.nextInt();

        int[] ca = new int[n];
        int[][] aaa = new int[n][m];
        for (int i = 0; i < n; i++) {
            ca[i] = sc.nextInt();

            for (int j = 0; j < m; j++) {
                aaa[i][j] = sc.nextInt();
            }
        }

        var t = 1 << n;

        int minCost = Integer.MAX_VALUE;

        for (int i = 0; i < 1 << n; i++) {

            int cost = 0;
            int[] ra = new int[m];
            for (int j = 0; j < n; j++) {
                if ((1 & i >> j) == 1) {
                    // 買う
                    cost += ca[j];

                    // 理解度
                    int[] aa = aaa[j];

                    for (int k = 0; k < m; k++) {
                        ra[k] += aa[k];
                    }

                    int aaaa = 0;
                }
            }

            boolean ok = true;
            for (int j = 0; j < m; j++) {
                if (ra[j] < x) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                minCost = Math.min(minCost, cost);
            }
        }
        if (minCost == Integer.MAX_VALUE) {
            minCost = -1;
        }
        System.out.println(minCost);
    }
//}

    @Test
    public void Case1() {

        in.inputln("3 3 10");
        in.inputln("60 2 2 4");
        in.inputln("70 8 7 9");
        in.inputln("50 2 3 9");
        var expected = "120";

        ABC167C.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void Case2() {

        in.inputln("3 3 10");
        in.inputln("100 3 1 4");
        in.inputln("100 1 5 9");
        in.inputln("100 2 6 5");
        var expected = "-1";

        ABC167C.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void Case3() {

        in.inputln("8 5 22");
        in.inputln("100 3 7 5 3 1");
        in.inputln("164 4 5 2 7 8");
        in.inputln("334 7 2 7 2 9");
        in.inputln("234 4 7 2 8 2");
        in.inputln("541 5 4 3 3 6");
        in.inputln("235 4 8 6 9 7");
        in.inputln("394 3 6 1 6 2");
        in.inputln("872 8 4 3 7 2");
        var expected = "1067";

        ABC167C.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }
}

//import java.util.*;
//public class Main {
