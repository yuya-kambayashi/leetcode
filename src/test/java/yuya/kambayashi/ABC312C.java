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
public class ABC312C {

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
        final int m = sc.nextInt();
        int[] aa = new int[n];
        int[] bb = new int[m];
        int[] cc = new int[n + m];
        for (int i = 0; i < n; i++) {
            aa[i] = sc.nextInt();
            cc[i] = aa[i];
        }
        for (int i = 0; i < m; i++) {
            bb[i] = sc.nextInt();
            cc[n + i] = bb[i] + 1;
        }
        Arrays.sort(aa);
        Arrays.sort(bb);
        Arrays.sort(cc);

        int seller = 0, noBuyer = 0;
        for (int i = 0; i < n + m; i++) {
            int c = cc[i];

            while (seller < n && c >= aa[seller]) {
                seller++;
            }

            while (noBuyer < m && c > bb[noBuyer]) {
                noBuyer++;
            }

            if (seller >= m - noBuyer) {
                System.out.println(c);
                return;
            }
        }
        System.out.println(0);

    }
//}

    @Test
    public void Case1() {

        String input = """
                       3 4
110 90 120
100 80 120 10000
                    """;

        String expected = """
                          110
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC312C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       5 2
100000 100000 100000 100000 100000
100 200
                    """;

        String expected = """
                          201
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC312C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       3 2
100 100 100
80 120
                    """;

        String expected = """
                          100
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC312C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC312C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
