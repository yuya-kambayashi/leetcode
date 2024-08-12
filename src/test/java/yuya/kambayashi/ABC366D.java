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
        int[][][] aaa = new int[n][n][n];
        int[][][] bbb = new int[n][n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    int t = sc.nextInt();
                    aaa[i][j][k] = t;
                    bbb[i][j][k] = t;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 1; k < n; k++) {
                    bbb[i][j][k] += bbb[i][j][k - 1];
                }
            }
        }

        // 1,2,3
        // 1,3,6
        int ap = 0;

        int q = sc.nextInt();
        int[] lxx = new int[q];
        int[] rxx = new int[q];
        int[] lyy = new int[q];
        int[] ryy = new int[q];
        int[] lzz = new int[q];
        int[] rzz = new int[q];
        for (int i = 0; i < q; i++) {
            lxx[i] = sc.nextInt() - 1;
            rxx[i] = sc.nextInt() - 1;
            lyy[i] = sc.nextInt() - 1;
            ryy[i] = sc.nextInt() - 1;
            lzz[i] = sc.nextInt() - 1;
            rzz[i] = sc.nextInt() - 1;
        }
        for (int i = 0; i < q; i++) {
            int lx = lxx[i];
            int rx = rxx[i];
            int ly = lyy[i];
            int ry = ryy[i];
            int lz = lzz[i];
            int rz = rzz[i];
            // 1,2,1 -> 2,2,1   / 0,1,0 -? 1,1,0
            // 2,1,1 -> 2,2,2
            int ans = bbb[lx][rx][ly];
            int ans2 = bbb[lx][rx][ly];

            System.out.println(ans);

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
