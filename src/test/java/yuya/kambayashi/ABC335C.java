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
public class ABC335C {

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
//public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final int q = sc.nextInt();

        List<Coord> cc = new ArrayList<>();
        for (int i = n; i >= 1; i--) {
            cc.add(new Coord(i, 0));
        }

        for (int i = 0; i < q; i++) {
            int t = sc.nextInt();
            if (t == 1) {
                Coord head = new Coord(cc.get(cc.size() - 1).x, cc.get(cc.size() - 1).y);

                char c = sc.next().charAt(0);
                switch (c) {
                    case 'R':
                        head.x++;
                        break;
                    case 'L':
                        head.x--;
                        break;
                    case 'U':
                        head.y++;
                        break;
                    case 'D':
                        head.y--;
                        break;
                }
                cc.add(head);
            } else {
                int p = sc.nextInt();
                int len = cc.size() - 1;

                System.out.println(String.valueOf(cc.get(len - p + 1).x) + " " + String.valueOf(cc.get(len - p + 1).y));
            }
        }
    }

    static class Coord {

        int x, y;

        Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                       5 9
                       2 3
                       1 U
                       2 3
                       1 R
                       1 D
                       2 3
                       1 L
                       2 1
                       2 5
                    """;

        String expected = """
                          3 0
                          2 0
                          1 1
                          1 0
                          1 0
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC335C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
    //  @Test

    public void Case2() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC335C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC335C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
