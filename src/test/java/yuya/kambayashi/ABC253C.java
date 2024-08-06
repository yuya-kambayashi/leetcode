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
public class ABC253C {

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
        List<Query> qq = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            if (t == 1) {
                int x = sc.nextInt();
                qq.add(new Query(t, x, Integer.MIN_VALUE));

            } else if (t == 2) {
                int x = sc.nextInt();
                int c = sc.nextInt();
                qq.add(new Query(t, x, c));

            } else {
                qq.add(new Query(t, Integer.MIN_VALUE, Integer.MIN_VALUE));

            }
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (var q : qq) {
            if (q.t == 1) {
                map.put(q.x, map.getOrDefault(q.x, 0) + 1);
            } else if (q.t == 2) {
                int cnt = map.getOrDefault(q.x, 0);
                int t = Math.min(q.c, cnt);
                if (cnt - t <= 0) {
                    if (map.containsKey(q.x)) {
                        map.remove(q.x);
                    }
                } else {
                    map.put(q.x, cnt - t);
                }

            } else {
                System.out.println(map.lastKey() - map.firstKey());
            }
        }

        System.out.println();
    }

    static class Query {

        int t, x, c;

        public Query(int t, int x, int c) {
            this.t = t;
            this.x = x;
            this.c = c;

        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                       8
1 3
1 2
3
1 2
1 7
3
2 2 3
3
                    """;

        String expected = """
                          1
5
4
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC253C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       4
1 10000
1 1000
2 100 3
1 10
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC253C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC253C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC253C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
