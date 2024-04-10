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
public class ABC348B {

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        int[][] zaa = new int[n][2];
        for (int i = 0; i < n; i++) {
            zaa[i][0] = sc.nextInt();
            zaa[i][1] = sc.nextInt();
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {

            int[] za1 = zaa[i];

            double max = 0.0;
            int maxi = 0;

            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                int[] za2 = zaa[j];

                double dist = Math.sqrt(Math.pow(za1[0] - za2[0], 2) + Math.pow(za1[1] - za2[1], 2));

                if (dist > max) {
                    max = dist;
                    maxi = j;
                }
            }
            sb.append(maxi + 1);
            if (i != n - 1) {
                sb.append(" ");
            }
        }

        System.out.println(sb.toString());

    }
//}

    @Test
    public void Case1() {

        in.inputln("4");
        in.inputln("0 0");
        in.inputln("2 4");
        in.inputln("5 0");
        in.inputln("3 4");
        var expected = "3 3 1 1";

        ABC348B.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void Case2() {
        in.inputln("6");
        in.inputln("3 2");
        in.inputln("1 6");
        in.inputln("4 5");
        in.inputln("1 3");
        in.inputln("5 5");
        in.inputln("9 8");
        var expected = "6 6 6 6 6 4";

        ABC348B.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

    // @Test
    public void Case3() {

        in.inputln("");
        var expected = "";

        ABC348B.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }
}

//import java.util.*;
//public class Main {
class Solution {

    private static final int[][] directions
            = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {

        // Firstly, we need to check that the start and target cells are open.
        if (grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0) {
            return -1;
        }

        // Set up the BFS.
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 1}); // Put distance on the queue
        boolean[][] visited = new boolean[grid.length][grid[0].length]; // Used as visited set.
        visited[0][0] = true;

        // Carry out the BFS
        while (!queue.isEmpty()) {
            int[] cell = queue.remove();
            int row = cell[0];
            int col = cell[1];
            int distance = cell[2];
            // Check if this is the target cell.
            if (row == grid.length - 1 && col == grid[0].length - 1) {
                return distance;
            }
            for (int[] neighbour : getNeighbours(row, col, grid)) {
                int neighbourRow = neighbour[0];
                int neighbourCol = neighbour[1];
                if (visited[neighbourRow][neighbourCol]) {
                    continue;
                }
                visited[neighbourRow][neighbourCol] = true;
                queue.add(new int[]{neighbourRow, neighbourCol, distance + 1});
            }
        }

        // The target was unreachable.
        return -1;
    }

    private List<int[]> getNeighbours(int row, int col, int[][] grid) {
        List<int[]> neighbours = new ArrayList<>();
        for (int i = 0; i < directions.length; i++) {
            int newRow = row + directions[i][0];
            int newCol = col + directions[i][1];
            if (newRow < 0 || newCol < 0 || newRow >= grid.length
                    || newCol >= grid[0].length
                    || grid[newRow][newCol] != 0) {
                continue;
            }
            neighbours.add(new int[]{newRow, newCol});
        }
        return neighbours;
    }

}
