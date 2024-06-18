/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yuya.kambayashi;

import java.util.*;
import java.util.stream.Collectors;
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
public class ABC306C {

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
        int n3 = 3 * n;
        int[] aa = new int[n3];
        for (int i = 0; i < n3; i++) {
            aa[i] = sc.nextInt();
        }
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n3; i++) {
            int a = aa[i];
            if (map.containsKey(a)) {
                map.get(a).add(i + 1);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i + 1);
                map.put(a, list);
            }
        }
        List<Pair> pairs = new ArrayList<>();
        for (var entry : map.entrySet()) {
            pairs.add(new Pair(entry.getKey(), entry.getValue().get(1)));
        }
        Collections.sort(pairs, Comparator.comparingInt(Pair::getF));

        for (var pair : pairs) {
            System.out.print(pair.index);
            System.out.print(" ");
        }

    }

    static class Pair {

        int index, f;

        Pair(int index, int f) {
            this.index = index;
            this.f = f;
        }

        public int getF() {
            return f;
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                       3
                       1 1 3 2 3 2 2 3 1
                    """;

        String expected = """
                          1 3 2
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC306C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       1
                       1 1 1
                    """;

        String expected = """
                          1
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC306C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       4
                       2 3 4 3 4 1 3 1 1 4 2 2
                    """;

        String expected = """
                          3 4 1 2
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC306C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
