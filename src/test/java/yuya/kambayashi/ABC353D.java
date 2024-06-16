/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yuya.kambayashi;

import java.math.BigInteger;
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
public class ABC353D {

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

        final int p = 998244353;

        final int n = sc.nextInt();
        long[] aa = new long[n];
        for (int i = 0; i < n; i++) {
            aa[i] = sc.nextLong();
        }

        BigInteger sum = BigInteger.ZERO;

        for (long bit = 0; bit < 1 << n; bit++) {

            int[] check = new int[n];
            Arrays.fill(check, 0);

            for (int i = 0; i < n; i++) {

                if ((bit & (1 << i)) >= 1) {
                    check[i] = 1;
                }
            }
            int cnt = 0;
            for (int c : check) {
                if (c == 1) {
                    cnt++;
                }
            }
            if (cnt != 2) {
                continue;
            }

            StringBuilder sb = new StringBuilder();
            int ii = 0;
            for (int i = 0; i < n; i++) {
                if (check[i] != 1) {
                    continue;
                }

                sb.append(aa[i]);
            }

            sum = sum.add(BigInteger.valueOf(Long.parseLong(sb.toString())));

        }

        BigInteger ans = sum.remainder(BigInteger.valueOf(p));

        System.out.println(ans);
    }
//}

    @Test
    public void Case1() {

        String input = """
                       3
                       3 14 15
                    """;

        String expected = """
                          2044
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC353D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       5
                       1001 5 1000000 1000000000 100000
                    """;

        String expected = """
                          625549048
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC353D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC353D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
