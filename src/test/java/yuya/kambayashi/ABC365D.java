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
public class ABC365D {

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
        final String s = sc.next();
        String rsp = "RSP";
        int[][] dp = new int[3][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                dp[j][i] = -n;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (s.charAt(0) == rsp.charAt(i)) {
                dp[i][0] = 0;
                dp[(i + 2) % 3][0] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (s.charAt(i) != rsp.charAt(j)) {
                    continue;
                }
                int win = (j + 2) % 3;
                dp[j][i] = Math.max(dp[j][i], dp[(j + 1) % 3][i - 1]);
                dp[j][i] = Math.max(dp[j][i], dp[(j + 2) % 3][i - 1]);
                dp[win][i] = Math.max(dp[win][i], dp[(win + 1) % 3][i - 1] + 1);
                dp[win][i] = Math.max(dp[win][i], dp[(win + 2) % 3][i - 1] + 1);
            }
        }
        int ans = 0;
        for (int i = 0; i < 3; i++) {
            ans = Math.max(dp[i][n - 1], ans);
        }
        System.out.println(ans);
    }

//}
    @Test
    public void Case1() {

        String input = """
                       6
                       PRSSRS
                    """;

        String expected = """
                          5
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC365D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       10
                       SSSSSSSSSS
                    """;

        String expected = """
                          5
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC365D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       24
                       SPRPSRRRRRPPRPRPSSRSPRSS
                    """;

        String expected = """
                          18
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC365D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case4() {

        String input = """
                       4
                       PPPS
                    """;

        String expected = """
                          3
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC365D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case5() {

        String input = """
                       4
                       PPPR
                    """;

        String expected = """
                          3
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC365D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
