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
public class ABC361B {

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

        final int xLB1 = sc.nextInt();
        final int yLB1 = sc.nextInt();
        final int zLB1 = sc.nextInt();
        final int xRT1 = sc.nextInt();
        final int yRT1 = sc.nextInt();
        final int zRT1 = sc.nextInt();

        final int xLB2 = sc.nextInt();
        final int yLB2 = sc.nextInt();
        final int zLB2 = sc.nextInt();
        final int xRT2 = sc.nextInt();
        final int yRT2 = sc.nextInt();
        final int zRT2 = sc.nextInt();

        String ret = "No";
        if (col(xLB1, xRT1, xLB2, xRT2) && col(yLB1, yRT1, yLB2, yRT2) && col(zLB1, zRT1, zLB2, zRT2)) {
            ret = "Yes";
        }
        System.out.println(ret);

    }

    static boolean col(int a, int b, int c, int d) {
        if ((a < d) && (c < b)) {
            return true;
        }
        return false;
    }
//}

    @Test
    public void Case1() {

        String input = """
                       0 0 0 4 5 6
                       2 3 4 5 6 7
                    """;

        String expected = """
                          Yes
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC361B.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       0 0 0 2 2 2
                       0 0 2 2 2 4
                    """;

        String expected = """
                          No
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC361B.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       0 0 0 1000 1000 1000
                       10 10 10 100 100 100
                    """;

        String expected = """
                          Yes
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC361B.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }
}
