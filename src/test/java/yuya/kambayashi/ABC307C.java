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

        int h = sc.nextInt();
        int w = sc.nextInt();
        char[][] cc = new char[h][w];
        for (int i = 0; i < h; i++) {
            String s = sc.next();
            cc[i] = s.toCharArray();
        }
        Sheet sa = new Sheet(h, w, cc);

        h = sc.nextInt();
        w = sc.nextInt();
        cc = new char[h][w];
        for (int i = 0; i < h; i++) {
            String s = sc.next();
            cc[i] = s.toCharArray();
        }
        Sheet sb = new Sheet(h, w, cc);

        h = sc.nextInt();
        w = sc.nextInt();
        cc = new char[h][w];
        for (int i = 0; i < h; i++) {
            String s = sc.next();
            cc[i] = s.toCharArray();
        }
        Sheet sx = new Sheet(h, w, cc);

        for (int i = -sa.h; i < sa.h + sx.h; i++) {
            for (int j = -sa.w; j < sa.w + sx.w; j++) {
                for (int k = -sb.h; k < sb.h + sx.h; k++) {
                    for (int l = -sb.w; l < sb.w + sb.w; l++) {
                        char[][] dd = new char[sx.h][sx.w];
                        for (int p = 0; p < sx.h; p++) {
                            Arrays.fill(dd[p], '.');
                        }
                        boolean useAll = true;
                        for (int p = 0; p < sa.h; p++) {
                            for (int q = 0; q < sa.w; q++) {
                                int ai = i + p;
                                int aj = j + q;
                                if (sa.cc[p][q] == '#') {
                                    if (0 <= ai && ai < sx.h && 0 <= aj && aj < sx.w) {

                                        dd[ai][aj] = '#';
                                    } else {
                                        useAll = false;
                                        break;
                                    }
                                }
                            }
                        }
                        if (!useAll) {
                            continue;
                        }
                        for (int p = 0; p < sb.h; p++) {
                            for (int q = 0; q < sb.w; q++) {
                                int ai = k + p;
                                int aj = l + q;
                                if (sb.cc[p][q] == '#') {
                                    if (0 <= ai && ai < sx.h && 0 <= aj && aj < sx.w) {
                                        dd[ai][aj] = '#';
                                    } else {
                                        useAll = false;
                                        break;
                                    }
                                }
                            }
                        }
                        if (!useAll) {
                            continue;
                        }
                        if (Arrays.deepEquals(dd, sx.cc)) {
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

        public Sheet(int h, int w, char[][] cc) {
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
