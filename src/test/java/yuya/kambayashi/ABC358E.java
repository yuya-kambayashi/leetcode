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
public class ABC358E {

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

        final int mod = 998244353;

        final int k = sc.nextInt();
        int[] cc = new int[26];
        for (int i = 0; i < 26; i++) {
            cc[i] = sc.nextInt();
        }

        List<Character> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            char c = (char) ('A' + i);

            for (int j = 0; j < cc[i]; j++) {
                list.add(c);
            }
        }

        Map<Character, Integer> map = new HashMap<>();
        for (var l : list) {
            map.put(l, map.getOrDefault(l, 0) + 1);
        }

        //1
        long ans = 0;
        int keySize = map.keySet().size();
        ans += keySize;

        // 2
        if (k > 1) {
            // 2以上の数
            int cntUp2 = 0;
            for (var v : map.values()) {
                if (v >= 2) {
                    cntUp2++;
                }
            }

            long cnt = 1;
            for (int i = keySize; i >= 1; i--) {
                cnt *= i;
            }

            ans += cnt;
            ans += cntUp2;

            int a = 0;
        }
        // k = 3
        if (k > 2) {
            // 3以上の数
            int cntUp3 = 0;
            for (var v : map.values()) {
                if (v >= 3) {
                    cntUp3++;
                }
            }

            long cnt = 1;
            for (int i = keySize; i >= 1; i--) {
                cnt *= i;
            }

            ans += cnt;
            ans += cntUp2;

            int a = 0;
        }

        System.out.println();
    }
//}

    @Test
    public void Case1() {

        String input = """
                       2
                       2 1 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
                    """;

        String expected = """
                          10
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC358E.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    //  @Test
    public void Case2() {

        String input = """
                       358
                       1 0 1 0 1 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
                    """;

        String expected = """
                          64
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC358E.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                       1000
                       1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000
                    """;

        String expected = """
                          270274035
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC358E.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }
}
