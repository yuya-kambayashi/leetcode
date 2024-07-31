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
public class ABC270C {

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

    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> gg;
    static ArrayList<Integer> tlist;
    static int destination;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final int x = sc.nextInt() - 1;
        final int y = sc.nextInt() - 1;
        destination = y;

        gg = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            gg.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            u--;
            v--;
            gg.get(u).add(v);
            gg.get(v).add(u);
        }
        visited = new boolean[n];
        tlist = new ArrayList<Integer>();
        dfs(x);
    }

    static boolean dfs(int cur) {
        visited[cur] = true;
        tlist.add(cur);
        if (cur == destination) {
            for (int i : tlist) {
                System.out.print(i + 1 + " ");
            }
            System.out.println();
            return true;
        } else {
            for (int next : gg.get(cur)) {
                if (!visited[next]) {
                    if (dfs(next)) {
                        return true;
                    }
                }
            }
        }
        tlist.remove(tlist.size() - 1);
        return false;

    }
    //}

    @Test
    public void Case1() {

        String input = """
                       5 2 5
1 2
1 3
3 4
3 5
                    """;

        String expected = """
                          2 1 3 5
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC270C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       6 1 2
3 1
2 5
1 2
4 1
2 6
                    """;

        String expected = """
                          1 2
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC270C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                                              6 3 6
                       3 1
                       2 5
                       1 2
                       4 1
                       2 6
                    """;

        String expected = """
                          3 1 2 6
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC270C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC270C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
