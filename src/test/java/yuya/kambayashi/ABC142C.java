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
public class ABC142C {

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
        int[] aa = new int[n];
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            aa[i] = sc.nextInt();
            pairs.add(new Pair(aa[i], i + 1));
        }
        Collections.sort(pairs, Comparator.comparingInt(Pair::getKey));

        StringBuilder sb = new StringBuilder();
        for (Pair p : pairs) {
            sb.append(p.value);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);

        System.out.println(sb.toString());
    }

    static class Pair {

        int key;
        int value;

        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                       3
2 3 1
                    """;

        String expected = """
                          3 1 2
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC142C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       5
1 2 3 4 5
                    """;

        String expected = """
                          1 2 3 4 5
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC142C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       8
8 2 7 3 4 5 6 1
                    """;

        String expected = """
                          8 2 4 5 6 7 3 1
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC142C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }
}
