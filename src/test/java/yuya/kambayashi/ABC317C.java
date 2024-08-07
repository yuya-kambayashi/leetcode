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
public class ABC317C {

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

    static int ans;
    static boolean[] checked;
    static int[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final int m = sc.nextInt();

        grid = new int[n][n];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            a--;
            b--;
            grid[a][b] = c;
            grid[b][a] = c;
        }
        ans = 0;
        checked = new boolean[n];

        for (int i = 0; i < n; i++) {
            dfs(i, 0);
        }

        System.out.println(ans);
    }

    static void dfs(int i, int p) {
        ans = Math.max(ans, p);

        checked[i] = true;

        for (int j = 0; j < grid.length; j++) {
            if (checked[j]) {
                continue;
            }
            if (grid[i][j] == 0) {
                continue;
            }
            dfs(j, p + grid[i][j]);
        }
        checked[i] = false;

    }
//}

    @Test
    public void Case1() {

        String input = """
                       4 4
1 2 1
2 3 10
1 3 100
1 4 1000
                    """;

        String expected = """
                          1110
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC317C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       10 1
5 9 1
                    """;

        String expected = """
                          1
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC317C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       10 13
1 2 1
1 10 1
2 3 1
3 4 4
4 7 2
4 8 1
5 8 1
5 9 3
6 8 1
6 9 5
7 8 1
7 9 4
9 10 3
                    """;

        String expected = """
                          20
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC317C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC317C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
