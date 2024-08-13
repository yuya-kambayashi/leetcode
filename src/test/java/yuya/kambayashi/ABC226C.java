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
public class ABC226C {

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
    static long ans;
    static boolean[] visited;
    static List<List<Integer>> aaa = new ArrayList<>();
    static int[] tt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        ans = Long.MAX_VALUE;
        tt = new int[n + 1];
        aaa = new ArrayList<>();
        aaa.add(new ArrayList<>());
        for (int i = 1; i <= n; i++) {
            int t = sc.nextInt();
            tt[i] = t;
            int k = sc.nextInt();
            List<Integer> aa = new ArrayList<>();
            for (int j = 0; j < k; j++) {
                int a = sc.nextInt();
                aa.add(a);
            }
            aaa.add(aa);
        }
        visited = new boolean[n + 1];

        boolean[] needs = new boolean[n + 1];
        dfs(n, needs);
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            if (needs[i]) {
                ans += tt[i];
            }
        }

        System.out.println(ans);
    }

    static void dfs(int pos, boolean[] needs) {
        if (needs[pos]) {
            return;
        }
        needs[pos] = true;

        for (var a : aaa.get(pos)) {
            dfs(a, needs);
        }

    }
//}

    @Test
    public void Case1() {

        String input = """
                       3
3 0
5 1 1
7 1 1
                    """;

        String expected = """
                          10
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC226C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       5
1000000000 0
1000000000 0
1000000000 0
1000000000 0
1000000000 4 1 2 3 4
                    """;

        String expected = """
                          5000000000
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC226C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC226C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC226C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
