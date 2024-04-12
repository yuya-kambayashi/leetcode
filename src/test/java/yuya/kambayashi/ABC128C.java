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
public class ABC128C {

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
        int n = Integer.parseInt(sc.next());
        int m = Integer.parseInt(sc.next());
        int k[] = new int[m];
        for (int i = 0; i < m; i++) {
            StringBuilder s = new StringBuilder("0000000000".substring(0, n));
            int x = Integer.parseInt(sc.next());
            for (int j = 0; j < x; j++) {
                int y = Integer.parseInt(sc.next());
                s.replace(y - 1, y, "1");
            }
            k[i] = Integer.parseInt(s.toString(), 2);
        }
        int p[] = new int[m];
        for (int i = 0; i < m; i++) {
            p[i] = Integer.parseInt(sc.next());
        }
        int ans = 0;
        for (int i = 0; i < Math.pow(2, n); i++) {
            int f = 1;
            for (int j = 0; j < m; j++) {
                String bin = Integer.toBinaryString(i & k[j]);
                int c = 0;
                for (int v = 0; v < bin.length(); v++) {
                    if (bin.substring(v, v + 1).equals("1")) {
                        c++;
                    }
                }
                if (c % 2 != p[j]) {
                    f = 0;
                    break;
                }
            }
            ans += f;
        }
        System.out.println(ans);
    }
//}

    @Test
    public void Case1() {

        in.inputln("2 2");
        in.inputln("2 1 2");
        in.inputln("1 2");
        in.inputln("0 1");
        var expected = "1";

        ABC128C.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void Case2() {

        in.inputln("2 3");
        in.inputln("2 1 2");
        in.inputln("1 1");
        in.inputln("1 2");
        in.inputln("0 0 1");
        var expected = "0";

        ABC128C.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void Case3() {

        in.inputln("5 2");
        in.inputln("3 1 2 5");
        in.inputln("2 2 3");
        in.inputln("1 0");
        var expected = "8";

        ABC128C.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }
}

//import java.util.*;
//public class Main {
