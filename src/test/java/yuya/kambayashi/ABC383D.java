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
public class ABC383D {

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

    static List<Boolean> isPrime = new ArrayList<>();

    public static List<Long> era(int n) {
        isPrime.clear();
        for (int i = 0; i < n; i++) {
            isPrime.add(true);
        }
        isPrime.set(0, false);
        isPrime.set(1, false);

        List<Long> res = new ArrayList<>();
        for (long i = 2; i < n; i++) {
            if (isPrime.get((int) i)) {
                res.add(i);
                for (long j = i * 2; j < n; j += i) {
                    isPrime.set((int) j, false);
                }
            }
        }
        return res;
    }

    // https://atcoder.jp/contests/abc383/submissions/60567364
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        List<Long> primes = era(1000005);

        long ans = 0;
        for (long p : primes) {
            if (p * p * p * p > n) {
                break;
            }

            if (p < 100) {
                if (p * p * p * p * p * p * p * p <= n) {
                    ans++;
                }
            }

            for (long q : primes) {
                if (q <= p) {
                    continue;
                }
                if (p * p * q * q <= n) {
                    ans++;
                } else {
                    break;
                }
            }
        }
        System.out.println(ans);
    }
//}

    @Test
    public void Case1() {

        String input = """
                       200
                    """;

        String expected = """
                          3
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC383D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       4000000000000
                    """;

        String expected = """
                          407073
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC383D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC383D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC383D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
