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
public class ABC203C {

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
        int k = sc.nextInt();
        List<Pair> pp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pp.add(new Pair(sc.nextLong(), sc.nextInt()));
        }

        Collections.sort(pp, Comparator.comparingLong(Pair::getI));

        long t = k;

        for (int i = 0; i < n; i++) {
            var p = pp.get(i);

            // tまではたどり着けるので、その先と村のiを比較する
            if (t < p.i) {
                System.out.println(t);
                return;
            } else {
                t += p.m;
            }
        }
        System.out.println(t);
    }

    static class Pair {

        long i;
        int m;

        Pair(long i, int m) {
            this.i = i;
            this.m = m;
        }

        long getI() {
            return i;
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                       2 3
                       2 1
                       5 10
                    """;

        String expected = """
                          4
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC203C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       5 1000000000
                       1 1000000000
                       2 1000000000
                       3 1000000000
                       4 1000000000
                       5 1000000000
                    """;

        String expected = """
                          6000000000
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC203C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       3 2
                       5 5
                       2 1
                       2 2
                    """;

        String expected = """
                          10
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC203C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
