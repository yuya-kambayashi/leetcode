/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yuya.kambayashi;

import java.util.*;
import java.util.stream.*;
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
public class ABC337C {

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

        int[] bb = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();

            if (t == -1) {
                bb[0] = i;
            } else {
                bb[t] = i;
            }
        }

        int target = 0;

        List<Integer> order = new ArrayList<>();

        while (order.size() < n) {

            int a = bb[target];

            order.add(a + 1);

            target = a + 1;

            int aaa = 0;

        }

        String result = order.stream().map(Object::toString).collect(Collectors.joining(" "));

        System.out.println(result);
    }
//}

    //@Test
    public void Case1() {

        String input = """
                       6
                       4 1 -1 5 3 2
                    """;

        String expected = """
                          3 5 4 1 2 6
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC337C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case2() {

        String input = """
                       10
                       -1 1 2 3 4 5 6 7 8 9
                    """;

        String expected = """
                          1 2 3 4 5 6 7 8 9 10
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC337C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                      30
                       3 25 20 6 18 12 26 1 29 -1 21 17 23 9 8 30 10 15 22 27 4 13 5 11 16 24 28 2 19 7 
                    """;

        String expected = """
                          10 17 12 6 4 21 11 24 26 7 30 16 25 2 28 27 20 3 1 8 15 18 5 23 13 22 19 29 9 14
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC337C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
