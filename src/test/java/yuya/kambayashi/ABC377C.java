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
public class ABC377C {

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

    static long cnt;
    static Set<Coord> set;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        cnt = 0;

        final long n = sc.nextInt();
        final int m = sc.nextInt();
        set = new HashSet<>();

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            a--;
            b--;
            makeTrue(a, b, n);
            makeTrue(a - 2, b - 1, n);
            makeTrue(a - 1, b - 2, n);
            makeTrue(a + 1, b - 2, n);
            makeTrue(a + 2, b - 1, n);
            makeTrue(a - 2, b + 1, n);
            makeTrue(a - 1, b + 2, n);
            makeTrue(a + 1, b + 2, n);
            makeTrue(a + 2, b + 1, n);
        }

        System.out.println(n * n - set.size());
    }

    static void makeTrue(int i, int j, long n) {
        if (0 <= i && i < n && 0 <= j && j < n) {
            set.add(new Coord(i, j));
        }
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
                       8 6
                       1 4
                       2 1
                       3 8
                       4 5
                       5 2
                       8 3
                    """;

        String expected = """
                          38
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC377C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       1000000000 1
                       1 1
                    """;

        String expected = """
                          999999999999999997
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC377C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       20 10
                       1 4
                       7 11
                       7 15
                       8 10
                       11 6
                       12 5
                       13 1
                       15 2
                       20 10
                       20 15
                    """;

        String expected = """
                          338
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC377C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC377C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
