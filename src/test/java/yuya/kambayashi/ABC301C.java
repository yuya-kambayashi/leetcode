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

        for (int i = 0; i < 26; i++) {
            var b1 = isAtcoder(i);
            var b2 = isAtcoder2(i);

            if (b1 != b2) {
                int aaaa = 0;
            }

        }

        int[] cntS = new int[26];
        int[] cntT = new int[26];

        int atS = 0, atT = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '@') {
                atS++;
            } else {
                cntS[(int) (s.charAt(i) - 'a')]++;
            }

            if (t.charAt(i) == '@') {
                atT++;
            } else {
                cntT[(int) (t.charAt(i) - 'a')]++;
            }
        }
        for (int i = 0; i < 26; i++) {

            if (cntS[i] < cntT[i]) {

                if (!isAtcoder(i)) {
                    System.out.println("No");
                    return;
                } else {
                    atS -= (cntT[i] - cntS[i]);
                }
            } else if (cntS[i] > cntT[i]) {

                if (!isAtcoder(i)) {
                    System.out.println("No");
                    return;
                } else {
                    atT -= (cntS[i] - cntT[i]);
                }
            }
            if (atT < 0 || atS < 0) {
                System.out.println("No");
                return;

            }
        }
        System.out.println("Yes");

    }

    static boolean isAtcoder(int i) {

        char c = (char) ('a' + i);

        return "atcoder".indexOf(String.valueOf(c)) != -1;
    }

    static boolean isAtcoder2(int c) {
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
