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
public class JOI2009YOD {

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
//import java.util.*;
//import java.util.stream.Collectors;
//public class Main {

    static char[][] grid;
    static int row, col;

    static int maxDepth = 0;

    static void delete(int r, int c, int depth) {
        // 対象のセルを割る
        grid[r][c] = '*';

        // 対象のセルが最上段でない場合、上方向のセルをチェックする
        if (r > 0) {
            if (grid[r - 1][c] == '@') {
                delete(r - 1, c, depth + 1);
            }
        }

        // 対象のセルが最下段でない場合、下方向のセルをチェックする
        if (r < row - 1) {
            if (grid[r + 1][c] == '@') {
                delete(r + 1, c, depth + 1);
            }
        }
        // 対象のセルが左端でない場合、左方向のセルをチェックする
        if (c > 0) {
            if (grid[r][c - 1] == '@') {
                delete(r, c - 1, depth + 1);
            }
        }
        // 対象のセルが右端でない場合、右方向のセルをチェックする
        if (c < col - 1) {
            if (grid[r][c + 1] == '@') {
                delete(r, c + 1, depth + 1);
            }
        }
        grid[r][c] = '@';

        maxDepth = Math.max(maxDepth, depth);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        row = sc.nextInt();
        col = sc.nextInt();

        grid = new char[row][col];

        maxDepth = 0;

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                grid[r][c] = sc.nextInt() == 1 ? '@' : '*';
            }
        }

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (grid[r][c] == '@') {
                    delete(r, c, 1);
                }
            }
        }

        System.out.println(maxDepth);
    }

//}
    @Test
    public void Case1() {

        String input = """
                       3
                       3
                       1 1 0
                       1 0 1
                       1 1 0
                    """;

        String expected = """
                          5
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        JOI2009YOD.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       5
                       3
                       1 1 1 0 1
                       1 1 0 0 0
                       1 0 0 0 1
                    """;

        String expected = """
                          5
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        JOI2009YOD.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       10
                       10
                       1 1 0 0 0 1 0 0 1 1
                       1 0 0 0 1 1 1 1 0 0
                       0 0 0 0 0 0 0 0 0 0
                       1 0 0 0 1 1 0 1 0 1
                       0 0 1 1 0 0 0 1 1 1
                       0 1 1 0 1 0 1 0 0 0
                       0 1 1 1 0 0 0 1 1 0
                       1 0 1 0 1 1 0 1 1 0
                       0 0 0 1 0 0 1 0 0 0
                       0 0 0 0 0 1 0 0 1 1
                    """;

        String expected = """
                          7
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        JOI2009YOD.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }
}

//import java.util.*;
//public class Main {
