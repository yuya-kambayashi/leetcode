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
public class ABC368D {

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
    static List<Boolean> selected = new ArrayList<>();
    static List<Integer> num = new ArrayList<>();
    static List<List<Integer>> graph = new ArrayList<>();

    //https://atcoder.jp/contests/abc368/submissions/57136092
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 1; i <= n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            a--;
            b--;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        selected = new ArrayList<>();
        num = new ArrayList<>();

        List<Integer> vs = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            vs.add(sc.nextInt() - 1);
        }
        for (int i = 0; i < n; i++) {
            selected.add(false);
        }
        for (int i = 0; i < k; i++) {
            selected.set(vs.get(i), true);
        }
        for (int i = 0; i < n; i++) {
            num.add(0);
        }
        dfs(vs.get(0), -1);
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (num.get(i) > 0) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    static void dfs(int v, int p) {
        if (selected.get(v)) {
            num.set(v, num.get(v) + 1);
        }
        for (int u : graph.get(v)) {
            if (u == p) {
                continue;
            }
            dfs(u, v);
            num.set(v, num.get(v) + num.get(u));
        }
    }

//}
    @Test
    public void Case1() {

        String input = """
                       7 3
                       1 2
                       1 3
                       2 4
                       2 5
                       3 6
                       3 7
                       1 3 5
                    """;

        String expected = """
                          4
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC368D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       4 4
                       3 1
                       1 4
                       2 1
                       1 2 3 4
                    """;

        String expected = """
                          4
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC368D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       5 1
                       1 4
                       2 3
                       5 2
                       1 2
                       1
                    """;

        String expected = """
                          1
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC368D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC368D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
