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
//import java.util.*;
//public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final long a = sc.nextLong();
        final long b = sc.nextLong();
        long[] da = new long[n];
        for (int i = 0; i < n; i++) {
            da[i] = sc.nextLong();
        }

        for (int i = 0; i < da.length; i++) {
            da[i] %= (a + b);
        }

        Set<Long> checkedHs = new HashSet<>();

        for (long i = 0; i < (a + b); i++) {
            // 休日
            long hs = 1;
            long he = a;

            //休日をずらす
            hs += i;
            he += i;

            hs %= (a + b);
            he %= (a + b);

            if (checkedHs.contains(hs)) {
                continue;
            } else {
                checkedHs.add(hs);
            }

            // タスクをチェック
            boolean all = true;
            for (long d : da) {
                if (d <= hs || he <= d) {
                    all = false;
                    break;
                }
            }
            if (all) {
                System.out.println("Yes");
                return;
            }

        }

        System.out.println("No");
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

        in.inputln("3 2 5");
        in.inputln("1 2 9");

        ABC347C.main(null);

        var actual = out.readLine();

        var expected = "Yes";

        assertThat(actual).isEqualTo(expected);
    }

    //@Disabled
    @Test
    public void Case2() {

        in.inputln("2 5 10");
        in.inputln("10 15");

        ABC347C.main(null);

        var actual = out.readLine();

        var expected = "No";

        assertThat(actual).isEqualTo(expected);
    }

    //  @Disabled
    @Test
    public void Case3() {

        in.inputln("4 347 347");
        in.inputln("347 700 705 710");
        var expected = "Yes";

        ABC347C.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

    //@Disabled
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
