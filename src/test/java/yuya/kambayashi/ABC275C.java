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
public class ABC275C {

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

        final int n = 9;
        List<Pair> pp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < n; j++) {
                if (s.charAt(j) == '#') {
                    pp.add(new Pair(i, j));
                }
            }
        }
        int size = pp.size();
        int ans = 0;
        for (int bit = 0; bit < 1 << size; bit++) {
            List<Pair> tt = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if ((bit & (1 << i)) >= 1) {
                    tt.add(pp.get(i));
                }
            }
            if (tt.size() != 4) {
                continue;
            }
            if (isSquare(tt)) {
                ans++;
            }
        }

        System.out.println(ans);
    }

    static boolean isSquare(List<Pair> pp) {
        List<Integer> dist = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                int dx = pp.get(i).x - pp.get(j).x;
                int dy = pp.get(i).y - pp.get(j).y;

                dist.add(dx * dx + dy * dy);
            }
        }
        Collections.sort(dist);
        int l = dist.get(0);
        if (l == 0) {
            return false;
        }
        return dist.get(0) == l
                && dist.get(1) == l
                && dist.get(2) == l
                && dist.get(3) == l
                && dist.get(4) == l * 2
                && dist.get(5) == l * 2;
    }

    static class Pair {

        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                       ##.......
##.......
.........
.......#.
.....#...
........#
......#..
.........
.........
                    """;

        String expected = """
                          2
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC275C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       .#.......
#.#......
.#.......
.........
....#.#.#
.........
....#.#.#
........#
.........
                    """;

        String expected = """
                          3
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC275C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC275C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC275C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
