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
public class ABC128C {

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

        int[] kk = new int[m];
        List<int[]> sss = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            kk[i] = sc.nextInt();

            int[] t = new int[kk[i]];
            for (int j = 0; j < kk[i]; j++) {
                t[j] = sc.nextInt();
            }
            sss.add(t);
        }
        int[] pp = new int[m];
        for (int i = 0; i < m; i++) {
            pp[i] = sc.nextInt();
        }
        int ans = 0;

        for (int i = 0; i < 1 << n; i++) {

            boolean all = true;

            for (int j = 0; j < m; j++) {

                // 電球のonになっているスイッチの数
                int on = 0;

                // 電球の点灯するあまり
                int p = pp[j];

                int[] ss = sss.get(j);

                for (int k = 0; k < kk[j]; k++) {
                    int s = ss[k];

                    if ((1 & i >> (s - 1)) == 1) {
                        on++;
                    }
                }
                if (on % 2 != p) {
                    all = false;
                    break;
                }
            }
            if (all) {
                ans++;
            }
        }

        System.out.println(ans);
    }
//}

    @Test
    public void Case1() {

        in.inputln("2 2");
        in.inputln("2 1 2");
        in.inputln("1 2");
        in.inputln("0 1");
        var expected = "1";

        ABC128C.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void Case2() {

        in.inputln("2 3");
        in.inputln("2 1 2");
        in.inputln("1 1");
        in.inputln("1 2");
        in.inputln("0 0 1");
        var expected = "0";

        ABC128C.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void Case3() {

        in.inputln("5 2");
        in.inputln("3 1 2 5");
        in.inputln("2 2 3");
        in.inputln("1 0");
        var expected = "8";

        ABC128C.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }
}

//import java.util.*;
//public class Main {
