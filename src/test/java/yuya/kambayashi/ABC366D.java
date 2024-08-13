/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yuya.kambayashi;

import java.util.*;
import java.util.stream.Stream;
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
public class ABC366D {

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
//import java.math.*;
//import java.util.*;
//import java.util.stream.*;
//public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        int[][][] aaa = new int[n + 1][n + 1][n + 1];
        int[][][] bbb = new int[n + 1][n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    int t = sc.nextInt();
                    aaa[i][j][k] = t;
                    bbb[i][j][k] = t;
                }
            }
        }

        // 1,2,3
        // 1,3,6
        int q = sc.nextInt();
        int[][] qq = new int[q][6];
        for (int i = 0; i < q; i++) {
            for (int j = 0; j < 6; j++) {
                qq[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= n; k++) {
                    aaa[i + 1][j][k] += aaa[i][j][k];
                }
            }
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= n; k++) {
                    aaa[i][j + 1][k] += aaa[i][j][k];
                }
            }
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k < n; k++) {
                    aaa[i][j][k + 1] += aaa[i][j][k];
                }
            }
        }
        for (int i = 0; i < 1; i++) {
            int lx = qq[i][0];
            int rx = qq[i][1];
            int ly = qq[i][2];
            int ry = qq[i][3];
            int lz = qq[i][4];
            int rz = qq[i][5];

            int t = aaa[rx][ry][rz] - aaa[rx][ry][lz - 1]
                    - aaa[rx][ly - 1][rz] - aaa[rx][ly - 1][lz - 1]
                    + aaa[lx - 1][ry][rz] + aaa[lx - 1][ry][lz - 1]
                    + aaa[lx - 1][ly - 1][rz] - aaa[lx - 1][ly - 1][lz - 1];
            System.out.println(t);

        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                       2
                       1 2
                       3 4
                       5 6
                       7 8
                       2
                       1 2 2 2 1 1
                       2 2 1 2 1 2
                    """;

        String expected = """
                          10
                          26
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC366D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       3
                       733 857 714
                       956 208 257
                       123 719 648
                       840 881 245
                       245 112 746
                       306 942 694
                       58 870 849
                       13 208 789
                       687 906 783
                       8
                       3 3 3 3 1 1
                       1 3 2 3 3 3
                       2 2 2 3 1 1
                       1 3 1 1 1 1
                       2 3 2 3 2 3
                       1 2 1 1 1 2
                       3 3 2 2 1 3
                       1 2 2 3 2 3
                    """;

        String expected = """
                          687
                          3917
                          551
                          1631
                          5180
                          3311
                          1010
                          4326
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC366D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC366D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC366D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
