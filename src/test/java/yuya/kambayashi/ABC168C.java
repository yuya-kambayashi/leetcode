/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yuya.kambayashi;

import java.awt.geom.Point2D;
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
public class ABC168C {

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
//import java.awt.geom.Point2D;
//import java.math.*;
//import java.util.*;
//import java.util.stream.*;
//public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int a = sc.nextInt();
        final int b = sc.nextInt();
        final int h = sc.nextInt();
        final int m = sc.nextInt();

        // 短針
        double angles = Math.toRadians(30 * h + (double) m / 2);
        Point2D ps = new Point2D.Double(b * Math.sin(angles), b * Math.cos(angles));
        // 長針
        double anglel = Math.toRadians(6 * m);
        Point2D pl = new Point2D.Double(a * Math.sin(anglel), a * Math.cos(anglel));

        System.out.println(Math.abs(ps.distance(pl)));
    }
//}

    @Test
    public void Case1() {

        String input = """
                       3 4 9 0
                    """;

        String expected = """
                          5.00000000000000000000
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC168C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       3 4 10 40
                    """;

        String expected = """
                          4.56425719433005567605
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC168C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC168C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }
}
