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
    static int height;
    static int width;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        height = sc.nextInt();
        width = sc.nextInt();
        final int n = sc.nextInt();
        final String t = sc.next();

        grid = new char[height][width];
        for (int i = 0; i < height; i++) {
            grid[i] = sc.next().toCharArray();
        }
        int ans = 0;

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {

                if (!isLand(row, col)) {
                    continue;
                }

                int r = row;
                int c = col;
                boolean ok = true;

                for (int i = 0; i < n; i++) {
                    switch (t.charAt(i)) {
                        case 'L':
                            c--;
                            break;
                        case 'R':
                            c++;
                            break;
                        case 'U':
                            r--;
                            break;
                        case 'D':
                            r++;
                            break;
                    }
                    if (!isValid(r, c)) {
                        ok = false;
                        break;
                    }
                    if (!isLand(r, c)) {
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

    static boolean isLand(int row, int col) {
        return grid[row][col] == '.';
    }

    static boolean isValid(int row, int col) {
        if (row < 0) {
            return false;
        }
        if (row >= height) {
            return false;
        }
        if (col < 0) {
            return false;
        }
        if (col >= width) {
            return false;
        }
        return true;
    }
//}

    @Test
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
