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
public class ABC202C {

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
        int[] aa = new int[n];
        int[] bb = new int[n];
        Map<Integer, Integer> cmap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            aa[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            bb[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            int c = sc.nextInt();

            cmap.put(c, cmap.getOrDefault(c, 0) + 1);
        }

        int ans = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            if (map.containsKey(aa[i])) {
                ans += map.get(aa[i]);
                continue;
            }
            int t = 0;
            for (int j = 0; j < n; j++) {
                if (aa[i] == bb[j]) {
                    if (cmap.containsKey(j + 1)) {
                        int c = cmap.get(j + 1);
                        t += c;
                    }
                }

            }
            map.put(aa[i], t);
            ans += t;
        }
        System.out.println(ans);
    }

//}
    //@Test
    public void Case1() {

        String input = """
                       3
1 2 2
3 1 2
2 3 2
                    """;

        String expected = """
                          4
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC202C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case2() {

        String input = """
                       4
1 1 1 1
1 1 1 1
1 2 3 4
                    """;

        String expected = """
                          16
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC202C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       3
2 3 3
1 3 3
1 1 1
                    """;

        String expected = """
                          0
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC202C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
