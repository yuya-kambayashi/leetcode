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
public class SQUARE869120B {

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
        int[][] da = new int[n][2];
        for (int i = 0; i < n; i++) {
            da[i][0] = sc.nextInt();
            da[i][1] = sc.nextInt();
        }

        long ans = Long.MAX_VALUE;

        for (int i = 1; i <= 99; i++) {
            for (int j = 2; j <= 100; j++) {
                long time = 0;

                for (int k = 0; k < n; k++) {
                    int a = da[k][0];
                    int b = da[k][1];

                    time += Math.abs(i - a);
                    time += Math.abs(b - a);
                    time += Math.abs(b - j);
                }
                ans = Math.min(ans, time);

            }
        }

        System.out.println(ans);
    }
//}

    @Test
    public void Case1() {

        in.inputln("3");
        in.inputln("5 7");
        in.inputln("2 6");
        in.inputln("8 10");
        var expected = "18";

        SQUARE869120B.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

    //  @Test
    public void Case2() {

        in.inputln("3");
        in.inputln("5 7");
        in.inputln("2 6");
        in.inputln("8 10");
        var expected = "18";

        SQUARE869120B.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

    // @Test
    public void Case3() {

        in.inputln("");
        var expected = "";

        SQUARE869120B.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }
}

//import java.util.*;
//public class Main {
