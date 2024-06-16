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
public class ABC315C {

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
        int[] ff = new int[n];
        int[] ss = new int[n];
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ff[i] = sc.nextInt();
            ss[i] = sc.nextInt();
            pairs.add(new Pair(ff[i], ss[i]));
        }
        Collections.sort(pairs, Comparator.comparingInt(Pair::getS));

        // 同じ味のmax
        int max1 = 0;
        int maxf = pairs.get(pairs.size() - 1).f;
        for (int i = pairs.size() - 2; i >= 0; i--) {
            if (pairs.get(i).f == maxf) {
                max1 = pairs.get(pairs.size() - 1).s + pairs.get(i).s / 2;
                break;
            }
        }
        // 違う味のmax
        int max2 = 0;
        for (int i = pairs.size() - 2; i >= 0; i--) {
            if (pairs.get(i).f != maxf) {
                max2 = pairs.get(pairs.size() - 1).s + pairs.get(i).s;
                break;
            }
        }
        System.out.println(Math.max(max1, max2));
    }

    static class Pair {

        int f, s;

        public Pair(int f, int s) {
            this.f = f;
            this.s = s;
        }

        public int getS() {
            return s;
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                       4
1 4
2 10
2 8
3 6
                    """;

        String expected = """
                          16
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC315C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       4
4 10
3 2
2 4
4 12
                    """;

        String expected = """
                          17
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC315C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC315C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
