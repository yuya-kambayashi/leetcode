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
public class ABC370D {

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
        final int q = sc.nextInt();

        boolean[][] grid = new boolean[h][w];
        int remainingWalls = h * w;
        for (int i = 0; i < h; i++) {
            Arrays.fill(grid[i], true);
        }

        for (int qi = 0; qi < q; qi++) {
            int R = sc.nextInt() - 1;
            int C = sc.nextInt() - 1;
            if (grid[R][C]) {
                // 壁がある場合、その壁を破壊
                grid[R][C] = false;
                remainingWalls--;
            } else {
                // 壁がない場合は上下左右の壁を探す処理を行う
                // 上方向を探す
                for (int i = R - 1; i >= 0; i--) {
                    if (grid[i][C]) {
                        grid[i][C] = false;
                        remainingWalls--;
                        break;
                    }
                }
                // 下方向を探す
                for (int i = R + 1; i < h; i++) {
                    if (grid[i][C]) {
                        grid[i][C] = false;
                        remainingWalls--;

                        break;
                    }
                }
                // 左方向を探す
                for (int j = C - 1; j >= 0; j--) {
                    if (grid[R][j]) {
                        grid[R][j] = false;
                        remainingWalls--;

                        break;
                    }
                }

                // 右方向を探す
                for (int j = C + 1; j < w; j++) {
                    if (grid[R][j]) {
                        grid[R][j] = false;
                        remainingWalls--;

                        break;
                    }
                }
            }
        }
        System.out.println(remainingWalls);
    }
//}

    @Test
    public void Case1() {

        String input = """
                       2 4 3
                       1 2
                       1 2
                       1 3
                    """;

        String expected = """
                          2
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC370D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test

    public void Case2() {

        String input = """
                       5 5 5
                       3 3
                       3 3
                       3 2
                       2 2
                       1 2
                    """;

        String expected = """
                          10
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC370D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       4 3 10
                       2 2
                       4 1
                       1 1
                       4 2
                       2 1
                       3 1
                       1 3
                       1 2
                       4 3
                       4 2
                    """;

        String expected = """
                          2
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC370D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
    // @Test

    public void Case4() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC370D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
