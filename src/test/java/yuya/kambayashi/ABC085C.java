/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yuya.kambayashi;

import java.util.*;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

/**
 *
 * @author kamba
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC085C {

    private StandardInputSnatcher in = new StandardInputSnatcher();
    private StandardOutputSnatcher out = new StandardOutputSnatcher();

    @BeforeEach
    public void beforeEach() {
        System.setIn(in);
        System.setOut(out);
    }

    @AfterEach
    public void afterEach() {
        System.setIn(null);
        System.setOut(null);
    }
//import java.util.*;
//import java.util.stream.Collectors;
//public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final int y = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                int k = n - i - j;
                if (k < 0) {
                    continue;
                }
                if (10_000 * i + 5_000 * j + 1_000 * k == y) {

                    String ret = String.valueOf(i) + " " + String.valueOf(j) + " " + String.valueOf(k);
                    System.out.println(ret);
                    return;
                }
            }
        }
        System.out.println("-1 -1 -1");
    }
//}

    @Test
    public void Case1() {

        in.inputln("9 45000");

        ABC085C.main(null);

        var actual = out.readLine();

        var expected = "4 0 5";
        var expected2 = "0 9 0";

        assertThat(actual).isIn(expected, expected2);
    }

    @Test
    public void Case2() {

        in.inputln("20 196000");

        ABC085C.main(null);

        var actual = out.readLine();

        var expected = "-1 -1 -1";

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void Case3() {

        in.inputln("1000 1234000");

        ABC085C.main(null);

        var actual = out.readLine();

        var expected = "14 27 959";

        assertThat(actual).isEqualTo(expected);
    }
}

//import java.util.*;
//public class Main {
