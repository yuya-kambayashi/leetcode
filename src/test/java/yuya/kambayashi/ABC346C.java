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
public class ABC346C {

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

//https://qiita.com/hyouri/items/61502e81521b2a2009b5
//import java.math.*;
//import java.util.*;
//public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final int k = sc.nextInt();

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());

        }
        BigInteger bk = new BigInteger(String.valueOf(k));
        BigInteger bk2 = new BigInteger(String.valueOf(1));
        bk2 = bk2.add(bk);

        BigInteger b2 = new BigInteger("2");

        BigInteger ansb = (bk.multiply(bk2)).divide(b2);

        long ans = k * (k + 1) / 2;
        for (int a : set) {
            if (1 <= a && a <= k) {
                ansb = ansb.subtract(new BigInteger(String.valueOf(a)));
            }
        }

        System.out.println(ansb.longValue());

    }
//}

    // @Test
    public void Case1() {

        String input = """
                      4 5
                       1 6 3 1 
                    """;

        String expected = """
                          11
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC346C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    //@Test
    public void Case2() {

        String input = """
                       1 3
                       346
                    """;

        String expected = """
                          6
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC346C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       10 158260522
                       877914575 24979445 623690081 262703497 24979445 1822804784 1430302156 1161735902 923078537 1189330739
                    """;

        String expected = """
                          12523196466007058
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC346C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }
}

//import java.util.*;
//public class Main {
