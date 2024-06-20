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
public class ABC229C {

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
        int w = sc.nextInt();
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pairs.add(new Pair(sc.nextLong(), sc.nextLong()));
        }
        Collections.sort(pairs, Comparator.comparingLong(Pair::getTaste));

        long tasteSum = 0;
        long weightRest = w;
        for (int i = n - 1; i >= 0; i--) {

            Pair p = pairs.get(i);

            if (weightRest <= p.weight) {

                tasteSum += p.taste * weightRest;
                weightRest = 0;
                break;
            } else {
                tasteSum += p.taste * p.weight;
                weightRest -= p.weight;
            }

        }
        System.out.println(tasteSum);
    }

    static class Pair {

        long taste, weight;

        Pair(long a, long b) {
            this.taste = a;
            this.weight = b;
        }

        long getTaste() {
            return taste;
        }
    }
//}

    //@Test
    public void Case1() {

        String input = """
                       3 5
                       3 1
                       4 2
                       2 3
                    """;

        String expected = """
                          15
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC229C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case2() {

        String input = """
                       4 100
                       6 2
                       1 5
                       3 9
                       8 7
                    """;

        String expected = """
                          100
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC229C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       10 3141
                       314944731 649
                       140276783 228
                       578012421 809
                       878510647 519
                       925326537 943
                       337666726 611
                       879137070 306
                       87808915 39
                       756059990 244
                       228622672 291
                    """;

        String expected = """
                          2357689932073
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC229C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
