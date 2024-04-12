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
public class ABC106B {
//import java.util.*;
//public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();

        int ans = 0;

        for (int i = 1; i <= n; i++) {

            if (i % 2 != 1) {
                continue;
            }

            int cnt = 1;
            for (int j = 2; j <= i; j++) {

                if (i % j == 0) {
                    cnt++;
                }
            }
            if (cnt == 8) {
                ans++;
            }

        }

        System.out.println(ans);
    }
//}

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

        in.inputln("105");
        var expected = "1";

        ABC106B.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

//    @Disabled
    @Test
    public void Case2() {

        in.inputln("7");
        var expected = "0";

        ABC106B.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled
    @Test
    public void Case3() {

        in.inputln("");
        var expected = "";

        ABC106B.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }
}

//import java.util.*;
//public class Main {
