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
public class ABC362B {

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

        final int xa = sc.nextInt();
        final int ya = sc.nextInt();
        final int xb = sc.nextInt();
        final int yb = sc.nextInt();
        final int xc = sc.nextInt();
        final int yc = sc.nextInt();

        double ab2 = Math.pow(xa - xb, 2) + Math.pow(ya - yb, 2);
        double bc2 = Math.pow(xb - xc, 2) + Math.pow(yb - yc, 2);
        double ca2 = Math.pow(xc - xa, 2) + Math.pow(yc - ya, 2);

        if (ab2 > bc2 && ab2 > ca2) {
            if (ab2 == bc2 + ca2) {
                System.out.println("Yes");
                return;
            } else {
                System.out.println("No");
                return;
            }
        } else if (bc2 > ab2 && bc2 > ca2) {
            if (bc2 == ab2 + ca2) {
                System.out.println("Yes");
                return;
            } else {
                System.out.println("No");
                return;
            }
        } else if (ca2 > ab2 && ca2 > bc2) {
            if (ca2 == ab2 + bc2) {
                System.out.println("Yes");
                return;
            } else {
                System.out.println("No");
                return;
            }
        }

        System.out.println("No");
    }
//}

    @Test
    public void Case1() {

        String input = """
                       0 0
                       4 0
                       0 3
                    """;

        String expected = """
                          Yes
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC362B.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       -4 3
                       2 1
                       3 4
                    """;

        String expected = """
                          Yes
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC362B.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       2 4
                       -3 2
                       1 -2
                    """;

        String expected = """
                          No
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC362B.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
