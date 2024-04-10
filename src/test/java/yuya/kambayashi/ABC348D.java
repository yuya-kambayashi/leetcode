/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yuya.kambayashi;

import java.util.*;
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
public class ABC348D {

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
    private static final int[][] directions
            = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int h = sc.nextInt();
        final int w = sc.nextInt();
        String[] sa = new String[h];
        for (int i = 0; i < h; i++) {
            sa[i] = sc.next();
        }

        final int n = sc.nextInt();
        int[][] rce = new int[n][3];
        for (int i = 0; i < n; i++) {
            rce[i][0] = sc.nextInt() - 1;
            rce[i][1] = sc.nextInt() - 1;
            rce[i][2] = sc.nextInt();
        }

        char[][] grid = new char[h][w];
        int sx = 0, sy = 0, tx = 0, ty = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                char c = sa[i].charAt(j);
                grid[i][j] = c;

                if (c == 'S') {
                    sx = i;
                    sy = j;
                }
                if (c == 'T') {
                    tx = i;
                    ty = j;
                }

            }
        }

        // スタート地点のエネルギー
        // int es = getEnegy(rce, sx, sy);
        //var points = getReachPoints(sx, sy, es, grid);
        // Set up the BFS.
        //int es = getEnegy(rce, sx, sy);
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{sx, sy, 0}); // Put distance on the queue
        boolean[][] visited = new boolean[grid.length][grid[0].length]; // Used as visited set.
        visited[sx][sy] = true;

        // Carry out the BFS
        while (!queue.isEmpty()) {
            int[] cell = queue.remove();
            int row = cell[0];
            int col = cell[1];
            int ene = cell[2];

            int t = getEnegy(rce, row, col);
            if (t != -1 && ene < t) {
                ene = t;
                rce[row][col] = 0;
            }
            if (ene <= 0) {
                continue;
            }

            // Check if this is the target cell.
            if (grid[row][col] == 'T') {
                System.out.println("Yes");
                return;
            }

            var points = getReachPoints(row, col, grid);
            for (int[] neighbour : points) {
                int neighbourRow = neighbour[0];
                int neighbourCol = neighbour[1];
                if (visited[neighbourRow][neighbourCol]) {
                    continue;
                }
                visited[neighbourRow][neighbourCol] = true;
                queue.add(new int[]{neighbourRow, neighbourCol, ene - 1});
            }
        }

        System.out.println("No");
    }

    static private int getEnegy(int[][] rce, int row, int col) {

        for (int i = 0; i < rce.length; i++) {
            int[] t = rce[i];
            if (t[0] == row && t[1] == col) {
                return t[2];
            }
        }
        return -1;
    }

    static private List<int[]> getReachPoints(int row, int col, char[][] grid) {
        List<int[]> reachPoints = new ArrayList<>();

        for (int i = 0; i < directions.length; i++) {

            int newRow = row + directions[i][0];
            int newCol = col + directions[i][1];

            if (newRow < 0 || newCol < 0 || newRow >= grid.length
                    || newCol >= grid[0].length
                    || grid[newRow][newCol] != '.') {
                continue;
            }
            reachPoints.add(new int[]{newRow, newCol});
        }
        return reachPoints;
    }
//}

    @Test
    public void Case1() {
        in.inputln("4 4");
        in.inputln("S...");
        in.inputln("#..#");
        in.inputln("#...");
        in.inputln("..#T");
        in.inputln("4");
        in.inputln("1 1 3");
        in.inputln("1 3 5");
        in.inputln("3 2 1");
        in.inputln("2 3 1");
        var expected = "Yes";

        ABC348D.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

    //  @Test
    public void Case2() {

        in.inputln("");
        var expected = "";

        ABC348D.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

    // @Test
    public void Case3() {

        in.inputln("");
        var expected = "";

        ABC348D.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }
}

//import java.util.*;
//public class Main {
