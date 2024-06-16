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
public class ABC088D {

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
//import java.util.*;
//import java.util.stream.Collectors;
//public class Main {

    static class Pair {

        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int W = sc.nextInt();
        sc.nextLine();
        String[] fi = new String[110];

        int wnum = 0;

        for (int i = 0; i < H; i++) {
            fi[i] = sc.nextLine();
            for (int j = 0; j < W; j++) {
                if (fi[i].charAt(j) == '.') {
                    wnum++;
                }
            }
        }

        int[][] dist = new int[110][110];
        for (int[] row : dist) {
            Arrays.fill(row, -1);
        }

        Queue<Pair> que = new LinkedList<>();
        dist[0][0] = 1;
        que.add(new Pair(0, 0));
        while (!que.isEmpty()) {
            Pair cur = que.poll();
            int x = cur.first;
            int y = cur.second;
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || nx >= H || ny < 0 || ny >= W) {
                    continue;
                }
                if (fi[nx].charAt(ny) == '#') {
                    continue;
                }
                if (dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[x][y] + 1;
                    que.add(new Pair(nx, ny));
                }
            }
        }
        if (dist[H - 1][W - 1] == -1) {
            System.out.println(-1);
        } else {

            System.out.println(wnum - dist[H - 1][W - 1]);
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                       3 3
                       ..#
                       #..
                       ...
                    """;

        String expected = """
                          2
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC088D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       10 37
                       .....................................
                       ...#...####...####..###...###...###..
                       ..#.#..#...#.##....#...#.#...#.#...#.
                       ..#.#..#...#.#.....#...#.#...#.#...#.
                       .#...#.#..##.#.....#...#.#.###.#.###.
                       .#####.####..#.....#...#..##....##...
                       .#...#.#...#.#.....#...#.#...#.#...#.
                       .#...#.#...#.##....#...#.#...#.#...#.
                       .#...#.####...####..###...###...###..
                       .....................................
                    """;

        String expected = """
                          209
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC088D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC088D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}

//import java.util.*;
//public class Main {
