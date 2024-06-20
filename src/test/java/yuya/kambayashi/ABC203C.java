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
        long k = sc.nextInt();

        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pairs.add(new Pair(sc.nextLong(), sc.nextInt()));
        }
        Collections.sort(pairs, Comparator.comparingLong(Pair::getVIndex));

        long moneyRest = k;
        long pindex = 0;

        for (int i = 0; i < n; i++) {
            Pair p = pairs.get(i);
            if (p.vindex > moneyRest) {
                break;
            }
            moneyRest += p.money;
        }
        System.out.println(moneyRest);
    }

    static class Pair {

        long vindex;
        int money;

        Pair(long vindex, int money) {
            this.vindex = vindex;
            this.money = money;
        }

        long getVIndex() {
            return vindex;
        }

    }
//}

    // @Test
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

    //@Test
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
