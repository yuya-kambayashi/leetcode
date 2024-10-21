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
public class ABC376D {

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

    static class Graph {

        int N;  // 頂点数
        List<List<Integer>> adj;  // 隣接リスト

        public Graph(int N) {
            this.N = N;
            adj = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                adj.add(new ArrayList<>());
            }
        }

        public void addEdge(int u, int v) {
            adj.get(u).add(v);  // 頂点uから頂点vへの辺を追加
        }

        public int findShortestCycleFromNode1() {
            // BFSによって閉路を探索する
            Queue<int[]> queue = new LinkedList<>();
            int[] dist = new int[N];
            Arrays.fill(dist, -1);  // 全ての頂点の初期距離を-1に設定
            dist[0] = 0;  // 頂点1の距離を0に設定
            queue.offer(new int[]{0, -1});  // 頂点1から探索開始、親はなし

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int node = current[0];
                int parent = current[1];

                for (int neighbor : adj.get(node)) {
                    if (dist[neighbor] == -1) {
                        // 未訪問の場合は訪問し、距離を更新
                        dist[neighbor] = dist[node] + 1;
                        queue.offer(new int[]{neighbor, node});
                    } else if (neighbor == 0 && parent != -1) {
                        // 閉路が見つかった場合
                        return dist[node] + 1;  // 閉路の辺数を返す
                    }
                }
            }
            return -1;  // 閉路が存在しない場合
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        Graph graph = new Graph(N);

        // 入力からグラフの辺を追加
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            graph.addEdge(a, b);
        }

        // 頂点1（インデックス0）を含む最短閉路の辺数を探索
        int result = graph.findShortestCycleFromNode1();
        System.out.println(result);
    }
//}

    @Test
    public void Case1() {

        String input = """
                       3 3
                       1 2
                       2 3
                       3 1
                    """;

        String expected = """
                          3
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC376D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       3 2
                       1 2
                       2 3
                    """;

        String expected = """
                          -1
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC376D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       6 9
                       6 1
                       1 5
                       2 6
                       2 1
                       3 6
                       4 2
                       6 4
                       3 5
                       5 4
                    """;

        String expected = """
                          4
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC376D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC376D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
