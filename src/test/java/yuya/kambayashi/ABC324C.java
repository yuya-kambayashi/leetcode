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
public class ABC324C {

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
        String t = sc.next();
        String[] ss = new String[n + 1];
        for (int i = 1; i <= n; i++) {
            ss[i] = sc.next();
        }

        List<Integer> ans = new ArrayList<>();

        int[] mapt = new int[26];
        for (char c : t.toCharArray()) {
            mapt[(int) (c - 'a')]++;
        }

        for (int i = 1; i <= n; i++) {
            String s = ss[i];
            int[] maps = new int[26];
            for (char c : s.toCharArray()) {
                maps[(int) (c - 'a')]++;
            }
            int diff = 0;
            for (int j = 0; j < 26; j++) {

                diff += Math.abs(mapt[i] - maps[i]);
            }

            if (diff <= 1) {
                ans.add(i);
            }
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
                       5 ababc
ababc
babc
abacbc
abdbc
abbac
                    """;

        String expected = """
                          4
1 2 3 4
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC324C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //  @Test
    public void Case2() {

        String input = """
                       1 aoki
takahashi
                    """;

        String expected = """
                          0
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC324C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                       9 atcoder
atoder
atcode
athqcoder
atcoder
tacoder
jttcoder
atoder
atceoder
atcoer
                    """;

        String expected = """
                          6
1 2 4 7 8 9
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC324C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC324C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
