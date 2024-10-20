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
public class ABC218D {

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

        List<Coord> cc = new ArrayList<>();
        Set<Coord> cc2 = new HashSet<>();
        for (int i = 0; i < n; i++) {
            cc.add(new Coord(sc.nextInt(), sc.nextInt()));
            cc2.add(cc.get(i));
        }

        int cnt = 0;

        HashSet<HashSet<Coord>> used = new HashSet<>();

        for (int i = 0; i < n; i++) {
            var c1 = cc.get(i);

            for (int j = i + 1; j < n; j++) {
                var c2 = cc.get(j);

                if (c1.x == c2.x || c1.y == c2.y) {
                    continue;
                }

                var c3 = new Coord(c1.x, c2.y);
                var c4 = new Coord(c2.x, c1.y);

                if (cc2.contains(c3) && cc2.contains(c4)) {

                    HashSet<Coord> uu = new HashSet<>();
                    uu.add(c1);
                    uu.add(c2);
                    uu.add(c3);
                    uu.add(c4);

                    if (!used.contains(uu)) {
                        cnt++;
                        used.add(uu);
                    }
                }
            }
        }
        System.out.println(cnt);

    }

    static class Coord {

        int x, y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int hashCode() {
            return 31 * x + y;
        }

        public boolean equals(Object obj) {
            Coord other = (Coord) obj;

            return this.x == other.x && this.y == other.y;
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                       6
0 0
0 1
1 0
1 1
2 0
2 1
                    """;

        String expected = """
                          3
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC218D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       4
0 1
1 2
2 3
3 4
                    """;

        String expected = """
                          0
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC218D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       7
0 1
1 0
2 0
2 1
2 2
3 0
3 2
                    """;

        String expected = """
                          1
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC218D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC218D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
