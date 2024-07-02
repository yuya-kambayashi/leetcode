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
public class ABC360C {

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
        int[] ww = new int[n];
        for (int i = 0; i < n; i++) {
            aa[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            ww[i] = sc.nextInt();
        }

        List<Pair> pp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pp.add(new Pair(i + 1, aa[i], ww[i]));
        }
        Collections.sort(pp, Comparator.comparingInt(Pair::getWeight));
        Collections.reverse(pp);

        Map<Integer, List<Pair>> map = new HashMap<>();
        for (var p : pp) {
            if (map.containsKey(p.a)) {
                var l = map.get(p.a);
                l.add(p);
                map.put(p.a, l);
            } else {
                List<Pair> l = new ArrayList<>();
                l.add(p);
                map.put(p.a, l);
            }
        }

        long sum = 0;
        for (var v : map.values()) {
            if (v.size() > 1) {
                // 一番重いもの以外を動かす
                for (int i = 1; i < v.size(); i++) {
                    sum += v.get(i).weight;
                }
            }
        }

        System.out.println(sum);
    }

    static class Pair {

        int id, a, weight;

        Pair(int id, int a, int weight) {
            this.id = id;
            this.a = a;
            this.weight = weight;
        }

        int getWeight() {
            return weight;
        }

    }
//}

    @Test
    public void Case1() {

        String input = """
                       5
                       2 2 3 3 5
                       33 40 2 12 16
                    """;

        String expected = """
                          35
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC360C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       12
                       3 6 7 4 12 4 8 11 11 1 8 11
                       3925 9785 9752 3587 4013 1117 3937 7045 6437 6208 3391 6309
                    """;

        String expected = """
                          17254
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC360C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case3() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC360C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
