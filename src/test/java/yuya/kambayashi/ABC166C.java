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
public class ABC166C {

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
        int[] hh = new int[n];
        int[] aa = new int[m];
        int[] bb = new int[m];
        for (int i = 0; i < n; i++) {
            hh[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            aa[i] = sc.nextInt();
            bb[i] = sc.nextInt();
        }

        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int i = 0; i < m; i++) {

            int a = aa[i];
            int b = bb[i];

            if (map.containsKey(a)) {
                map.get(a).add(b);
            } else {
                Set<Integer> s = new HashSet<>();
                s.add(b);
                map.put(a, s);
            }
            if (map.containsKey(b)) {
                map.get(b).add(a);
            } else {
                Set<Integer> s = new HashSet<>();
                s.add(a);
                map.put(b, s);
            }
        }

        int ans = 0;

        for (int i = 1; i <= n; i++) {

            if (map.containsKey(i)) {
                boolean highest = true;
                for (int t : map.get(i)) {
                    t--;
                    if (hh[i - 1] <= hh[t]) {
                        highest = false;
                        break;
                    }
                }
                if (highest) {
                    ans++;
                }
            } else {
                ans++;
            }
        }
        System.out.println(ans);
    }
//}

    //@Test
    public void Case1() {

        String input = """
                       4 3
1 2 3 4
1 3
2 3
2 4
                    """;

        String expected = """
                          2
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC166C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       6 5
8 6 9 1 2 1
1 3
4 2
4 3
4 6
4 6
                    """;

        String expected = """
                          3
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC166C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    //  @Test
    public void Case3() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC166C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }
}
