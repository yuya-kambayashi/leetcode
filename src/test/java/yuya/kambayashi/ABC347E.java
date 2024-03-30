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
public class ABC347E {
//import java.util.*;
//public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final int q = sc.nextInt();
        int[] xa = new int[q];
        for (int i = 0; i < q; i++) {
            xa[i] = sc.nextInt();
        }

        List<Integer> s = new LinkedList<>();

        int[] aa = new int[n];

        for (int i = 0; i < q; i++) {
            int x = xa[i];

            if (s.contains(x)) {
                s.remove(Integer.valueOf(x));
            } else {
                s.add(x);
            }

            int size = s.size();

            for (int ss : s) {

                aa[ss - 1] += size;
            }

            int a = 0;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < aa.length; i++) {
            sb.append(aa[i]);
            if (i != aa.length - 1) {
                sb.append(" ");
            }
        }

        System.out.println(sb.toString());
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

        in.inputln("3 4");
        in.inputln("1 3 3 2");
        var expected = "6 2 2";

        ABC347E.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled
    @Test
    public void Case2() {

        in.inputln("4 6");
        in.inputln("1 2 3 2 4 2");
        var expected = "15 9 12 7";

        ABC347E.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled
    @Test
    public void Case3() {

        in.inputln("");
        var expected = "";

        ABC347E.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }
}

//import java.util.*;
//public class Main {
