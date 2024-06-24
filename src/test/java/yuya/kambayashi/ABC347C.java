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
public class ABC347C {

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
        final int a = sc.nextInt();
        final int b = sc.nextInt();

        int week = a + b;
        List<Integer> dd = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            dd.add(sc.nextInt() % week);
        }
        Collections.sort(dd);
        for (int i = 0; i < n; i++) {
            dd.add(dd.get(i) + week);
        }

        for (int i = 0; i < n; i++) {
            int left = dd.get(i);
            int right = dd.get(i + n - 1);
            if (right - left + 1 <= a) {
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No");

    }
//}

    @Test
    public void Case1() {

        in.inputln("3 2 5");
        in.inputln("1 2 9");

        ABC347C.main(null);

        var actual = out.readLine();

        var expected = "Yes";

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void Case2() {

        in.inputln("2 5 10");
        in.inputln("10 15");

        ABC347C.main(null);

        var actual = out.readLine();

        var expected = "No";

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void Case3() {

        in.inputln("4 347 347");
        in.inputln("347 700 705 710");
        var expected = "Yes";

        ABC347C.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void CaseD() {

        in.inputln("1 1 6");
        in.inputln("1");
        var expected = "Yes";

        ABC347C.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }
}

//import java.util.*;
//public class Main {
