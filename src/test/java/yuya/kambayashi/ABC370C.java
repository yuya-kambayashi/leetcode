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
public class ABC370C {

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
        if (s.equals(t)) {
            System.out.println(0);
            return;
        }

        List<Integer> swin = new ArrayList<>();
        List<Integer> sloose = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if (cs == ct) {
                continue;
            }
            if (cs > ct) {
                swin.add(i);
            } else {
                sloose.add(i);
            }
        }
        List<String> ans = new ArrayList<>();
        String p = s;
        for (int i = 0; i < swin.size(); i++) {
            StringBuilder sb = new StringBuilder();
            int index = swin.get(i);
            for (int j = 0; j < p.length(); j++) {
                if (j == index) {
                    sb.append(t.charAt(j));
                } else {
                    sb.append(p.charAt(j));
                }
            }
            ans.add(sb.toString());
            p = sb.toString();
            sb.setLength(0);
        }
        Collections.reverse(sloose);
        for (int i = 0; i < sloose.size(); i++) {
            StringBuilder sb = new StringBuilder();
            int index = sloose.get(i);
            for (int j = 0; j < p.length(); j++) {
                if (j == index) {
                    sb.append(t.charAt(j));
                } else {
                    sb.append(p.charAt(j));
                }
            }
            ans.add(sb.toString());
            p = sb.toString();
            sb.setLength(0);
        }

        System.out.println(ans.size());
        for (var a : ans) {
            System.out.println(a);

        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                       adbe
                       bcbc
                    """;

        String expected = """
                          3
                          acbe
                          acbc
                          bcbc
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC370C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       abcde
                       abcde
                    """;

        String expected = """
                          0
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC370C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       afwgebrw
                       oarbrenq
                    """;

        String expected = """
                          8
                          aawgebrw
                          aargebrw
                          aarbebrw
                          aarbebnw
                          aarbebnq
                          aarbeenq
                          aarbrenq
                          oarbrenq
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC370C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC370C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
