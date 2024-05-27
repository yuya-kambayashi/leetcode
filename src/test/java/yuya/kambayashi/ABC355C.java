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
public class ABC355C {

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

    static int[][] grid;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        final int t = sc.nextInt();
        int[] aa = new int[t];
        for (int i = 0; i < t; i++) {
            aa[i] = sc.nextInt();
        }

        grid = new int[n][n];

        for (int i = 0; i < t; i++) {
            int a = aa[i];
            a--;

            int row = a / n;
            int col = a % n;

            if (grid[row][col] == 1) {
                continue;
            }

            grid[row][col] = 1;

            if (isBingo(row, col)) {
                System.out.println(i + 1);
                return;

            }

        }

        System.out.println(-1);
    }

    public static boolean isBingo(int changedRow, int changedCol) {

        // 行
        boolean rowBingo = true;
        for (int col = 0; col < n; col++) {
            if (grid[changedRow][col] == 0) {
                rowBingo = false;
                break;
            }
        }
        if (rowBingo) {
            return true;
        }

        // 列
        boolean colBingo = true;
        for (int row = 0; row < n; row++) {
            if (grid[row][changedCol] == 0) {
                colBingo = false;
                break;
            }
        }
        if (colBingo) {
            return true;
        }

        if (changedRow == changedCol) {
            // 斜め（左上から右下）
            boolean diaBingo1 = true;
            for (int row = 0; row < n; row++) {
                if (grid[row][row] == 0) {
                    diaBingo1 = false;
                    break;
                }
            }
            if (diaBingo1) {
                return true;
            }
        }
        if (n - 1 - changedRow == changedCol) {
            boolean diaBingo2 = true;
            int col = n - 1;
            for (int row = 0; row < n; row++) {
                if (grid[row][col] == 0) {
                    diaBingo2 = false;
                    break;
                }
                col--;
            }
            if (diaBingo2) {
                return true;
            }
        }
        return false;
    }
//}

    @Test
    public void Case1() {

        String input = """
                       3 5
                       5 1 8 9 7
                    """;

        String expected = """
                          4
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC355C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       3 5
                       4 2 9 7 5
                    """;

        String expected = """
                          -1
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC355C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       4 12
                       13 9 6 5 2 7 16 14 8 3 10 11
                    """;

        String expected = """
                          9
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC355C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }
}
