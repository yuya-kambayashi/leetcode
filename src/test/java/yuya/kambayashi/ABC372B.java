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
public class ABC372B {

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

        int n = sc.nextInt();

        int p10 = (int) Math.pow(3, 10);
        int p9 = (int) Math.pow(3, 9);
        int p8 = (int) Math.pow(3, 8);
        int p7 = (int) Math.pow(3, 7);
        int p6 = (int) Math.pow(3, 6);
        int p5 = (int) Math.pow(3, 5);
        int p4 = (int) Math.pow(3, 4);
        int p3 = (int) Math.pow(3, 3);
        int p2 = (int) Math.pow(3, 2);
        int p1 = (int) Math.pow(3, 1);
        int p0 = (int) Math.pow(3, 0);

        int ans = 0;
        List<Integer> list = new ArrayList<>();

        while (n >= p10) {
            ans++;
            list.add(10);
            n -= p10;
        }
        while (n >= p9) {
            ans++;
            list.add(9);
            n -= p9;
        }

        while (n >= p8) {
            ans++;
            list.add(8);
            n -= p8;
        }
        while (n >= p7) {
            ans++;
            list.add(7);
            n -= p7;
        }
        while (n >= p6) {
            ans++;
            list.add(6);
            n -= p6;
        }
        while (n >= p5) {
            ans++;
            list.add(5);
            n -= p5;
        }
        while (n >= p4) {
            ans++;
            list.add(4);
            n -= p4;
        }
        while (n >= p3) {
            ans++;
            list.add(3);
            n -= p3;
        }
        while (n >= p2) {
            ans++;
            list.add(2);
            n -= p2;
        }
        while (n >= p1) {
            ans++;
            list.add(1);
            n -= p1;
        }
        while (n >= p0) {
            ans++;
            list.add(0);
            n -= p0;
        }

        System.out.println(ans);
        for (var a : list) {
            System.out.print(a);
            System.out.print(" ");
        }
        System.out.println();

    }
//}

    @Test
    public void Case0() {

        String input = """
                      78732 
                    """;

        String expected = """
                          2
                          10 9
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC372B.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case1() {

        String input = """
                      6 
                    """;

        String expected = """
                          2
                          1 1
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC372B.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       100
                    """;

        String expected = """
                          4
                          2 0 2 4
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC372B.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                      59048 
                    """;

        String expected = """
                          20
                          0 0 1 1 2 2 3 3 4 4 5 5 6 6 7 7 8 8 9 9
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC372B.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC372B.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
