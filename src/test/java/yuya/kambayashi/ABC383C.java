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
public class ABC383C {

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

    // https://atcoder.jp/contests/abc383/submissions/60553959
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();
        int d = sc.nextInt();
        char[][] ch = new char[h][w];
        boolean[][] vis = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            ch[i] = sc.next().toCharArray();
        }

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (ch[i][j] == 'H') {
                    vis[i][j] = true;
                    q.add(new int[]{i, j, 0});
                }
            }
        }
        int[][] dr = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int i = temp[0];
            int j = temp[1];
            int d1 = temp[2];
            if (d1 == d) {
                continue;
            }
            for (int[] k : dr) {
                int ni = i + k[0];
                int nj = j + k[1];
                if (!(ni >= 0 && ni < h && nj >= 0 && nj < w)) {
                    continue;
                }
                if (vis[ni][nj] || ch[ni][nj] == '#') {
                    continue;
                }
                vis[ni][nj] = true;
                q.add(new int[]{ni, nj, d1 + 1});
            }
        }
        int ans = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (vis[i][j]) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
//}

    @Test
    public void Case1() {

        String input = """
                       3 4 1
                       H...
                       #..H
                       .#.#
                    """;

        String expected = """
                          5
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC383C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       5 6 2
                       ##...H
                       H.....
                       ..H.#.
                       .HH...
                       .###..
                    """;

        String expected = """
                          21
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC383C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       1 6 3
                       ...#..
                    """;

        String expected = """
                          0
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC383C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
    // @Test

    public void Case4() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC383C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
