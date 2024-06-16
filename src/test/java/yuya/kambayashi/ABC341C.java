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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int height = sc.nextInt();
        final int width = sc.nextInt();
        final int n = sc.nextInt();
        final String t = sc.next();
        char[][] grid = new char[height][width];
        for (int row = 0; row < height; row++) {
            String s = sc.next();
            for (int col = 0; col < width; col++) {
                grid[row][col] = s.charAt(col);
            }
        }

        int result = 0;

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (grid[row][col] == '#') {
                    continue;
                }

                boolean ok = true;

                // チェック対象の座標
                int r = row;
                int c = col;

                // 逆順で移動する
                char[] ca = t.toCharArray();
                for (int i = ca.length - 1; i >= 0; i--) {
                    char ch = ca[i];

                    switch (ch) {
                        case 'L':
                            // 右に戻る
                            c++;
                            break;
                        case 'R':
                            // 左に戻る
                            c--;
                            break;
                        case 'U':
                            // 下に戻る
                            r++;
                            break;
                        case 'D':
                            // 上に戻る
                            r--;
                            break;
                    }

                    // 座標が移動可能かをチェック
                    if (r == 0 || r == height || c == 0 || c == width || grid[r][c] == '#') {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    result++;
                }
            }
        }
        System.out.println(result);
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
