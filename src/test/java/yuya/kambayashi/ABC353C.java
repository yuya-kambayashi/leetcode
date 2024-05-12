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
public class ABC353C {

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

        final int p = 100000000;

        final int n = sc.nextInt();
        long[] aa = new long[n];
        for (int i = 0; i < n; i++) {
            aa[i] = sc.nextLong();
        }
        Arrays.sort(aa);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (n - 1) * aa[i];
        }
        long cnt = 0;
        for (int i = 0; i < n; i++) {
            int left = i + 1, right = n;
            while (left < right) {
                int mid = (left + right) / 2;
                if ((aa[i] + aa[mid]) >= p) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            cnt += n - left;
        }
        System.out.println(sum - cnt * p);
    }
//}

    @Test
    public void Case1() {

        String input = """
                       3
                       3 50000001 50000002
                    """;

        String expected = """
                          100000012
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC353C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       5
                       1 3 99999999 99999994 1000000
                    """;

        String expected = """
                          303999988
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC353C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    @Test
    public void Case31() {

        String input = """
                       2
                       99999999 99999999
                    """;

        String expected = """
                          99999998
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC353C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       5
                       99999999 99999999 99999999 99999999 99999999
                    """;

        String expected = """
                          999999980
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC353C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    @Test
    public void Case4() {

        String input = """
                       2
                       1 2
                    """;

        String expected = """
                          3
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC353C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    @Test
    public void Case5() {

        String input = """
                       2
                       50000000 50000000
                    """;

        String expected = """
                          0
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC353C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }
}
