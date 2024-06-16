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
public class ABC314C {

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
        final String s = sc.next();
        int[] cc = new int[n];
        Map<Integer, List<Letter>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int c = sc.nextInt();
            var l = new Letter(s.charAt(i), i);
            if (map.containsKey(c)) {
                map.get(c).add(l);
            } else {
                List<Letter> list = new ArrayList<>();
                list.add(l);
                map.put(c, list);
            }
        }

        for (var entry : map.entrySet()) {
            var list = entry.getValue();

            if (list.size() > 1) {
                int t = list.get(0).i;
                for (int i = 0; i < list.size() - 1; i++) {
                    list.get(i).i = list.get(i + 1).i;
                }
                list.get(list.size() - 1).i = t;
            }
        }
        char[] ans = new char[n];
        for (var v : map.values()) {
            for (var vv : v) {
                ans[vv.i] = vv.c;
            }
        }

        System.out.println(String.valueOf(ans));
    }

    static class Letter {

        char c;
        int i;

        public Letter(char c, int i) {
            this.c = c;
            this.i = i;
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                       8 3
apzbqrcs
1 2 3 1 2 2 1 2
                    """;

        String expected = """
                          cszapqbr
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC314C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       2 1
aa
1 1
                    """;

        String expected = """
                          aa
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC314C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case3() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC314C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
