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
public class JOI2007HOC {

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

        Set<int[]> set = new HashSet<>();

        double max = 0.0;

        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                for (int k = j + 1; k < n - 1; k++) {
                    int[] p1 = zaa[i];
                    int[] p2 = zaa[j];
                    int[] p3 = zaa[k];

                    // 3点から正方形を構成できる4点目を取得する
                    int[] p4 = findFourthPoint(p1, p2, p3);

                    for (int l = k + 1; l < n; l++) {
                        if (p4[0] == zaa[l][0] && p4[1] == zaa[l][1]) {

                        }
                    }

                }
            }
        }

        if (max
                == -1) {
            max = 0.0;
        }

        System.out.println(
                (int) max
        );
    }

    public static int[] findFourthPoint(int[] p1, int[] p2, int[] p3) {
        int x4, y4;

        // Calculate midpoint of p1 and p2
        int midX = (p1[0] + p2[0]) / 2;
        int midY = (p1[1] + p2[1]) / 2;

        // Calculate vector from midpoint to p3
        int vecX = p3[0] - midX;
        int vecY = p3[1] - midY;

        // Calculate fourth point
        x4 = midX - vecY;
        y4 = midY + vecX;

        int[] ret = {x4, y4};
        return ret;
    }
//}

    @Test
    public void Case1() {

        in.inputln("10");
        in.inputln("9 4");
        in.inputln("4 3");
        in.inputln("1 1");
        in.inputln("4 2");
        in.inputln("2 4");
        in.inputln("5 8");
        in.inputln("4 0");
        in.inputln("5 3");
        in.inputln("0 5");
        in.inputln("5 2");
        var expected = "10";

        JOI2007HOC.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }
    //  @Test

    public void Case2() {

        in.inputln("");
        var expected = "";

        JOI2007HOC.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

    // @Test
    public void Case3() {

        in.inputln("");
        var expected = "";

        JOI2007HOC.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }
}

//import java.util.*;
//public class Main {
