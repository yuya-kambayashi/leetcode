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
public class ABC342C {

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
//public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        String s = sc.next();
        final int q = sc.nextInt();
        char[] cc = new char[q];
        char[] dd = new char[q];
        for (int i = 0; i < q; i++) {
            cc[i] = sc.next().charAt(0);
            dd[i] = sc.next().charAt(0);
        }
        Map<Character, Character> map = new TreeMap<>();
        for (int i = 0; i < q; i++) {
            char c = cc[i];
            char d = dd[i];

            // cが値のエントリーがあれば、その値をdに上書きする
            if (map.containsValue(c)) {

                for (var entry : map.entrySet()) {

                    if (entry.getValue() == c) {
                        map.put(entry.getKey(), d);
                    }
                }
                if (!map.containsKey(c)) {
                    map.put(c, d);
                }

            } else if (map.containsKey((c))) {

            } else {

                map.put(c, d);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                sb.append(map.get(c));
            } else {
                sb.append(c);
            }
        }

        System.out.println(sb.toString());
    }
//}
    // rtcodea
    // recodea
    // recovea
    // recover

    @Test
    public void Case1() {

        String input = """
                       7
                       atcoder
                       4
                       r a
                       t e
                       d v
                       a r
                    """;

        String expected = """
                          recover
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC342C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       3
                       abc
                       4
                       a a
                       s k
                       n n
                       z b
                    """;

        String expected = """
                          abc
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC342C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       34
                       supercalifragilisticexpialidocious
                       20
                       g c
                       l g
                       g m
                       c m
                       r o
                       s e
                       a a
                       o f
                       f s
                       e t
                       t l
                       d v
                       p k
                       v h
                       x i
                       h n
                       n j
                       i r
                       s i
                       u a
                    """;

        String expected = """
                          laklimamriiamrmrllrmlrkramrjimrial
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC342C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
