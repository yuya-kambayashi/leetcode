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
public class ABC138D {

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
// https://drken1215.hatenablog.com/entry/2020/05/18/174000
//import java.util.*;
//import java.util.stream.Collectors;
//public class Main {

    static List<List<Integer>> G;
    static int N, Q;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        Q = sc.nextInt();
        G = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            G.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            a--;
            b--;
            G.get(a).add(b);
            G.get(b).add(a);
        }

        long[] val = new long[N];
        for (int i = 0; i < Q; i++) {
            int p = sc.nextInt();
            int x = sc.nextInt();

            p--;

            val[p] += x;
        }

        dfs(0, -1, val);

        String result = "";
        for (int i = 0; i < val.length; i++) {
            result += String.valueOf(val[i]);
            if (i != val.length - 1) {
                result += " ";
            }
        }

        System.out.println(result);
    }

    static void dfs(int v, int p, long[] res) {
        if (p != -1) {
            res[v] += res[p];
        }

        for (int e : G.get(v)) {
            if (e == p) {
                continue;
            }
            dfs(e, v, res);
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                       4 3
                       1 2
                       2 3
                       2 4
                       2 10
                       1 100
                       3 1
                    """;

        String expected = """
                          100 110 111 110
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC138D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       6 2
                       1 2
                       1 3
                       2 4
                       3 6
                       2 5
                       1 10
                       1 10
                    """;

        String expected = """
                          20 20 20 20 20 20
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC138D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC138D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}

//import java.util.*;
//public class Main {
