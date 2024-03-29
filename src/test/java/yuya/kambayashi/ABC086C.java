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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        int[][] naa = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                naa[i][j] = sc.nextInt();
            }
        }

        int tb = 0, xb = 0, yb = 0;

        for (int i = 0; i < n; i++) {
            int[] na = naa[i];

            int t = na[0];
            int x = na[1];
            int y = na[2];

            int distance = Math.abs(x - xb) + Math.abs(y - yb);

            int time = t - tb;

            if (distance > time) {
                System.out.println("No");
                return;
            } else if (distance < time) {

                int rest = time % distance;

                if (rest != 0) {
                    System.out.println("No");
                    return;
                }
            }

            tb = t;
            xb = x;
            yb = y;
        }

        System.out.println("Yes");
    }

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

    ///@Disabled
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

    //@Disabled
    @Test
    public void Case2() {

        in.inputln("1");
        in.inputln("2 100 100");

        ABC086C.main(null);

        var actual = out.readLine();

        var expected = "No";

        assertThat(actual).isEqualTo(expected);
    }

    //@Disabled
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
