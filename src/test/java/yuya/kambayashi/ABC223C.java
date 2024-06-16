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
public class ABC223C {

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
        double[] aa = new double[n];
        double[] bb = new double[n];
        for (int i = 0; i < n; i++) {
            aa[i] = (double) sc.nextInt();
            bb[i] = (double) sc.nextInt();
        }
        double[] cc = new double[n];
        for (int i = 0; i < n; i++) {
            cc[i] = aa[i] / bb[i];
        }
        double sum = 0;
        for (var c : cc) {
            sum += c;
        }
        double time = sum / 2;

        double len = 0;
        double t = 0;
        int index = 0;
        while (true) {
            if (t + cc[index] <= time) {
                len += aa[index];
                t += cc[index];
                index++;
            } else {
                break;
            }
        }
        double rest = time - t;
        len += rest * bb[index];

        System.out.println(len);
    }
//}

    @Test
    public void Case1() {

        String input = """
                       3
1 1
2 1
3 1
                    """;

        String expected = """
                          3.000000000000000
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC223C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       3
1 3
2 2
3 1
                    """;

        String expected = """
                          3.833333333333333
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC223C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       5
3 9
1 2
4 6
1 5
5 3
                    """;

        String expected = """
                          8.916666666666668
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC223C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
