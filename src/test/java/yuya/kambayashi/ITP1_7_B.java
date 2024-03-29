/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yuya.kambayashi;

import java.util.*;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

/**
 *
 * @author kamba
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ITP1_7_B {

//import java.util.*;
//public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] na = new int[10000];
        int[] xa = new int[10000];
        for (int i = 0; i < na.length; i++) {

            na[i] = sc.nextInt();
            xa[i] = sc.nextInt();

            if (na[i] == 0 && xa[i] == 0) {
                break;
            }
        }

        for (int p = 0; p < na.length; p++) {
            final int n = na[p];
            final int x = xa[p];

            if (n == 0 && x == 0) {
                return;
            }

            int ans = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    for (int k = j + 1; k <= n; k++) {
                        if (i + j + k == x) {
                            ans++;
                        }
                    }
                }
            }
            System.out.println(ans);
        }
        return;
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

    //@Disabled
    @Test
    public void Case1() {

        in.inputln("5 9");
        in.inputln("0 0");

        ITP1_7_B.main(null);

        var actual = out.readLine();

        var expected = "2";

        assertThat(actual).isEqualTo(expected);
    }

    //@Disabled
    @Test
    public void Case2() {

        in.inputln("100 100");
        in.inputln("100 200");
        in.inputln("100 297");
        in.inputln("0 0");

        ITP1_7_B.main(null);

        var actual = out.readLine();
        var expected = "784";
        assertThat(actual).isEqualTo(expected);

        actual = out.readLine();
        expected = "833";
        assertThat(actual).isEqualTo(expected);

        actual = out.readLine();
        expected = "1";
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled
    @Test
    public void Case3() {

        in.inputln("");

        ITP1_7_B.main(null);

        var actual = out.readLine();

        var expected = "";

        assertThat(actual).isEqualTo(expected);
    }
}
