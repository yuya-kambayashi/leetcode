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
public class ABC352B {

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

        final String s = sc.next();
        final String t = sc.next();

        int si = 0, ti = 0;

        List<Integer> collectIndex = new ArrayList<>();

        while (si < s.length()) {

            if (s.charAt(si) == t.charAt(ti)) {
                collectIndex.add(ti + 1);
                si++;
                ti++;
            } else {
                ti++;
            }

        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < collectIndex.size(); i++) {
            sb.append(collectIndex.get(i));
            if (i != collectIndex.size() - 1) {
                sb.append(" ");
            }
        }

        System.out.println(sb.toString());
    }
//}

    @Test
    public void Case1() {

        String input = """
                       abc
                       axbxyc
                    """;

        String expected = """
                          1 3 6
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC352B.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       aaaa
                       bbbbaaaa
                    """;

        String expected = """
                          5 6 7 8
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC352B.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       atcoder
                       atcoder
                    """;

        String expected = """
                          1 2 3 4 5 6 7
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC352B.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }
}
