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
public class ABC373D {

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
    static int n;
    static List<List<Integer>> idss;
    static long[] ans = new long[n + 1];
    static long[][] ggg;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        final long m = sc.nextLong();
        ggg = new long[n + 1][n + 1];
        idss = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            Arrays.fill(ggg[i], 0);

            List<Integer> ids = new ArrayList<>();
            idss.add(ids);
        }
        for (long i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            long w = sc.nextLong();
            ggg[u][v] = w;

            idss.get(u).add(v);

        }
        ans = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            if (ans[i] == 0) {
                dfs(i);
            }
        }

        for (int i = 1; i < n + 1; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();

    }

    static void dfs(int cur) {

        var ids = idss.get(cur);

        for (var next : ids) {

            ans[next] = ggg[cur][next] + ans[cur];
            dfs(next);
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                       3 3
                       1 2 2
                       3 2 3
                       1 3 -1
                    """;

        String expected = """
                          3 5 2
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC373D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       4 2
                       2 1 5
                       3 4 -3
                    """;

        String expected = """
                          5 0 6 3
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC373D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                       5 7
                       2 1 18169343
                       3 1 307110901
                       4 1 130955934
                       2 3 -288941558
                       2 5 96267410
                       5 3 -385208968
                       4 3 -176154967
                    """;

        String expected = """
                          200401298 182231955 -106709603 69445364 278499365
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC373D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC373D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
