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
public class ABC381C {

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
        final String s = sc.next();

        int cnt1 = 0, cnt2 = 0;
        boolean half = false;

        int max = 1;

        for (int i = 0; i < n; i++) {

            char c = s.charAt(i);

            if (c != '1') {
                cnt1 = 0;
                cnt2 = 0;
                half = false;
                continue;
            }
            cnt1++;

            for (int j = i + 1; j < n; j++) {
                char c2 = s.charAt(j);

                if (half) {
                    if (c2 == '1') {
                        cnt1 = 1;
                        cnt2 = 0;
                        half = false;
                        i = j;
                        break;
                    } else if (c2 == '/') {
                        cnt1 = 0;
                        cnt2 = 0;
                        half = false;
                        i = j;
                        break;
                    } else {
                        cnt2++;
                        if (cnt1 != 0 && cnt2 != 0) {
                            max = Math.max(max, Math.min(cnt1, cnt2) * 2 + 1);
                        }

                        if (cnt1 == cnt2) {
                            cnt1 = 0;
                            cnt2 = 0;
                            half = false;
                            i = j;
                            break;
                        }
                    }
                } else {
                    if (c2 == '1') {
                        cnt1++;
                    } else if (c2 == '/') {
                        half = true;
                    } else {
                        cnt1 = 0;
                        cnt2 = 0;
                        i = j;
                        break;
                    }
                }
            }
        }

        System.out.println(max);
    }
//}

    @Test
    public void Case1() {

        String input = """
                       8
                       211/2212
                    """;

        String expected = """
                          5
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC381C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       5
                       22/11
                    """;

        String expected = """
                          1
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC381C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       22
                       /1211/2///2111/2222/11
                    """;

        String expected = """
                          7
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC381C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case4() {

        String input = """
                        8
                        1/1/1/22
                    """;

        String expected = """
                          3
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC381C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
