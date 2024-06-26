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
public class ABC359C {

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

        long sx = sc.nextLong();
        long sy = sc.nextLong();
        long tx = sc.nextLong();
        long ty = sc.nextLong();

        if (sy > ty) {
            long bx = sx;
            long by = sy;

            sx = tx;
            sy = ty;

            tx = bx;
            ty = by;
        }

        long ans = 0;
        if (sx <= tx) {
            if ((sx + sy) % 2 == 0) {
                long dx = (tx - sx) / 2;
                ans += dx;

                long dy = (ty - sy);
                ans += dy;
            } else {
                long dx = (tx - sx) / 2;
                if (sy % 2 == 0) {
                    if (sx % 2 == 1) {3
                        dx++;
                    }
                } else {
                    1  if (tx % 2 == 1) {
                        dx++;
                    }
                }
                ans += dx;

                long dy = (ty - sy);
                ans += dy;
            }
        } else {
            if ((sx + sy) % 2 == 1) {
                long dx = (tx - sx) / 2;
                ans += dx;

                long dy = (ty - sy);
                ans += dy;
            } else {
                long dx = (tx - sx) / 2;
                if (sy % 2 == 0) {
                    if (sx % 2 == 1) {
                        dx++;
                    }
                } else {
                    if (tx % 2 == 1) {
                        dx++;
                    }
                }
                ans += dx;

                long dy = (ty - sy);
                ans += dy;
            }
        }

        System.out.println(ans);
    }
//}

    @Test
    public void Case0() {

        String input = """
                       1 0
                       2 0
                    """;

        String expected = """
                          1
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC359C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case1() {

        String input = """
                       5 0
                       2 5
                    """;

        String expected = """
                          5
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC359C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //  @Test
    public void Case2() {

        String input = """
                       3 1
                       4 1
                    """;

        String expected = """
                          0
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC359C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                       2552608206527595 5411232866732612
                       771856005518028 7206210729152763
                    """;

        String expected = """
                          1794977862420151
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC359C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
