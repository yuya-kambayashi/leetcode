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
public class ABC363D {

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

        final long n = sc.nextLong();

        System.out.println(nthPalindromicNumber(n));
    }

    private static List<Long> generatePalindromes(int halfDigits, boolean isOdd) {
        List<Long> palindromes = new ArrayList<>();
        long start = (long) Math.pow(10, halfDigits - 1);
        long end = (long) Math.pow(10, halfDigits);

        for (long i = start; i < end; i++) {
            String half = Long.toString(i);
            String palindrome;
            if (isOdd) {
                palindrome = half + new StringBuilder(half).reverse().substring(1);
            } else {
                palindrome = half + new StringBuilder(half).reverse().toString();
            }
            palindromes.add(Long.parseLong(palindrome));
        }

        return palindromes;
    }

    public static long nthPalindromicNumber(long n) {
        long count = 10; // 1から9の1桁の回文数は9個
        int halfDigits = 1;

        if (n <= 9) {
            return n;
        }

        while (true) {
            halfDigits++;
            long numHalfPalindromes = 9 * (long) Math.pow(10, halfDigits - 1);

            if (count + 2 * numHalfPalindromes >= n) {
                boolean isOdd = (n - count) <= numHalfPalindromes;
                return generatePalindromes(halfDigits, isOdd).get((int) ((n - count - 1) % numHalfPalindromes));
            }

            count += 2 * numHalfPalindromes;
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                       46
                    """;

        String expected = """
                          363
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC363D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       1
                    """;

        String expected = """
                          0
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC363D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                       1000000000000000000
                    """;

        String expected = """
                          90000000000000000000000000000000009
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC363D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
