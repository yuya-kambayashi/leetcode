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
public class SUMITB2019D {

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
        final String s = sc.next();

        Set<String> set = new HashSet();

        int ans = 0;
        for (int i = 0; i < 1000; i++) {
            String t = String.format("%03d", i);

            int targetIndex = 0;
            for (int j = 0; j < n; j++) {

                if (s.charAt(j) == t.charAt(targetIndex)) {
                    targetIndex++;
                    if (targetIndex == 3) {
                        ans++;
                        break;
                    }
                }
            }
        }

        System.out.println(ans);
    }
//}

    @Test
    public void Case1() {

        in.inputln("4");
        in.inputln("0224");
        var expected = "3";

        SUMITB2019D.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void Case2() {

        in.inputln("6");
        in.inputln("123123");
        var expected = "17";

        SUMITB2019D.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void Case3() {

        in.inputln("19 3141592653589793238");
        var expected = "329";

        SUMITB2019D.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }
}

//import java.util.*;
//public class Main {
