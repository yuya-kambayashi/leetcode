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
public class PAST202005E {

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
//import java.util.*;
//import java.util.stream.Collectors;
//public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final int m = sc.nextInt();
        final int q = sc.nextInt();

        ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> ar = new ArrayList<>();
            al.add(ar);
        }
        //int[] ua = new int[m];
        //int[] va  = new int[m];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;

            al.get(a).add(b);
            al.get(b).add(a);

        }
        int[] ca = new int[n];
        for (int i = 0; i < n; i++) {
            ca[i] = sc.nextInt();
        }
        List<int[]> queries = new ArrayList<>();
        for (int i = 0; i < q; i++) {

            int t = sc.nextInt();
            if (t == 1) {

                int[] ta = new int[2];
                ta[0] = 1;
                ta[1] = sc.nextInt();
                queries.add(ta);

            } else if (t == 2) {
                int[] ta = new int[3];
                ta[0] = 2;
                ta[1] = sc.nextInt();
                ta[2] = sc.nextInt();
                queries.add(ta);
            }
        }

        for (var query : queries) {

            int color = ca[query[1] - 1];

            System.out.println(color);

            if (query[0] == 1) {

                List<Integer> neighbours = al.get(query[1] - 1);

                for (Integer neighbour : neighbours) {
                    ca[neighbour] = color;
                }

            } else {
                ca[query[1] - 1] = query[2];
            }

        }
        int a = 0;
    }
//}

    @Test
    public void Case1() {

        String input = """
                       3 2 3
                       1 2
                       2 3
                       5 10 15
                       1 2
                       2 1 20
                       1 1
                    """;

        String expected = """
                          10
                          10
                          20
                          """;
        Stream.of(input.split("\\n")).forEach(s -> in.inputln(s));
        PAST202005E.main(null);
        Stream.of(expected.split("\\n")).forEach(s -> assertThat(out.readLine()).isEqualTo(s));

    }

    @Test
    public void Case2() {

        String input = """
                        30 10 20
                       11 13
                       30 14
                       6 4
                       7 23
                       30 8
                       17 4
                       6 23
                       24 18
                       26 25
                       9 3
                       18 4 36 46 28 16 34 19 37 23 25 7 24 16 17 41 24 38 6 29 10 33 38 25 47 8 13 8 42 40
                       2 1 9
                       1 8
                       1 9
                       2 20 24
                       2 26 18
                       1 20
                       1 26
                       2 24 31
                       1 4
                       2 21 27
                       1 25
                       1 29
                       2 10 14
                       2 2 19
                       2 15 36
                       2 28 6
                       2 13 5
                       1 12
                       1 11
                       2 14 43               
                    """;

        String expected = """
                          18
                          19
                          37
                          29
                          8
                          24
                          18
                          25
                          46
                          10
                          18
                          42
                          23
                          4
                          17
                          8
                          24
                          7
                          25
                          16
                    """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        PAST202005E.main(null);

        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                       
                    """;

        var expected = "";

        Stream.of(input.split("\\n")).forEach(s -> in.inputln(s));
        PAST202005E.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }
}

//import java.util.*;
//public class Main {
