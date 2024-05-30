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
public class ABC284C {

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
        final int m = sc.nextInt();
        int[] uu = new int[m];
        int[] vv = new int[m];
        List<Graph> graphs = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int u1 = sc.nextInt();
            int v1 = sc.nextInt();
            graphs.add(new Graph(u1, v1, i + 1));
        }
        Collections.sort(graphs, Comparator.comparingInt(Graph::getV1));

        int cnt = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                if (graphs.get(i).isConnect(graphs.get(j))) {
                    set.add(i);
                    set.add(j);
                }
            }
        }

        System.out.println(set.size());
    }

    static class Graph {

        int v1;
        int v2;
        int e;

        Graph(int v1, int v2, int e) {
            this.v1 = Math.min(v1, v2);
            this.v2 = Math.max(v1, v2);
            this.e = e;
        }

        public int getV1() {
            return v1;
        }

        public boolean isConnect(Graph other) {
            if (this.v1 == other.v1 || this.v1 == other.v2) {
                return true;
            }
            if (this.v2 == other.v1 || this.v2 == other.v2) {
                return true;
            }
            return false;
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                       5 3
1 2
1 3
4 5
                    """;

        String expected = """
                          2
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC284C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       5 0
                    """;

        String expected = """
                          5
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC284C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       4 6
1 2
1 3
1 4
2 3
2 4
3 4
                    """;

        String expected = """
                          1
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC284C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }
}
