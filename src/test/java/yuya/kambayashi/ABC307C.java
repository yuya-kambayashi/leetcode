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
public class ABC307C {

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

        final int ha = sc.nextInt();
        final int wa = sc.nextInt();
        char[][] gga = new char[ha][wa];
        for (int i = 0; i < ha; i++) {
            String s = sc.next();
            gga[i] = s.toCharArray();
        }
        Sheet sa = new Sheet(ha, wa, gga);

        final int hb = sc.nextInt();
        final int wb = sc.nextInt();
        char[][] ggb = new char[hb][wb];
        for (int i = 0; i < hb; i++) {
            String s = sc.next();
            ggb[i] = s.toCharArray();
        }
        Sheet sb = new Sheet(hb, wb, ggb);

        final int hx = sc.nextInt();
        final int wx = sc.nextInt();
        char[][] ggx = new char[hx][wx];
        for (int i = 0; i < hx; i++) {
            String s = sc.next();
            ggx[i] = s.toCharArray();
        }
        Sheet sx = new Sheet(hx, wx, ggx);

        for (int ai = -sa.h; ai < sa.h + sx.h; ai++) {
            for (int aj = -sa.w; aj < sa.w + sx.w; aj++) {
                for (int bi = -sb.h; bi < sb.h + sx.h; bi++) {
                    for (int bj = -sb.w; bj < sb.w + sx.w; bj++) {
                        char[][] yy = new char[sx.h][sx.w];
                        for (int i = 0; i < sx.h; i++) {
                            Arrays.fill(yy[i], '.');
                        }
                        boolean flg = true;
                        for (int i = 0; i < sa.h; i++) {
                            for (int j = 0; j < sa.w; j++) {
                                int ni = i + ai;
                                int nj = j + aj;

                                if (sa.cc[i][j] == '#') {
                                    if (ni >= 0 && ni < sx.h && nj >= 0 && nj < sx.w) {
                                        yy[ni][nj] = '#';
                                    } else {
                                        flg = false;
                                        break;
                                    }
                                }
                            }
                        }
                        if (!flg) {
                            continue;
                        }

                        for (int i = 0; i < sb.h; i++) {
                            for (int j = 0; j < sb.w; j++) {
                                int ni = i + bi;
                                int nj = j + bj;

                                if (sb.cc[i][j] == '#') {
                                    if (ni >= 0 && ni < sx.h && nj >= 0 && nj < sx.w) {
                                        yy[ni][nj] = '#';
                                    } else {
                                        flg = false;
                                        break;
                                    }
                                }
                            }
                        }
                        if (!flg) {
                            continue;
                        }
                        if (!Arrays.deepEquals(sx.cc, yy)) {
                            flg = false;
                        }

                        if (flg) {
                            System.out.println("Yes");
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("No");
    }

    static class Sheet {

        int h, w;
        char[][] cc;

        Sheet(int h, int w, char[][] cc) {
            this.h = h;
            this.w = w;
            this.cc = cc;

        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                       3 5
#.#..
.....
.#...
2 2
#.
.#
5 3
...
#.#
.#.
.#.
...
                    """;

        String expected = """
                          Yes
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC307C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test

    public void Case2() {

        String input = """
                       2 2
#.
.#
2 2
#.
.#
2 2
##
##
                    """;

        String expected = """
                          No
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC307C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                       1 1
#
1 2
##
1 1
#
                    """;

        String expected = """
                          No
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC307C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                       3 3
###
...
...
3 3
#..
#..
#..
3 3
..#
..#
###
                    """;

        String expected = """
                          Yes
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC307C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
