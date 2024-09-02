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
public class ABC369E {

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
    static char[][] grid;
    static int n;
    static int h;
    static int w;
    static int max;
    static String maxPath;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        h = sc.nextInt();
        w = sc.nextInt();
        n = sc.nextInt();
        max = 0;
        maxPath = "";
        grid = new char[h][w];
        for (int i = 0; i < h; i++) {
            Arrays.fill(grid[i], '.');
        }
        for (int i = 0; i < n; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            r--;
            c--;
            grid[r][c] = '#';
        }

        dfs(0, 0, 0, "");

        System.out.println(max);
        System.out.println(maxPath);

    }

    static void dfs(int r, int c, int point, String path) {
        if (r >= h || c >= w) {
            return;
        }

        if (grid[r][c] == '#') {
            point++;
        }
        if (r == h - 1 && c == w - 1) {

            max = Math.max(max, point);
            if (point == max) {
                maxPath = path;
            }
            return;
        }

        dfs(r + 1, c, point, path + "D");
        dfs(r, c + 1, point, path + "R");

    }
//}

    @Test
    public void Case1() {

        String input = """
                       3 4 4
                       3 3
                       2 1
                       2 3
                       1 4
                    """;

        String expected = """
                          3
                          DRRDR
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC369E.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       2 2 2
                       2 1
                       1 2
                    """;

        String expected = """
                          1
                          DR
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC369E.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       10 15 8
                       2 7
                       2 9
                       7 9
                       10 3
                       7 11
                       8 12
                       9 6
                       8 1
                    """;

        String expected = """
                          5
                          DRRRRRRRRDDDDDRRDRDDRRR
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC369E.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC369E.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
