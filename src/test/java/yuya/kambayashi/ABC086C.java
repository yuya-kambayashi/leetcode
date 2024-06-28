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
public class ABC086C {

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
        int[] tt = new int[n];
        int[] xx = new int[n];
        int[] yy = new int[n];

        for (int i = 0; i < n; i++) {
            tt[i] = sc.nextInt();
            xx[i] = sc.nextInt();
            yy[i] = sc.nextInt();
        }

        int bx = 0, by = 0, bt = 0;

        for (int i = 0; i < n; i++) {

            int dt = tt[i] - bt;
            int dx = xx[i] - bx;
            int dy = yy[i] - by;

            long move = Math.abs(dx) + Math.abs(dy);

            // 移動量が時間を乞えるならNo
            if (move > dt) {
                System.out.println("No");
                return;
            }
            // とどまって調整できるか？
            if (move % 2 == 0 && dt % 2 == 1) {
                System.out.println("No");
                return;
            }
            if (move % 2 == 1 && dt % 2 == 0) {
                System.out.println("No");
                return;
            }

            bt = dt;
            bx = dx;
            by = dy;
        }
        System.out.println("Yes");
    }
//}

    @Test
    public void Case1() {

        in.inputln("2");
        in.inputln("3 1 2");
        in.inputln("6 1 1");

        ABC086C.main(null);

        var actual = out.readLine();

        var expected = "Yes";

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void Case2() {

        in.inputln("1");
        in.inputln("2 100 100");

        ABC086C.main(null);

        var actual = out.readLine();

        var expected = "No";

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void Case3() {

        in.inputln("2");
        in.inputln("5 1 1");
        in.inputln("100 1 1");

        ABC086C.main(null);

        var actual = out.readLine();

        var expected = "No";

        assertThat(actual).isEqualTo(expected);
    }
}

//import java.util.*;
//public class Main {
