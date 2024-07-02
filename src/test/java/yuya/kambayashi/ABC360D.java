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
public class ABC360D {

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
        final int t = sc.nextInt();
        final String s = sc.next();
        char[] inputs = s.toCharArray();

        TreeMap<Long, Integer> lefts = new TreeMap<>();
        List<Long> rights = new ArrayList<>();

        long[] xx = new long[n];
        for (int i = 0; i < n; i++) {
            long x = sc.nextInt();

            if (inputs[i] == '0') {
                lefts.put(x, lefts.getOrDefault(x, 0) + 1);
            } else {
                rights.add(x);
            }
        }
        lefts.put(Long.MIN_VALUE, 0);
        int sum = 0;
        for (long x : lefts.keySet()) {
            sum += lefts.get(x);
            lefts.put(x, sum);
        }
        long ans = 0;
        for (long x : rights) {
            ans += lefts.floorEntry(x + t * 2).getValue() - lefts.floorEntry(x).getValue();
        }
        System.out.println(ans);

    }
//}

    @Test
    public void Case1() {

        String input = """
                       6 3
                       101010
                       -5 -1 0 1 2 4
                    """;

        String expected = """
                          5
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC360D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //  @Test
    public void Case2() {

        String input = """
                       13 656320850
                       0100110011101
                       -900549713 -713494784 -713078652 -687818593 -517374932 -498415009 -472742091 -390030458 -379340552 -237481538 -44636942 352721061 695864366
                    """;

        String expected = """
                          14
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC360D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC360D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
