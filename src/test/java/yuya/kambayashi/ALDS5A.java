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
public class ALDS5A {

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
        int[] aa = new int[n];
        for (int i = 0; i < n; i++) {
            aa[i] = sc.nextInt();
        }
        final int q = sc.nextInt();
        int[] ma = new int[q];
        for (int i = 0; i < q; i++) {
            ma[i] = sc.nextInt();
        }

        Set<Integer> set = new HashSet<>();
        for (int bit = 0; bit < 1 << n; bit++) {

            int sum = 0;
            for (int i = 0; i < n; i++) {

                if ((bit & (1 << i)) == 1) {

                    // 点数
                    int t = aa[i];
                    sum += t;
                }
            }
            set.add(sum);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            String a;
            if (set.contains(ma[i])) {
                a = "yes";
            } else {
                a = "no";
            }
//                if (i != q - 1) {
//                    sb.append(" ");
//                }
            System.out.println(a);
        }

        //System.out.println(sb.toString());
    }
//}

    @Test
    public void Case1() {

        in.inputln("5");
        in.inputln("1 5 7 10 21");
        in.inputln("4");
        in.inputln("2 4 17 8");
        var expected = "no no yes yes";

        ALDS5A.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void Case2() {

        in.inputln("5");
        in.inputln("1 5 7 10 21");
        in.inputln("10");
        in.inputln("2 4 6 15 17 8 22 21 100 35");
        var expected = "no no yes yes yes yes yes yes no no";

        ALDS5A.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

    // @Test
    public void Case3() {

        in.inputln("");
        var expected = "";

        ALDS5A.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }
}

//import java.util.*;
//public class Main {
