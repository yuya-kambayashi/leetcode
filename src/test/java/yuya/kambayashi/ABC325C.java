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
public class ABC325C {

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
    static boolean[][] visited;
    static char[][] grid;
    static int ans;
    static int height, width;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        height = sc.nextInt();
        width = sc.nextInt();
        grid = new char[height][width];
        visited = new boolean[height][width];
        for (int i = 0; i < height; i++) {
            grid[i] = sc.next().toCharArray();
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (!visited[i][j] && grid[i][j] == '#') {
                    ans++;
                    dfs(i, j);
                }
            }
        }

        System.out.println(ans);
        sc.close();
    }

    static void dfs(int r, int c) {

        if (r < 0 || r >= height) {
            return;
        }
        if (c < 0 || c >= width) {
            return;
        }

        if (visited[r][c]) {
            return;
        }

        visited[r][c] = true;

        if (grid[r][c] == '.') {
            return;
        }

        dfs(r - 1, c - 1);
        dfs(r - 1, c);
        dfs(r - 1, c + 1);
        dfs(r, c - 1);
        dfs(r, c + 1);
        dfs(r + 1, c - 1);
        dfs(r + 1, c);
        dfs(r + 1, c + 1);
    }
//}

    //@Test
    public void Case1() {

        String input = """
                       5 6
.##...
...#..
....##
#.#...
..#...
                    """;

        String expected = """
                          3
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC325C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       3 3
#.#
.#.
#.#
                    """;

        String expected = """
                          1
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC325C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       4 2
..
..
..
..
                    """;

        String expected = """
                          0
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC325C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case4() {

        String input = """
                       5 47
.#..#..#####..#...#..#####..#...#...###...#####
.#.#...#.......#.#...#......##..#..#...#..#....
.##....#####....#....#####..#.#.#..#......#####
.#.#...#........#....#......#..##..#...#..#....
.#..#..#####....#....#####..#...#...###...#####
                    """;

        String expected = """
                          7
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC325C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
