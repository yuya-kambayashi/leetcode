/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yuya.kambayashi;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
public class ABC308C {

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

        int[] aa = new int[n + 1];
        int[] bb = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            aa[i] = sc.nextInt();
            bb[i] = sc.nextInt();
        }
        List<Pair> cc = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (aa[i] == 0 && bb[i] == 0) {
                cc.add(new Pair(i, new BigDecimal(0)));
            } else {
                BigDecimal a = new BigDecimal(aa[i]);
                BigDecimal b = new BigDecimal(bb[i]);
                BigDecimal ab = new BigDecimal(aa[i] + bb[i]);

                cc.add(new Pair(i, a.divide(ab, 40, RoundingMode.HALF_UP)));
            }
        }
        Collections.sort(cc, new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                if (p1.c.equals(p2.c)) {
                    return Integer.compare(p1.id, p2.id);
                }
                return p2.c.compareTo(p1.c);
            }
        });

        for (var c : cc) {
            System.out.print(c.id);
            System.out.print(" ");
        }
    }

    static class Pair {

        int id;
        BigDecimal c;

        public Pair(int id, BigDecimal c) {
            this.id = id;
            this.c = c;
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                       3
1 3
3 1
2 2
                    """;

        String expected = """
                          2 3 1
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC308C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       2
1 3
2 6
                    """;

        String expected = """
                          1 2
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC308C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       4
999999999 1000000000
333333333 999999999
1000000000 999999997
999999998 1000000000
                    """;

        String expected = """
                          3 1 4 2
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC308C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC308C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
