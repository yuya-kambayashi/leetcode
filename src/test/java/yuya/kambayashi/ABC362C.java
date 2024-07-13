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
public class ABC362C {

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
        long[] ll = new long[n];
        long[] rr = new long[n];
        for (int i = 0; i < n; i++) {
            ll[i] = sc.nextLong();
            rr[i] = sc.nextLong();
        }

        long left = 0, right = 0;

        for (int i = 0; i < n - 1; i++) {
            left += ll[i];
            right += rr[i];
        }

        long rangeLeft = -right;
        long rangeRight = -left;

        if (rr[n - 1] < rangeLeft || rangeRight < ll[n - 1]) {

            System.out.println("No");
            return;
        } else {
            List<Long> ans = new ArrayList<>();
            long sum = 0;
            for (int i = 0; i < n; i++) {
                ans.add(ll[i]);
                sum += ll[i];
            }
            long diff = -sum;

            if (diff != 0) {
                for (int i = 0; i < n; i++) {
                    long canAdd = rr[i] - ll[i];

                    if (diff == 0) {
                        break;
                    }

                    if (diff > canAdd) {
                        ans.set(i, ll[i] + canAdd);
                        diff -= canAdd;
                    } else if (diff == canAdd) {
                        ans.set(i, ll[i] + diff);
                        diff = 0;
                    } else if (diff < canAdd) {
                        ans.set(i, ll[i] + diff);
                        diff = 0;
                    }
                }
            }

            System.out.println("Yes");
            for (long a : ans) {
                System.out.print(a);
                System.out.print(" ");

            }
            return;
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                       3
                       3 5
                       -4 1
                       -2 3
                    """;

        String expected = """
                          Yes
                          4 -3 -1
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC362C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       3
                       1 2
                       1 2
                       1 2
                    """;

        String expected = """
                          No
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC362C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       6
                       -87 12
                       -60 -54
                       2 38
                       -76 6
                       87 96
                       -17 38
                    """;

        String expected = """
                          Yes
                          -66 -57 31 -6 89 9
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC362C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
