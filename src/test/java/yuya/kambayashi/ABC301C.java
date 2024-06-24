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
public class ABC301C {

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

        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];

        int a = 0, b = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '@') {
                cnt1[s.charAt(i) - 'a']++;
            } else {
                a++;
            }

            if (t.charAt(i) != '@') {
                cnt2[t.charAt(i) - 'a']++;
            } else {
                b++;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (cnt1[i] > cnt2[i]) {
                if (!isAtcoder(i)) {
                    System.out.println("No");
                    return;
                }
                b -= cnt1[i] - cnt2[i];
            } else if (cnt1[i] < cnt2[i]) {
                if (!isAtcoder(i)) {
                    System.out.println("No");
                    return;
                }
                a -= cnt2[i] - cnt1[i];
            }
            if (a < 0 || b < 0) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }

    static boolean isAtcoder(int c) {
        return "atcoder".contains("" + (char) (c + 'a'));
    }
//}

    @Test
    public void Case1() {

        String input = """
                       ch@ku@ai
choku@@i
                    """;

        String expected = """
                          Yes
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC301C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       ch@kud@i
akidu@ho
                    """;

        String expected = """
                          Yes
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC301C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       aoki
@ok@
                    """;

        String expected = """
                          No
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC301C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
