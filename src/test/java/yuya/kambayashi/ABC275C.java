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
public class ABC275C {

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = 9;
        char[][] grid = new char[n][n];
        List<Coord> cc = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            grid[i] = s.toCharArray();

            for (int j = 0; j < s.length(); j++) {

                if (grid[i][j] == '#') {
                    cc.add(new Coord(i, j));
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < cc.size(); i++) {
            for (int j = i + 1; j < cc.size(); j++) {
                for (int k = j + 1; k < cc.size(); k++) {
                    for (int l = k + 1; l < cc.size(); l++) {
                        if (isSquare(cc.get(i), cc.get(j), cc.get(k), cc.get(l))) {
                            ans++;
                        }
                    }
                }
            }
        }

        System.out.println(ans);

    }

    static class Coord {

        int row, col;

        Coord(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static boolean isSquare(Coord c1, Coord c2, Coord c3, Coord c4) {

        List<Double> dd = new ArrayList<>();
        dd.add(Math.pow(c1.row - c2.row, 2) + Math.pow(c1.col - c2.col, 2));
        dd.add(Math.pow(c1.row - c3.row, 2) + Math.pow(c1.col - c3.col, 2));
        dd.add(Math.pow(c1.row - c4.row, 2) + Math.pow(c1.col - c4.col, 2));
        dd.add(Math.pow(c2.row - c3.row, 2) + Math.pow(c2.col - c3.col, 2));
        dd.add(Math.pow(c2.row - c4.row, 2) + Math.pow(c2.col - c4.col, 2));
        dd.add(Math.pow(c3.row - c4.row, 2) + Math.pow(c3.col - c4.col, 2));
        Collections.sort(dd);

        double d = dd.get(0);

        if (d < 0.01) {
            return false;
        }
        return d == dd.get(1) && d == dd.get(2) && d == dd.get(3) && 2 * d == dd.get(4) && 2 * d == dd.get(5);

    }
//}

    @Test
    public void Case1() {

        String input = """
                       ##.......
##.......
.........
.......#.
.....#...
........#
......#..
.........
.........
                    """;

        String expected = """
                          2
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC275C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       .#.......
#.#......
.#.......
.........
....#.#.#
.........
....#.#.#
........#
.........
                    """;

        String expected = """
                          3
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC275C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
    //@Test

    public void Case3() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC275C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC275C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
