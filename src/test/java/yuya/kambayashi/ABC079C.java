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
public class ABC079C {

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

        int a = s.charAt(0) - 48;
        int b = s.charAt(1) - 48;
        int c = s.charAt(2) - 48;
        int d = s.charAt(3) - 48;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {

                    StringBuilder sb = new StringBuilder();

                    int t = a;
                    sb.append(a);
                    if (i == 0) {
                        t += b;
                        sb.append("+");
                        sb.append(b);
                    } else {
                        t -= b;
                        sb.append("-");
                        sb.append(b);
                    }
                    if (j == 0) {
                        t += c;
                        sb.append("+");
                        sb.append(c);
                    } else {
                        t -= c;
                        sb.append("-");
                        sb.append(c);
                    }
                    if (k == 0) {
                        t += d;
                        sb.append("+");
                        sb.append(d);
                    } else {
                        t -= d;
                        sb.append("-");
                        sb.append(d);
                    }

                    if (t == 7) {
                        sb.append("=7");
                        System.out.println(sb.toString());
                        return;
                    }
                }
            }
        }

        System.out.println();
    }
//}

    @Test
    public void Case1() {

        String input = """
                       1222
                    """;

        String expected = """
                          1+2+2+2=7
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC079C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       0290
                    """;

        String expected = """
                          0-2+9+0=7
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC079C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       3242
                    """;

        String expected = """
                          3+2+4-2=7
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC079C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
