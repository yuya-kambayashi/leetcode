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
public class ABC235C {

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

        int[] aa = new int[n];
        for (int i = 0; i < n; i++) {
            aa[i] = sc.nextInt();
        }
        int[] xx = new int[q];
        int[] kk = new int[q];
        for (int i = 0; i < q; i++) {
            xx[i] = sc.nextInt();
            kk[i] = sc.nextInt();
        }

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int a = aa[i];
            if (map.containsKey(a)) {
                var list = map.get(a);
                list.add(i + 1);
                map.put(a, list);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i + 1);
                map.put(a, list);
            }

        }
        for (int i = 0; i < q; i++) {
            int x = xx[i];
            int k = kk[i];

            if (map.containsKey(x)) {

                var list = map.get(x);

                int ret = -1;
                if (k <= list.size()) {
                    ret = list.get(k - 1);
                }
                System.out.println(String.valueOf(ret));
            } else {
                System.out.println(String.valueOf(-1));
            }
        }
    }

//}
    @Test
    public void Case1() {

        String input = """
                       6 8
                       1 1 2 3 1 2
                       1 1
                       1 2
                       1 3
                       1 4
                       2 1
                       2 2
                       2 3
                       4 1
                    """;

        String expected = """
                          1
                          2
                          5
                          -1
                          3
                          6
                          -1
                          -1
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC235C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //  @Test
    public void Case2() {

        String input = """
                       3 2
                       0 1000000000 999999999
                       1000000000 1
                       123456789 1
                    """;

        String expected = """
                          2
                          -1
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC235C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC235C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
