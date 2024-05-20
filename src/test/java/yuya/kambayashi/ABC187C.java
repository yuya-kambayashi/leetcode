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
public class ABC187C {

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
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) {
            ss[i] = sc.next();
        }

        Map<String, Pair> map = new HashMap<>();
        for (String s : ss) {

            String t = s.replaceAll("!", "");

            if (s.charAt(0) == '!') {

                if (map.containsKey(t)) {

                    Pair p = map.get(t);
                    p.second++;
                    map.put(t, p);
                } else {
                    Pair p = new Pair(0, 1);
                    map.put(t, p);
                }
            } else {
                if (map.containsKey(t)) {
                    Pair p = map.get(t);
                    p.first++;
                    map.put(t, p);
                } else {
                    Pair p = new Pair(1, 0);
                    map.put(t, p);
                }
            }
        }

        for (Map.Entry<String, Pair> entry : map.entrySet()) {

            int v1 = entry.getValue().first;
            int v2 = entry.getValue().second;

            if (0 < v1 && 0 < v2) {
                System.out.println(entry.getKey());
                return;
            }
        }

        System.out.println("satisfiable");
    }

    static class Pair {

        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int hashCode() {
            return 31 * first + second;
        }

        public boolean equals(Object obj) {
            Pair other = (Pair) obj;

            return this.first == other.first && this.second == other.second;
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                       6
                       a
                       !a
                       b
                       !c
                       d
                       !d
                    """;

        String expected = """
                          a
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC187C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       10
                       red
                       red
                       red
                       !orange
                       yellow
                       !blue
                       cyan
                       !green
                       brown
                       !gray
                    """;

        String expected = """
                          satisfiable
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC187C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    //@Test
    public void Case3() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC187C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }
}
