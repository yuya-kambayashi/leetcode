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
public class ABC287C {

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
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            int v = sc.nextInt();
            int u = sc.nextInt();
            v--;
            u--;
            list.get(u).add(v);
            list.get(v).add(u);
        }
        if (n != m + 1) {
            System.out.println("No");
            return;
        }
        for (int i = 0; i < n; i++) {
            if (list.get(i).size() >= 3) {
                System.out.println("No");
                return;
            }
        }
        int[] used = new int[n];
        Queue<Integer> que = new LinkedList<>();
        que.add(0);
        while (!que.isEmpty()) {
            int q = que.poll();
            for (var t : list.get(q)) {
                if (used[t] == 0) {
                    used[t]++;
                    que.add(t);
                }
            }
        }

        for (var v : used) {
            if (v != 1) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");

    }
//}

    @Test
    public void Case1() {

        String input = """
                       4 3
1 3
4 2
3 2
                    """;

        String expected = """
                          Yes
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC287C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       2 0
                    """;

        String expected = """
                          No
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC287C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       5 5
1 2
2 3
3 4
4 5
5 1
                    """;

        String expected = """
                          No
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC287C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC287C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
