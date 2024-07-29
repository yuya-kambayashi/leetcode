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
public class ABC364D {

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
        int[] bb = new int[q];
        int[] kk = new int[q];
        for (int i = 0; i < n; i++) {
            aa[i] = sc.nextInt();
        }
        for (int i = 0; i < q; i++) {
            bb[i] = sc.nextInt();
            kk[i] = sc.nextInt();
        }

        Arrays.sort(aa);
        long[] dist = new long[n];
        dist[0] = 0;
        for (int i = 1; i < n; i++) {
            dist[i] = dist[i - 1] + aa[i] - aa[i - 1];
        }
        for (int i = 0; i < n; i++) {
            int b = bb[i];
            int k = kk[i];

            int t = Arrays.binarySearch(aa, b);
            if (t >= 0) {

                for (int j = 0; j < k; j++) {
                }

                long tt = dist[t + k] - dist[t];
                System.out.println(tt);

            } else {

                int p = -(t + 1);
                long distToStart = dist[p] - b;

                if (k == 1) {
                    System.out.println(distToStart);
                } else {
                    int 
                }

                aaa = 0;

            }
        }

        System.out.println();
    }
//}

    @Test
    public void Case1() {

        String input = """
                       4 3
                       -3 -1 5 6
                       -2 3
                       2 1
                       10 4
                    """;

        String expected = """
                          7
                          3
                          13
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC364D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //  @Test
    public void Case2() {

        String input = """
                       2 2
                       0 0
                       0 1
                       0 2
                    """;

        String expected = """
                          0
                          0
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC364D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                       10 5
                       -84 -60 -41 -100 8 -8 -52 -62 -61 -76
                       -52 5
                       14 4
                       -2 6
                       46 2
                       26 7
                    """;

        String expected = """
                          11
                          66
                          59
                          54
                          88
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC364D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC364D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
