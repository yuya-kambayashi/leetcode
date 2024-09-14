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
public class ABC371A {

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

        final String sAB = sc.next();
        final String sAC = sc.next();
        final String sBC = sc.next();

        if (sAB.equals(">") && sAC.equals("<")) {
            System.out.println("A");
        } else if (sAB.equals("<") && sAC.equals(">")) {
            System.out.println("A");
        } else if (sAB.equals("<") && sBC.equals("<")) {
            System.out.println("B");
        } else if (sAB.equals(">") && sBC.equals(">")) {
            System.out.println("B");
        } else if (sAC.equals("<") && sBC.equals(">")) {
            System.out.println("C");
        } else if (sAC.equals(">") && sBC.equals("<")) {
            System.out.println("C");
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                       < < <
                    """;

        String expected = """
                          B
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC371A.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       < < >
                    """;

        String expected = """
                          C
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC371A.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC371A.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC371A.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
