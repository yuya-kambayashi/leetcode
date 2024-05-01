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

        Map<Character, Character> dic = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            dic.put(c, c);
        }

        final int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            char c = sc.next().charAt(0);
            char d = sc.next().charAt(0);
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (dic.get(ch) == c) {
                    dic.put(ch, d);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(dic.get(c));
        }

        System.out.println(sb.toString());

    }
//}

    //@Test
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
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    //@Test
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
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
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
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }
}
