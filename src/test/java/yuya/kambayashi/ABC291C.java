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
public class ABC291C {

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

        Set<Coord> set = new HashSet<>();
        Coord c = new Coord(0, 0);
        set.add(c);
        int beforeX = 0, beforeY = 0;
        for (int i = 0; i < n; i++) {
            Coord t = new Coord(beforeX, beforeY);
            switch (s.charAt(i)) {
                case 'R':
                    t.x++;
                    break;
                case 'L':
                    t.x--;
                    break;
                case 'U':
                    t.y++;
                    break;
                case 'D':
                    t.y--;
                    break;
            }
            if (set.contains(t)) {
                System.out.println("Yes");
                return;
            }
            set.add(t);

            beforeX = t.x;
            beforeY = t.y;
        }

        System.out.println("No");

    }

    static class Coord {

        int x, y;

        Coord(int x, int y) {
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
                       5
                       RLURU
                    """;

        String expected = """
                          Yes
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC291C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       20
                       URDDLLUUURRRDDDDLLLL
                    """;

        String expected = """
                          No
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC291C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC291C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
