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
public class ABC362D {

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
    static long[][] eee;
    static long[] aa;
    static TreeMap<Integer, Long> map;
    static boolean[] ch;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final int m = sc.nextInt();
        aa = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            aa[i] = sc.nextInt();
        }

        eee = new long[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int b = sc.nextInt();

            if (eee[u][v] != 0L) {
                eee[u][v] = Math.min(eee[u][v], b);
            } else {
                eee[u][v] = b;
            }
            if (eee[v][u] != 0L) {
                eee[v][u] = Math.min(eee[v][u], b);
            } else {
                eee[v][u] = b;
            }
        }
        ch = new boolean[n + 1];
        map = new TreeMap<>();
        dfs(1, aa[1]);

        for (var v : map.values()) {
            System.out.print(v);
            System.out.print(" ");
        }
    }

    static void dfs(int v, long s) {
        ch[v] = true;

        if (v != 1) {
            if (map.containsKey(v)) {
                map.put(v, Math.min(map.get(v), s));
            } else {
                map.put(v, s);
            }
        }
        for (int i = 1; i < eee.length; i++) {
            if (!ch[i] && eee[v][i] != 0) {
                dfs(i, s + eee[v][i] + aa[i]);
            }
        }
        ch[v] = false;
    }
//}

    @Test
    public void Case1() {

        String input = """
                       3 3
                       1 2 3
                       1 2 1
                       1 3 6
                       2 3 2
                    """;

        String expected = """
                          4 9
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC362D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       2 1
                       0 1
                       1 2 3
                    """;

        String expected = """
                          4
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC362D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       5 8
                       928448202 994752369 906965437 942744902 907560126
                       2 5 975090662
                       1 2 908843627
                       1 5 969061140
                       3 4 964249326
                       2 3 957690728
                       2 4 942986477
                       4 5 948404113
                       1 3 988716403
                    """;

        String expected = """
                          2832044198 2824130042 4696218483 2805069468
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC362D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
