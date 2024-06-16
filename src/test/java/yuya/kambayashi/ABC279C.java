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
public class ABC279C {

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

        final int height = sc.nextInt();
        final int width = sc.nextInt();
        List<String> ss = new ArrayList<>();
        List<String> tt = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ss.add(sc.next());
        }
        for (int i = 0; i < height; i++) {
            tt.add(sc.next());
        }

        Map<String, Integer> ss2 = new HashMap<>();
        for (int i = 0; i < width; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < height; j++) {
                sb.append(ss.get(j).charAt(i));
            }
            String t = sb.toString();
            ss2.put(t, ss2.getOrDefault(t, 0) + 1);
        }
        Map<String, Integer> tt2 = new HashMap<>();
        for (int i = 0; i < width; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < height; j++) {
                sb.append(tt.get(j).charAt(i));
            }
            String t = sb.toString();
            tt2.put(t, tt2.getOrDefault(t, 0) + 1);
        }

        String ret = "Yes";
//            if (ss2.size() == tt2.size()) {
//                for (var k : ss2.keySet()) {
//                    if (!ss2.get(k).equals(tt2.get(k))) {
//                        ret = "No";
//                        break;
//                    }
//                }
//            } else {
//                ret = "No";
//            }
        if (!tt2.equals(ss2)) {
            ret = "No";
        }

        System.out.println(ret);
    }
//}

    @Test
    public void Case1() {

        String input = """
                       3 4
##.#
##..
#...
.###
..##
...#
                    """;

        String expected = """
                          Yes
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC279C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //  @Test
    public void Case2() {

        String input = """
                       3 3
#.#
.#.
#.#
##.
##.
.#.
                    """;

        String expected = """
                          No
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC279C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                       2 1
#
.
#
.
                    """;

        String expected = """
                          Yes
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC279C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
