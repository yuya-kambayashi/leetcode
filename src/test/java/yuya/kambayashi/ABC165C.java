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
public class ABC165C {

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

    static int N, M, Q;
    static List<Integer> A = new ArrayList<>();
    static int[] a;
    static int[] b;
    static int[] c;
    static int[] d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        Q = sc.nextInt();

        a = new int[Q];
        b = new int[Q];
        c = new int[Q];
        d = new int[Q];

        for (int i = 0; i < Q; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
            c[i] = sc.nextInt();
            d[i] = sc.nextInt();

            a[i]--;
            b[i]--;

        }

        System.out.println(dfs(A));
    }

    static long calc(List<Integer> A) {
        long score = 0;
        for (int q = 0; q < Q; q++) {
            if (A.get(b[q]) - A.get(a[q]) == c[q]) {
                score += d[q];
            }
        }
        return score;
    }

    static long dfs(List<Integer> A) {
        if (A.size() == N + 1) {
            return calc(A);
        }

        long result = 0;

        int prev = A.isEmpty() ? 1 : A.get(A.size() - 1);

        for (int add = prev; add <= M; add++) {
            A.add(add);

            result = Math.max(result, dfs(A));
            A.remove(A.size() - 1);
        }

        return result;
    }

//}
    @Test
    public void Case1() {

        String input = """
                       3 4 3
                       1 3 3 100
                       1 2 2 10
                       2 3 2 10
                    """;

        String expected = """
                          110
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC165C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    //@Test
    public void Case2() {

        String input = """
                       4 6 10
                       2 4 1 86568
                       1 4 0 90629
                       2 3 0 90310
                       3 4 1 29211
                       3 4 3 78537
                       3 4 2 8580
                       1 2 1 96263
                       1 4 2 2156
                       1 2 0 94325
                       1 4 3 94328
                    """;

        String expected = """
                          357500
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC165C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    //@Test
    public void Case3() {

        String input = """
                       10 10 1
                       1 10 9 1
                    """;

        String expected = """
                          1
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC165C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }
}

//import java.util.*;
//public class Main {
