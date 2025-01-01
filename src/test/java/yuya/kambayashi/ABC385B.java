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
public class ABC385B {

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
    // https://atcoder.jp/contests/abc385/submissions/61029897

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        x--;
        y--;

        char[][] ggg = new char[h][w];
        for (int i = 0; i < h; i++) {
            ggg[i] = sc.next().toCharArray();
        }

        char[] t = sc.next().toCharArray();

        int cnt = 0;

        for (int i = 0; i < t.length; i++) {
            if (t[i] == 'U') {
                if (ggg[x - 1][y] == '@') {
                    ggg[x - 1][y] = '.';
                    cnt++;
                    x--;
                } else if (ggg[x - 1][y] == '.') {
                    x--;
                }

            } else if (t[i] == 'D') {
                if (ggg[x + 1][y] == '@') {
                    ggg[x + 1][y] = '.';
                    cnt++;
                    x++;
                } else if (ggg[x + 1][y] == '.') {
                    x++;
                }
            } else if (t[i] == 'L') {
                if (ggg[x][y - 1] == '@') {
                    ggg[x][y - 1] = '.';
                    cnt++;
                    y--;
                } else if (ggg[x][y - 1] == '.') {
                    y--;
                }

            } else if (t[i] == 'R') {
                if (ggg[x][y + 1] == '@') {
                    ggg[x][y + 1] = '.';
                    cnt++;
                    y++;
                } else if (ggg[x][y + 1] == '.') {
                    y++;
                }
            }
        }
        System.out.print((x + 1) + " " + (y + 1) + " " + cnt);

    }
//}

    @Test
    public void Case1() {

        String input = """
                       5 5 3 4
                       #####
                       #...#
                       #.@.#
                       #..@#
                       #####
                       LLLDRUU
                    """;

        String expected = """
                          2 3 1
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC385B.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       6 13 4 6
                       #############
                       #@@@@@@@@@@@#
                       #@@@@@@@@@@@#
                       #@@@@.@@@@@@#
                       #@@@@@@@@@@@#
                       #############
                       UURUURLRLUUDDURDURRR
                    """;

        String expected = """
                          3 11 11
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC385B.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       12 35 7 10
                       ###################################
                       #.................................#
                       #..........@......................#
                       #......@................@.........#
                       #.............##............@.....#
                       #...##........##....##............#
                       #...##........##....##.......##...#
                       #....##......##......##....##.....#
                       #....##......##......##..##.......#
                       #.....#######.........###.........#
                       #.................................#
                       ###################################
                       LRURRRUUDDULUDUUDLRLRDRRLULRRUDLDRU
                    """;

        String expected = """
                          4 14 1
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC385B.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC385B.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
