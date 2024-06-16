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
public class ABC327C {

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

        int[][] grid = new int[9][9];

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                grid[row][col] = sc.nextInt();
            }
        }

        boolean ok = true;

        long check = 1L;

        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {
                check *= grid[row][col];
            }

            ok &= check == 362880;
            check = 1L;

        }

        for (int col = 0; col < 9; col++) {

            for (int row = 0; row < 9; row++) {
                check *= grid[row][col];
            }

            ok &= check == 362880;
            check = 1L;

        }

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                check *= grid[row][col];
            }
        }
        ok &= check == 362880;

        check = 1L;
        for (int row = 0; row < 3; row++) {
            for (int col = 3; col < 6; col++) {
                check *= grid[row][col];
            }
        }
        ok &= check == 362880;

        check = 1L;
        for (int row = 0; row < 3; row++) {
            for (int col = 6; col < 9; col++) {
                check *= grid[row][col];
            }
        }
        ok &= check == 362880;

        ////////////
        check = 1L;
        for (int row = 3; row < 6; row++) {
            for (int col = 0; col < 3; col++) {
                check *= grid[row][col];
            }
        }
        ok &= check == 362880;

        check = 1L;
        for (int row = 3; row < 6; row++) {
            for (int col = 3; col < 6; col++) {
                check *= grid[row][col];
            }
        }
        ok &= check == 362880;

        check = 1L;
        for (int row = 3; row < 6; row++) {
            for (int col = 6; col < 9; col++) {
                check *= grid[row][col];
            }
        }
        ok &= check == 362880;

        ////////////
        check = 1L;
        for (int row = 6; row < 9; row++) {
            for (int col = 0; col < 3; col++) {
                check *= grid[row][col];
            }
        }
        ok &= check == 362880;

        check = 1L;
        for (int row = 6; row < 9; row++) {
            for (int col = 3; col < 6; col++) {
                check *= grid[row][col];
            }
        }
        ok &= check == 362880;

        check = 1L;
        for (int row = 6; row < 9; row++) {
            for (int col = 6; col < 9; col++) {
                check *= grid[row][col];
            }
        }
        ok &= check == 362880;

        String ret = ok ? "Yes" : "No";
        System.out.println(ret);
    }
//}

    //@Test
    public void Case1() {

        String input = """
                       1 2 3 4 5 6 7 8 9
                       4 5 6 7 8 9 1 2 3
                       7 8 9 1 2 3 4 5 6
                       2 3 4 5 6 7 8 9 1
                       5 6 7 8 9 1 2 3 4
                       8 9 1 2 3 4 5 6 7
                       3 4 5 6 7 8 9 1 2
                       6 7 8 9 1 2 3 4 5
                       9 1 2 3 4 5 6 7 8
                    """;

        String expected = """
                          Yes
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC327C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case2() {

        String input = """
                       1 2 3 4 5 6 7 8 9
                       2 3 4 5 6 7 8 9 1
                       3 4 5 6 7 8 9 1 2
                       4 5 6 7 8 9 1 2 3
                       5 6 7 8 9 1 2 3 4
                       6 7 8 9 1 2 3 4 5
                       7 8 9 1 2 3 4 5 6
                       8 9 1 2 3 4 5 6 7
                       9 1 2 3 4 5 6 7 8
                    """;

        String expected = """
                          No
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC327C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       1 2 3 4 5 6 7 8 9
                       4 5 6 7 8 9 1 2 3
                       7 8 9 1 2 3 4 5 6
                       1 2 3 4 5 6 7 8 9
                       4 5 6 7 8 9 1 2 3
                       7 8 9 1 2 3 4 5 6
                       1 2 3 4 5 6 7 8 9
                       4 5 6 7 8 9 1 2 3
                       7 8 9 1 2 3 4 5 6
                    """;

        String expected = """
                          No
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC327C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
