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
public class ABC300C {

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

    static int[] ans;
    static int h;
    static int w;
    static int[][] dir = {{1, 1}, {-1, 1}, {-1, -1}, {1, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        h = sc.nextInt();
        w = sc.nextInt();
        final int n = Math.min(h, w);

        grid = new char[h][w];
        for (int r = 0; r < h; r++) {
            grid[r] = sc.next().toCharArray();
        }
        ans = new int[n];

        for (int i = 1; i <= n; i++) {
            for (int row = i; row < h - i; row++) {
                for (int col = i; col < w - i; col++) {
                    if (solve(i, row, col)) {
                        ans[i - 1]++;
                    }
                }
            }
        }
        for (var a : ans) {
            System.out.print(a);
            System.out.print(" ");
        }
    }

    static boolean solve(int i, int row, int col) {

        // 中心点が#
        if (grid[row][col] != '#') {
            return false;
        }
        //　伸びた足がすべて#
        for (var d : dir) {
            for (int j = 1; j <= i; j++) {
                int row2 = row + d[0] * j;
                int col2 = col + d[1] * j;

                if (row2 < 0 || row2 >= h || col2 < 0 || col2 >= w) {
                    return false;
                }

                if (grid[row2][col2] != '#') {
                    return false;
                }
            }
        }
        // 足の伸びた先の次のいずれかが.
        boolean ok = false;
        for (var d : dir) {

            int row2 = row + d[0] * (i + 1);
            int col2 = col + d[1] * (i + 1);

            if (row2 < 0 || row2 >= h || col2 < 0 || col2 >= w) {
                ok = true;
                break;
            }

            if (grid[row2][col2] == '.') {
                ok = true;
                break;
            }
        }
        if (!ok) {
            return false;
        }

        return true;
    }
//}

    @Test

    public void Case1() {

        String input = """
                       5 9
#.#.#...#
.#...#.#.
#.#...#..
.....#.#.
....#...#
                    """;

        String expected = """
                          1 1 0 0 0
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC300C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       3 3
...
...
...
                    """;

        String expected = """
                          0 0 0
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC300C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       3 16
#.#.....#.#..#.#
.#.......#....#.
#.#.....#.#..#.#
                    """;

        String expected = """
                          3 0 0
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC300C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case4() {

        String input = """
                       15 20
#.#..#.............#
.#....#....#.#....#.
#.#....#....#....#..
........#..#.#..#...
#.....#..#.....#....
.#...#....#...#..#.#
..#.#......#.#....#.
...#........#....#.#
..#.#......#.#......
.#...#....#...#.....
#.....#..#.....#....
........#.......#...
#.#....#....#.#..#..
.#....#......#....#.
#.#..#......#.#....#
                    """;

        String expected = """
                          5 0 1 0 0 0 1 0 0 0 0 0 0 0 0
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC300C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
