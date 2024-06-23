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
public class ABC359D {

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

        final int n = sc.nextInt();
        final int k = sc.nextInt();
        String s = sc.next();
        char[] cc = s.toCharArray();
        List<Integer> qindex = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '?') {
                qindex.add(i);
            }
        }
        int m = qindex.size();

        long ans = 0;

        for (int bit = 0; bit < 1 << m; bit++) {
            boolean hasP = false;
            for (int i = 0; i < m; i++) {
                if ((bit & (1 << i)) >= 1) {
                    cc[qindex.get(i)] = 'A';
                } else {
                    cc[qindex.get(i)] = 'B';
                }
            }
            for (int i = 0; i < n - k; i++) {
                int start = i;
                int end = i + k - 1;
                if (isPalindrome(cc, start, end)) {
                    hasP = true;
                    break;
                }
            }
            if (!hasP) {
                ans++;
            }
        }

        System.out.println(ans % mod);
    }

    static boolean isPalindrome(char[] cc, int start, int end) {
        int left = start, right = end;
        while (left < right) {
            if (cc[left] != cc[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
//}

    //@Test
    public void Case1() {

        String input = """
                       7 4
                       AB?A?BA
                    """;

        String expected = """
                          1
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC359D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       40 7
                       ????????????????????????????????????????
                    """;

        String expected = """
                          116295436
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC359D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                       15 5
                       ABABA??????????
                    """;

        String expected = """
                          0
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC359D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                       40 8
                       ?A?B??B?B?AA?A?B??B?A???B?BB?B???BA??BAA
                    """;

        String expected = """
                          259240
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC359D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
