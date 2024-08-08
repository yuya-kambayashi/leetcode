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
public class ABC241C {

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

    static char grid[][];
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1},
        {1, -1}, {1, 1}};

        grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            grid[i] = sc.next().toCharArray();
        }
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                for (var dir : dirs) {
                    if (check(r, c, dir)) {
                        System.out.println("Yes");
                        return;
                    }
                }

            }
        }

        System.out.println("No");
    }

    static boolean check(int r, int c, int[] dir) {
        int cntS = 0, cntW = 0;
        for (int i = 0; i < 6; i++) {
            int dr = r + i * dir[0];
            int dc = c + i * dir[1];

            if (0 <= dr && dr < n && 0 <= dc && dc < n) {
                if (grid[dr][dc] == '#') {
                    cntS++;
                } else {
                    cntW++;
                }
            }
        }
        int canS = Math.min(cntW, 2);
        return cntS + canS == 6;
    }
//}

    @Test
    public void Case1() {

        String input = """
                       8
........
........
.#.##.#.
........
........
........
........
........
                    """;

        String expected = """
                          Yes
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC241C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       6
######
######
######
######
######
######
                    """;

        String expected = """
                          Yes
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC241C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       10
..........
#..##.....
..........
..........
....#.....
....#.....
.#...#..#.
..........
..........
..........
                    """;

        String expected = """
                          No
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC241C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case4() {

        String input = """
                       6
                       ....#.
                       ...#..
                       ..#...
                       .#....
                       #.....
                       ......
                    """;

        String expected = """
                          No
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC241C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
