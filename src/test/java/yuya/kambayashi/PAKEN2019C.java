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
public class PAKEN2019C {

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
        final int m = sc.nextInt();
        long[][] aaa = new long[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                aaa[i][j] = sc.nextLong();
            }
        }

        Set<int[]> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                int[] p = {i, j};
                set.add(p);
            }
        }
        long ans = 0;
        for (var p : set) {

            int k1 = p[0];
            int k2 = p[1];
            long t = 0;

            for (int i = 0; i < n; i++) {
                long t1 = aaa[i][k1];
                long t2 = aaa[i][k2];

                t += Math.max(t1, t2);
            }
            ans = Math.max(ans, t);
        }

        System.out.println(ans);
    }
//}  

    @Test
    public void Case1() {

        in.inputln("1 2");
        in.inputln("80 84");
        var expected = "84";

        PAKEN2019C.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void Case2() {

        in.inputln("3 4");
        in.inputln("37 29 70 41");
        in.inputln("85 69 76 50");
        in.inputln("53 10 95 100");
        var expected = "250";

        PAKEN2019C.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void Case3() {

        in.inputln("8 2");
        in.inputln("31000000 41000000");
        in.inputln("59000000 26000000");
        in.inputln("53000000 58000000");
        in.inputln("97000000 93000000");
        in.inputln("23000000 84000000");
        in.inputln("62000000 64000000");
        in.inputln("33000000 83000000");
        in.inputln("27000000 95000000");
        var expected = "581000000";

        PAKEN2019C.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

}

//import java.util.*;
//public class Main {
