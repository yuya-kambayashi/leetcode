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
public class ABC298C {

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
        final int q = sc.nextInt();
        Map<Integer, Map<Integer, Integer>> mapBox2Card = new HashMap<>();
        Map<Integer, Set<Integer>> mapCard2Box = new HashMap<>();
        for (int i = 0; i < q; i++) {
            switch (sc.nextInt()) {
                case 1:
                    int card = sc.nextInt();
                    int box = sc.nextInt();

                    if (mapBox2Card.containsKey(box)) {
                        var m = mapBox2Card.get(box);
                        if (m.containsKey(card)) {
                            m.put(card, m.get(card) + 1);
                        } else {
                            m.put(card, 1);
                        }
                        mapBox2Card.put(box, m);
                    } else {
                        var m = new TreeMap<Integer, Integer>();
                        m.put(card, 1);
                        mapBox2Card.put(box, m);
                    }

                    if (mapCard2Box.containsKey(card)) {
                        var v = mapCard2Box.get(card);
                        v.add(box);
                        mapCard2Box.put(card, v);
                    } else {
                        var v = new TreeSet<Integer>();
                        v.add(box);
                        mapCard2Box.put(card, v);
                    }

                    break;

                case 2:
                    int m = sc.nextInt();
                    for (var e : mapBox2Card.get(m).entrySet()) {
                        for (int j = 0; j < e.getValue(); j++) {
                            System.out.print(e.getKey());
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                    break;
                case 3:
                    int p = sc.nextInt();

                    for (var v : mapCard2Box.get(p)) {
                        System.out.print(v);
                        System.out.print(" ");
                    }
                    System.out.println();
                    break;

            }
        }
        sc.close();
    }
//}

    @Test
    public void Case1() {

        String input = """
                       5
8
1 1 1
1 2 4
1 1 4
2 4
1 1 4
2 4
3 1
3 2
                    """;

        String expected = """
                          1 2
1 1 2
1 4
4
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC298C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test

    public void Case2() {

        String input = """
                       1
5
1 1 1
1 2 1
1 200000 1
2 1
3 200000
                    """;

        String expected = """
                          1 2 200000
1
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC298C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC298C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC298C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
