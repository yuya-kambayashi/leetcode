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
public class ABC265C {

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
    static int row, col;
    static char[][] grid;
    static boolean[][] visited;

    static int lastRow = -1;
    static int lastCol = -1;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        row = sc.nextInt();
        col = sc.nextInt();
        grid = new char[row][col];
        visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            String s = sc.next();

            for (int j = 0; j < col; j++) {
                grid[i][j] = s.charAt(j);
            }
        }
        move(0, 0);

        if (lastRow == -1 && lastCol == -1) {
            System.out.print(-1);
        } else {
            System.out.print(lastRow);
            System.out.print(" ");
            System.out.print(lastCol);
        }
    }

    static void move(int r, int c) {

        if (r < 0 || row <= r) {
            return;
        }
        if (c < 0 || col <= c) {
            return;
        }
        if (visited[r][c]) {
            lastRow = -1;
            lastCol = -1;
            return;
        }

        lastRow = r + 1;
        lastCol = c + 1;

        visited[r][c] = true;

        switch (grid[r][c]) {
            case 'U':
                move(r - 1, c);
                break;
            case 'D':
                move(r + 1, c);
                break;

            case 'L':
                move(r, c - 1);
                break;

            case 'R':
                move(r, c + 1);
                break;
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                       2 3
                       RDU
                       LRU
                    """;

        String expected = """
                          1 3
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC265C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       2 3
                       RRD
                       ULL
                    """;

        String expected = """
                          -1
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC265C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       9 44
                       RRDDDDRRRDDDRRRRRRDDDRDDDDRDDRDDDDDDRRDRRRRR
                       RRRDLRDRDLLLLRDRRLLLDDRDLLLRDDDLLLDRRLLLLLDD
                       DRDLRLDRDLRDRLDRLRDDLDDLRDRLDRLDDRLRRLRRRDRR
                       DDLRRDLDDLDDRLDDLDRDDRDDDDRLRRLRDDRRRLDRDRDD
                       RDLRRDLRDLLLLRRDLRDRRDRRRDLRDDLLLLDDDLLLLRDR
                       RDLLLLLRDLRDRLDDLDDRDRRDRLDRRRLDDDLDDDRDDLDR
                       RDLRRDLDDLRDRLRDLDDDLDDRLDRDRDLDRDLDDLRRDLRR
                       RDLDRRLDRLLLLDRDRLLLRDDLLLLLRDRLLLRRRRLLLDDR
                       RRRRDRDDRRRDDRDDDRRRDRDRDRDRRRRRRDDDRDDDDRRR
                    """;

        String expected = """
                          9 5
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC265C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
