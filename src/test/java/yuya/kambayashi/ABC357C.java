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
public class ABC357C {

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        int m = (int) Math.pow(3, n);
        grid = new char[m][m];
        for (int i = 0; i < m; i++) {
            char[] g = grid[i];
            Arrays.fill(g, '#');
        }
        for (int i = 0; i < n; i++) {
            int min = 0;

            int diff = (int) Math.pow(3, n - i);
            List<Integer> is = new ArrayList<>();
            is.add(0);
            int before = 0;
            while (true) {
                int t = before + diff;
                if (t > m) {
                    break;
                } else {
                    is.add(t);
                    before = t;
                }
            }
            int srow = 0, erow = 0, scol = 0, ecol = 0;
            for (int row = 1; row < is.size(); row++) {
                erow = is.get(row);
                for (int col = 1; col < is.size(); col++) {
                    ecol = is.get(col);
                    mark(srow, erow, scol, ecol);
                    scol = ecol;
                }
                srow = erow;
                scol = 0;
            }
        }

        for (var g : grid) {
            String ss = String.valueOf(g);
            System.out.println(ss);

        }

    }

    static public void mark(int srow, int erow, int scol, int ecol) {
        int len = (erow - srow) / 3;
        for (int i = srow + len; i < srow + 2 * len; i++) {
            for (int j = scol + len; j < scol + 2 * len; j++) {
                grid[i][j] = '.';
            }
        }
    }

    //}
    @Test
    public void Case1() {

        String input = """
                       1
                    """;

        String expected = """
                          ###
                          #.#
                          ###
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC357C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       2
                    """;

        String expected = """
                          #########
                          #.##.##.#
                          #########
                          ###...###
                          #.#...#.#
                          ###...###
                          #########
                          #.##.##.#
                          #########
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC357C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case3() {

        String input = """
                       3
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC357C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
