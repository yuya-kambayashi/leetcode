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
public class ABC209C {

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

        int mod = 1000000007;

        final int n = sc.nextInt();
        int[] cc = new int[n];
        for (int i = 0; i < n; i++) {
            cc[i] = sc.nextInt();
        }
        Arrays.sort(cc);

        // 1 -> 1
        // 3 -> 1,2,3
        // 3 -> 1,2,3
        // 3 -> 1,2,3
        // 4 -> 1,2,3,4
        // 4 -> 1,2,3,4
        // 3 * 2* 2 * 1
        long ans = 1L;
        for (int i = 0; i < n; i++) {

            long t = (long) (cc[i] - i) % mod;

            ans *= t;
            ans %= mod;
        }

        // 1 3
        // 1 2
        // 1 3
        // 3 3 4 4
        // 1 2 3 4
        // 1 2 4 3
        // 1 3 2 4
        // 1 3 4 2
        // 2 3 1 4
        // 2 3 4 1
        // 2 1 3 4
        // 2 1 4 3
        // 3 1 2 4
        // 3 1 4 2
        // 3 2 1 4
        // 3 2 4 1
        System.out.println(ans % mod);
    }
//}

    //@Test
    public void Case1() {

        String input = """
                       2
1 3
                    """;

        String expected = """
                          2
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC209C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    // @Test
    public void Case2() {

        String input = """
                       4
3 3 4 4
                    """;

        String expected = """
                          12
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC209C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    //@Test
    public void Case3() {

        String input = """
                       2
1 1
                    """;

        String expected = """
                          0
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC209C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    @Test
    public void Case4() {

        String input = """
                       10
                       999999917 999999914 999999923 999999985 999999907 999999965 999999914 999999908 999999951 999999979
                    """;

        String expected = """
                          405924645
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC209C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }
}
