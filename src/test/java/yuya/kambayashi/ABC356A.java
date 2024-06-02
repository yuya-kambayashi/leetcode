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
public class ABC356A {

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
        final int l = sc.nextInt();
        final int r = sc.nextInt();

        int[] aa = new int[n];
        int[] aa2 = new int[n];
        for (int i = 0; i < n; i++) {
            aa[i] = i + 1;
            aa2[i] = i + 1;

        }

        int index = r - 1;

        for (int i = l - 1; i <= r - 1; i++) {
            aa[i] = aa2[index];
            index--;
        }

        StringBuilder sb = new StringBuilder();
        for (int a : aa) {
            sb.append(a);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);

        System.out.println(sb.toString());
    }
//}

    @Test
    public void Case1() {

        String input = """
                     5 2 3  
                    """;

        String expected = """
                          1 3 2 4 5
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC356A.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       7 1 1
                    """;

        String expected = """
                          1 2 3 4 5 6 7
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC356A.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       10 1 10
                    """;

        String expected = """
                          10 9 8 7 6 5 4 3 2 1
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC356A.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }
}
