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
public class ABC341C {

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
//public class Main {

    static char[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int row = sc.nextInt();
        final int col = sc.nextInt();
        final int n = sc.nextInt();
        final String t = sc.next();

        grid = new char[row][col];
        for (int i = 0; i < row; i++) {
            String s = sc.next();

            grid[i] = s.toCharArray();

        }

        int ans = 0;

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {

                int rt = r, ct = c;
                boolean ok = true;

                if (rt == 4 && ct == 6) {
                    int a1 = 0;
                }
                if (rt == 5 && ct == 6) {
                    int a2 = 0;
                }
                if (rt == 6 && ct == 9) {
                    int a3 = 0;
                }
                if (rt == 7 && ct == 9) {
                    int a4 = 0;
                }
                if (rt == 9 && ct == 14) {
                    int a5 = 0;
                }
                if (rt == 11 && ct == 3) {
                    int a6 = 0;
                }
                for (int i = 0; i < t.length(); i++) {
                    if (!isLand(rt, ct) || rt == 0 || rt == row || ct == 0 || ct == col) {
                        ok = false;
                        break;
                    }

                    switch (t.charAt(i)) {
                        case 'L':
                            ct--;
                            break;
                        case 'R':
                            ct++;
                            break;
                        case 'U':
                            rt--;
                            break;
                        case 'D':
                            rt++;
                            break;
                    }
                    if (!isLand(rt, ct) || rt == 0 || rt == row || ct == 0 || ct == col) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }

    static boolean isLand(int r, int c) {
        return grid[r][c] == '.';
    }
//}

    //@Test
    public void Case1() {

        String input = """
                       6 7 5
                       LULDR
                       #######
                       #...#.#
                       ##...##
                       #.#...#
                       #...#.#
                       #######
                    """;

        String expected = """
                          2
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC341C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
13 16 9
                       ULURDLURD
                       ################
                       ##..##.#..####.#
                       ###.#..#.....#.#
                       #..##..#####.###
                       #...#..#......##
                       ###.##.#..#....#
                       ##.#####....##.#
                       ###.###.#.#.#..#
                       ######.....##..#
                       #...#.#.######.#
                       ##..###..#..#.##
                       #...#.#.#...#..#
                       ################
                    """;

        String expected = """
                          6
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC341C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
    // @Test

    public void Case3() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC341C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
