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
public class ABC364C {

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
        final long x = sc.nextLong();
        final long y = sc.nextLong();

        long[] aa = new long[n];
        long[] bb = new long[n];
        for (int i = 0; i < n; i++) {
            aa[i] = sc.nextLong();
        }
        for (int i = 0; i < n; i++) {
            bb[i] = sc.nextLong();
        }
        List<Pair> pp = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            pp.add(new Pair(aa[i], bb[i]));
        }
        Collections.sort(pp, Comparator.comparingLong(Pair::getA));
        Collections.reverse(pp);

        int cntA = 0, cntB = 0;
        long sumA = 0, sumB = 0;
        int i = 0;
        while (i < pp.size()) {
            sumA += pp.get(i).a;
            cntA++;

            if (sumA > x) {
                break;
            } else {
                i++;
            }
        }
        Collections.sort(pp, Comparator.comparingLong(Pair::getB));
        Collections.reverse(pp);
        i = 0;
        while (i < pp.size()) {
            sumB += pp.get(i).b;
            cntB++;

            if (sumB > y) {
                break;
            } else {
                i++;
            }
        }

        System.out.println(Math.min(cntA, cntB));

    }

    static class Pair {

        long a, b;

        Pair(long a, long b) {
            this.a = a;
            this.b = b;
        }

        long getA() {
            return a;
        }

        long getB() {
            return b;
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                       4 7 18
                       2 3 5 1
                       8 8 1 4
                    """;

        String expected = """
                          2
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC364C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       5 200000000000000 200000000000000
                       1 1 1 1 1
                       2 2 2 2 2
                    """;

        String expected = """
                          5
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC364C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       8 30 30
                       1 2 3 4 5 6 7 8
                       8 7 6 5 4 3 2 1
                    """;

        String expected = """
                          6
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC364C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC364C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
