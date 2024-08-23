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
public class ABC218C {

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

        final int n = sc.nextInt();
        char[][] sss = new char[n][n];
        char[][] ttt = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            sss[i] = s.toCharArray();
        }
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            ttt[i] = s.toCharArray();
        }

        for (int i = 0; i < 4; i++) {
            if (deepEquals(sss, ttt)) {
                System.out.println("Yes");
                return;
            }
            sss = rotate(sss);

        }
        System.out.println("No");
    }

    public static boolean deepEquals(char[][] c, char[][] d) {
        int n = c.length;
        boolean res = true;

        c = normalize(c);
        d = normalize(d);
        for (int i = 0; i < n; i++) {
            if (!Arrays.equals(c[i], d[i])) {
                return false;
            }
        }

        return true;
    }

    static char[][] rotate(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        char[][] rotatedMatrix = new char[m][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rotatedMatrix[j][n - 1 - i] = matrix[i][j];
            }
        }

        return rotatedMatrix;
    }

    static char[][] normalize(char[][] aaa) {

        int n = aaa.length;

        int minr = n, minc = n;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (aaa[i][j] == '#') {
                    minr = Math.min(minr, i);
                    minc = Math.min(minc, j);
                }
            }
        }
        char[][] nnn = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(nnn[i], '.');
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (aaa[i][j] == '#') {
                    nnn[i - minr][j - minc] = '#';
                }
            }
        }
        return nnn;
    }

//}
    @Test
    public void Case0() {

        String input = """
                       3
.##
...
...
#..
#..
...
                    """;

        String expected = """
                          Yes
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC218C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case1() {

        String input = """
                       5
.....
..#..
.###.
.....
.....
.....
.....
....#
...##
....#
                    """;

        String expected = """
                          Yes
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC218C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       5
#####
##..#
#..##
#####
.....
#####
#..##
##..#
#####
.....
                    """;

        String expected = """
                          No
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC218C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       4
#...
..#.
..#.
....
#...
#...
..#.
....
                    """;

        String expected = """
                          Yes
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC218C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
    // @Test

    public void Case4() {

        String input = """
                       4
#...
.##.
..#.
....
##..
#...
..#.
....
                    """;

        String expected = """
                          No
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC218C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
