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
        int cntS = 0;

        for (int i = 0; i < n; i++) {
            String t = sc.next();
            sss[i] = t.toCharArray();
            for (int j = 0; j < n; j++) {
                if (t.charAt(j) == '#') {
                    cntS++;
                }
            }
        }
        int cntT = 0;

        for (int i = 0; i < n; i++) {
            String t = sc.next();
            ttt[i] = t.toCharArray();
            for (int j = 0; j < n; j++) {
                if (t.charAt(j) == '#') {
                    cntT++;
                }
            }
        }

        for (int si = -n + 1; si < 2 * n; si++) {
            for (int sj = -n + 1; sj < 2 * n; sj++) {
                char[][] nnn = new char[n][n];
                for (int i = 0; i < n; i++) {
                    Arrays.fill(nnn[i], '.');
                }

                int cntN = 0;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        int ni = i + si;
                        int nj = j + sj;

                        if (0 <= ni && ni < n && 0 <= nj && nj < n) {
                            nnn[ni][nj] = sss[i][j];
                            if (nnn[ni][nj] == '#') {
                                cntN++;
                            }
                        }
                    }
                }
                if (cntN != cntS || cntT != cntN) {
                    continue;
                }
                if (deepEquals(nnn, ttt)) {
                    System.out.println("Yes");
                    return;
                }
                nnn = rotateMatrix90Degrees(nnn);
                if (deepEquals(nnn, ttt)) {
                    System.out.println("Yes");
                    return;
                }
                nnn = rotateMatrix90Degrees(nnn);
                if (deepEquals(nnn, ttt)) {
                    System.out.println("Yes");
                    return;
                }
                nnn = rotateMatrix90Degrees(nnn);
                if (deepEquals(nnn, ttt)) {
                    System.out.println("Yes");
                    return;
                }
            }
        }

        System.out.println("No");
    }

    public static boolean deepEquals(char[][] aa, char[][] bb) {

        if (aa.length != bb.length) {
            return false;
        }
        for (int i = 0; i < aa.length; i++) {
            for (int j = 0; j < aa[i].length; j++) {
                if (aa[i][j] != bb[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static char[][] rotateMatrix90Degrees(char[][] matrix) {
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
//}

    @Test
    public void Case0() {

        String input = """
                       3
.##
...
...
...
...
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
