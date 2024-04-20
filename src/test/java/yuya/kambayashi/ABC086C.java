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

        int[] ta = new int[n];
        int[] xa = new int[n];
        int[] ya = new int[n];

        for (int i = 0; i < n; i++) {
            ta[i] = sc.nextInt();
            xa[i] = sc.nextInt();
            ya[i] = sc.nextInt();
        }
        boolean ok = true;
        int bt = 0, bx = 0, by = 0;
        for (int i = 0; i < n; i++) {
            int t = ta[i] - bt;

            int x = Math.abs(xa[i] - bx);
            int y = Math.abs(ya[i] - by);

            if (t % 2 != (x + y) % 2) {
                ok = false;
                break;
            }

            if (t < x + y) {
                ok = false;
                break;
            }
            bt = t;
            bx = x;
            by = y;

        }
        if (ok) {
            System.out.println("Yes");
        } else {
            System.out.println("No");

        }
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
