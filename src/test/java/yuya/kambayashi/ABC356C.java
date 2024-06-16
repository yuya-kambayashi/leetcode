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
public class ABC356C {

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
        final int k = sc.nextInt();

        int[] cc = new int[m];
        List<Set<Integer>> aaa = new ArrayList<>();
        String[] rr = new String[m];
        for (int i = 0; i < m; i++) {
            int c = sc.nextInt();
            cc[i] = c;
            Set<Integer> aa = new HashSet<>();
            for (int j = 0; j < c; j++) {
                int a = sc.nextInt();
                a--;
                aa.add(a);
            }
            aaa.add(aa);
            rr[i] = sc.next();
        }

        int ans = 0;

        for (int bit = 0; bit < 1 << n; bit++) {
            List<Integer> is = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((bit & (1 << i)) >= 1) {
                    is.add(i);
                }
            }
            if (is.size() != k) {
                continue;
            }

            boolean[] keys = new boolean[n];
            Arrays.fill(keys, false);
            for (int i = 0; i < n; i++) {

                if (is.contains(i)) {
                    keys[i] = true;
                }
            }

            boolean ok = true;
            boolean allOk = true;

            for (int i = 0; i < m; i++) {
                String r = rr[i];

                var aa = aaa.get(i);

                // 〇判定
                if (r.equals("o")) {

                    // 暫定本物の鍵がすべて含まれていること
                    boolean all = true;
                    for (int j = 0; j < n; j++) {
                        if (keys[j] && !aa.contains(j)) {
                            all = false;
                            break;
                        }
                    }
                    if (!all) {
                        allOk = false;
                    }

                } // ×判定
                else if (r.equals("x")) {
                    boolean all = true;
                    for (int j = 0; j < n; j++) {
                        if (keys[j] && !aa.contains(j)) {
                            all = false;
                            break;
                        }
                    }
                    if (!all) {
                        ok = false;
                        break;
                    }
                }
            }
            if (ok && allOk) {
                ans++;
            }
        }

        System.out.println(ans);

    }
//}

    //@Test
    public void Case1() {

        String input = """
                       3 2 2
                       3 1 2 3 o
                       2 2 3 x
                    """;

        String expected = """
                          2
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC356C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case2() {

        String input = """
                       4 5 3
                       3 1 2 3 o
                       3 2 3 4 o
                       3 3 4 1 o
                       3 4 1 2 o
                       4 1 2 3 4 x
                    """;

        String expected = """
                          0
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC356C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       11 4 9
                       10 1 2 3 4 5 6 7 8 9 10 o
                       11 1 2 3 4 5 6 7 8 9 10 11 o
                       10 11 10 9 8 7 6 5 4 3 2 x
                       10 11 9 1 4 3 7 5 6 2 10 x
                    """;

        String expected = """
                          8
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC356C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
