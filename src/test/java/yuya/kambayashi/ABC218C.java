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

            if (deepEqual(sss, ttt)) {
                System.out.println("Yes");
                return;
            }
            sss = rotate(sss);
        }
        System.out.println("No");
    }

    static boolean deepEqual(char[][] a, char[][] b) {

        char[][] c = normalize(a);
        char[][] d = normalize(b);

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (c[i][j] != d[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    static char[][] normalize(char[][] a) {
        int n = a.length;
        int minr = a.length, minc = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == '#') {
                    minr = Math.min(minr, i);
                    minc = Math.min(minc, j);
                }
            }
        }
        char[][] b = new char[a.length][a[0].length];
        for (int i = 0; i < n; i++) {
            Arrays.fill(b[i], '.');
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == '#') {
                    b[i - minr][j - minc] = '#';
                }
            }
        }
        return b;
    }

    static char[][] rotate(char[][] a) {
        int n = a.length;
        char[][] b = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                b[j][n - 1 - i] = a[i][j];
            }
        }
        return b;
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
