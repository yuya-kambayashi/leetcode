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
public class ABC376B {

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
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        final int q = sc.nextInt();

        int l = 1;
        int r = 2;
        int ans = 0;

        for (int i = 0; i < q; i++) {
            char c = sc.next().toCharArray()[0];
            int next = sc.nextInt();

            if (c == 'R') {

                var clockNums = getClockNums(r, next);
                var nonclockNums = getNonClockNums(r, next);

                if (clockNums.contains(l)) {
                    ans += nonclockNums.size();
                } else {
                    ans += clockNums.size();
                }
                r = next;

            } else {
                var clockNums = getClockNums(l, next);
                var nonclockNums = getNonClockNums(l, next);

                if (clockNums.contains(r)) {
                    ans += nonclockNums.size();
                } else {
                    ans += clockNums.size();
                }
                l = next;
            }

        }

        System.out.println(ans);
    }

    static List<Integer> getClockNums(int start, int end) {
        List<Integer> ans = new ArrayList<>();

        int end2 = (start > end) ? end + n : end;

        for (int i = start + 1; i <= end2; i++) {
            if (i <= n) {
                ans.add(i);

            } else {
                ans.add(i - n);
            }
        }

        return ans;
    }

    static List<Integer> getNonClockNums(int start, int end) {

        var a = getClockNums(end - 1, start - 1);
        Collections.reverse(a);

        return a;
    }
//}

    @Test
    public void Case1() {

        String input = """
                       6 3
                       R 4
                       L 5
                       R 6
                    """;

        String expected = """
                          8
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC376B.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       100 2
                       L 1
                       R 2
                    """;

        String expected = """
                          0
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC376B.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       30 8
                       R 23
                       R 26
                       R 29
                       L 20
                       R 29
                       R 19
                       L 7
                       L 16
                    """;

        String expected = """
                          92
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC376B.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC376B.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
