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
public class ABC354C {

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

    static class Card {

        int a;
        int c;
        int index;

        Card(int a, int c, int index) {
            this.a = a;
            this.c = c;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        Card[] cards = new Card[n];
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int c = sc.nextInt();
            cards[i] = new Card(a, c, i);
        }
        Arrays.sort(cards, new Comparator<Card>() {
            @Override
            public int compare(Card l, Card r) {
                return Integer.compare(l.c, r.c);
            }
        });

        List<Integer> ans = new ArrayList<>();
        int v = 0;
        for (int i = 0; i < n; i++) {
            if (cards[i].a > v) {
                v = cards[i].a;
                ans.add(cards[i].index);
            }
        }
        Collections.sort(ans);
        System.out.println(ans.size());
        StringBuilder sb = new StringBuilder();
        for (int i : ans) {
            sb.append(i + 1);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());

    }

//}
    @Test
    public void Case1() {

        String input = """
                       3
                       2 4
                       1 1
                       3 2
                    """;

        String expected = """
                          2
                          2 3
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC354C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case2() {

        String input = """
                      5
                       1 1
                       10 2
                       100 3
                       1000 4
                       10000 5 
                    """;

        String expected = """
                          5
                          1 2 3 4 5
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC354C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                       6
                       32 101
                       65 78
                       2 29
                       46 55
                       103 130
                       52 40
                    """;

        String expected = """
                          4
                          2 3 5 6
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC354C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
