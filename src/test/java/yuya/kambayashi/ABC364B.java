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
public class ABC364B {

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

        final int h = sc.nextInt();
        final int w = sc.nextInt();
        int row = sc.nextInt();
        int col = sc.nextInt();
        col--;
        row--;
        char[][] grid = new char[h][w];
        for (int i = 0; i < h; i++) {
            String s = sc.next();

            grid[i] = s.toCharArray();
        }
        String x = sc.next();

        for (int i = 0; i < x.length(); i++) {
            switch (x.charAt(i)) {
                case 'L':
                    if (col - 1 >= 0 && grid[row][col - 1] == '.') {
                        col--;
                    }
                    break;
                case 'R':
                    if (col + 1 < w && grid[row][col + 1] == '.') {
                        col++;
                    }
                    break;
                case 'U':
                    if (row - 1 >= 0 && grid[row - 1][col] == '.') {
                        row--;
                    }
                    break;
                case 'D':
                    if (row + 1 < h && grid[row + 1][col] == '.') {
                        row++;
                    }
                    break;
            }
        }
        System.out.print(row + 1);
        System.out.print(" ");
        System.out.print(col + 1);

    }
//}

    @Test
    public void Case1() {

        String input = """
                       2 3
                       2 1
                       .#.
                       ...
                       ULDRU
                    """;

        String expected = """
                          2 2
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC364B.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       4 4
                       4 2
                       ....
                       .#..
                       ...#
                       ....
                       DUUUURULRD
                    """;

        String expected = """
                          2 4
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC364B.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       6 6
                       1 1
                       .#####
                       ######
                       ######
                       ######
                       ######
                       ######
                       RURLDLULLRULRDL
                    """;

        String expected = """
                          1 1
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC364B.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC364B.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
