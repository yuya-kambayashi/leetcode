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
public class ABC095C {

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

        final int a = sc.nextInt();
        final int b = sc.nextInt();
        final int c = sc.nextInt();
        final int x = sc.nextInt();
        final int y = sc.nextInt();

        // 全部別々
        long price1 = a * x + b * y;

        // できるだけハーフを買って、残りは単独を買う
        int min = Math.min(x, y);
        long price2 = c * min * 2 + (x - min) * a + (y - min) * b;

        // 全部ハーフ
        long price3 = c * Math.max(x, y) * 2;

        System.out.println(Math.min(price1, Math.min(price2, price3)));
    }
//}

    @Test
    public void Case1() {

        in.inputln("1500 2000 1600 3 2");
        var expected = "7900";

        ABC095C.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void Case2() {

        in.inputln("1500 2000 1900 3 2");
        var expected = "8500";

        ABC095C.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void Case3() {

        in.inputln("1500 2000 500 90000 100000");
        var expected = "100000000";

        ABC095C.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }
}

//import java.util.*;
//public class Main {
