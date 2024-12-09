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
public class ABC383B {

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
        final int d = sc.nextInt();
        String[] ss = new String[h];
        char[][] grid = new char[h][w];
        for (int i = 0; i < h; i++) {
            grid[i] = sc.next().toCharArray();
        }

        List<int[]> floor = new ArrayList<>();
        List<int[]> desk = new ArrayList<>();
        for (int row = 0; row < h; row++) {
            for (int col = 0; col < w; col++) {
                if (grid[row][col] == '.') {
                    int[] pp = {row, col};

                    floor.add(pp);
                } else {
                    int[] pp = {row, col};

                    desk.add(pp);
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < floor.size(); i++) {
            for (int j = i + 1; j < floor.size(); j++) {
                int[] ii = floor.get(i);
                int[] jj = floor.get(j);

                int anst = 0;
                for (int k = 0; k < floor.size(); k++) {

                    if (i == k || j == k) {
                        anst++;
                        continue;
                    }

                    int[] kk = floor.get(k);

                    int m1 = Math.abs(kk[0] - ii[0]) + Math.abs(kk[1] - ii[1]);
                    int m2 = Math.abs(kk[0] - jj[0]) + Math.abs(kk[1] - jj[1]);
                    if (m1 <= d) {
                        anst++;
                    } else if (m2 <= d) {
                        anst++;
                    }
                }

                ans = Math.max(ans, anst);

            }
        }

        System.out.println(ans);
    }
//}

    // @Test
    public void Case1() {

        String input = """
                      2 5 1
                       .###.
                       .#.## 
                    """;

        String expected = """
                          3
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC383B.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       5 5 2
                       .#.#.
                       .....
                       .#.#.
                       #.#.#
                       .....
                    """;

        String expected = """
                          15
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC383B.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       4 4 2
                       ....
                       .##.
                       .##.
                       ....
                    """;

        String expected = """
                          10
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC383B.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC383B.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
