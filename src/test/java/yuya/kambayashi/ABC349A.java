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
public class ABC349A {

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
        int[] aa = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            aa[i] = sc.nextInt();
        }

        int ans = 0;
        for (int a : aa) {
            ans += a;
        }

        System.out.println(-ans);
    }
//}

    @Test
    public void Case2() {

        in.inputln("3");
        in.inputln("0 0");
        var expected = "0";

        ABC349A.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void Case3() {

        in.inputln("6");
        in.inputln("10 20 30 40 50");
        var expected = "-150";

        ABC349A.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }
}

//import java.util.*;
//public class Main {
