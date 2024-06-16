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
public class ALDS1_11_B {

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

    static int N = 100;

    static int[][] Graph;
    // 頂点を発見した時刻
    static int[] d;
    // 頂点の探索を終えた時刻
    static int[] f;
    // かかった時間
    static int dTime;
    // 頂点を発見したかのフラグ
    static boolean[] visited;

    public static void visit(int i, int max) {
        visited[i] = true;
        d[i] = ++dTime;
        for (int j = 0; j < max; ++j) {
            if (Graph[i][j] == 1 && !visited[j]) {
                visit(j, max);
            }
        }
        // すべての頂点の探索が終了した
        f[i] = ++dTime;
    }

    public static void main(String[] args) {

        Graph = new int[N][N];
        d = new int[N];
        f = new int[N];
        dTime = 0;
        visited = new boolean[N];

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            int u = sc.nextInt();
            int k = sc.nextInt();

            // 頂点を移動する
            u--;

            // 頂点の数だけ回す
            for (int j = 0; j < k; j++) {
                int v = sc.nextInt();
                v--;
                Graph[u][v] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visit(i, n);
            }
        }

        for (int i = 0; i < n; i++) {
            String result = String.valueOf(i + 1) + " " + d[i] + " " + f[i];
            System.out.println(result);
        }
    }

//}
    //@Test
    public void Case1() {

        String input = """
                       4
                       1 1 2
                       2 1 4
                       3 0
                       4 1 3
                    """;

        String expected = """
                          1 1 8
                          2 2 7
                          3 4 5
                          4 3 6
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ALDS1_11_B.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       6
                       1 2 2 3
                       2 2 3 4
                       3 1 5
                       4 1 6
                       5 1 6
                       6 0
                    """;

        String expected = """
                          1 1 12
                          2 2 11
                          3 3 8
                          4 9 10
                          5 4 7
                          6 5 6
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ALDS1_11_B.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ALDS1_11_B.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}

//import java.util.*;
//public class Main {
