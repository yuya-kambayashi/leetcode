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
public class ABC305C {

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

        final int height = sc.nextInt();
        final int width = sc.nextInt();
        char[][] grid = new char[height][width];
        for (int i = 0; i < height; i++) {
            String s = sc.next();

            int col = 0;
            for (char c : s.toCharArray()) {
                grid[i][col] = c;
                col++;
            }
        }

        int colMin = Integer.MAX_VALUE, colMax = Integer.MIN_VALUE, rowMin = Integer.MAX_VALUE, rowMax = Integer.MIN_VALUE;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                if (grid[i][j] == '#') {
                    colMin = Math.min(colMin, j);
                    colMax = Math.max(colMax, j);
                    rowMin = Math.min(rowMin, i);
                    rowMax = Math.max(rowMax, i);
                }

            }
        }

        for (int i = rowMin; i <= rowMax; i++) {
            for (int j = colMin; j <= colMax; j++) {

                if (grid[i][j] == '.') {

                    System.out.println(String.valueOf(i + 1) + " " + String.valueOf(j + 1));
                    return;
                }
            }
        }

    }
//}

    @Test
    public void Case1() {

        String input = """
                       5 6
                       ......
                       ..#.#.
                       ..###.
                       ..###.
                       ......
                    """;

        String expected = """
                          2 4
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC305C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       3 2
                       #.
                       ##
                       ##
                    """;

        String expected = """
                          1 2
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC305C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                      6 6
                       ..####
                       ..##.#
                       ..####
                       ..####
                       ..####
                       ...... 
                    """;

        String expected = """
                          2 5
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC305C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
