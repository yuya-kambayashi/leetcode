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
public class ABC251C {

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
        Map<String, Integer> map = new LinkedHashMap<>();
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            int t = sc.nextInt();
            ss[i] = s;
            if (!map.containsKey(s)) {
                map.put(s, t);
            }
        }
        int max = Integer.MIN_VALUE;
        String ans = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int v = entry.getValue();

            if (max < v) {
                max = v;
                ans = entry.getKey();
            }
        }

        int ret = 0;
        for (int i = 0; i < n; i++) {
            if (ss[i].equals(ans)) {
                ret = i + 1;
                break;
            }
        }

        System.out.println(ret);
    }
//}

    //@Test
    public void Case1() {

        String input = """
                       3
                       aaa 10
                       bbb 20
                       aaa 30
                    """;

        String expected = """
                          2
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC251C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       5
                       aaa 9
                       bbb 10
                       ccc 10
                       ddd 10
                       bbb 11
                    """;

        String expected = """
                          2
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC251C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       10
                       bb 3
                       ba 1
                       aa 4
                       bb 1
                       ba 5
                       aa 9
                       aa 2
                       ab 6
                       bb 5
                       ab 3
                    """;

        String expected = """
                          8
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC251C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
