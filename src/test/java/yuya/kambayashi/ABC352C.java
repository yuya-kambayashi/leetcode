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
public class ABC352C {

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
        int[] aa = new int[n];
        int[] bb = new int[n];
        for (int i = 0; i < n; i++) {
            aa[i] = sc.nextInt();
            bb[i] = sc.nextInt();
        }

        int diffMax = 0;
        for (int i = 0; i < n; i++) {
            diffMax = Math.max(diffMax, bb[i] - aa[i]);
        }

        long ans = 0;
        for (int a : aa) {
            ans += a;
        }
        System.out.println(ans + diffMax);
    }
//}

    @Test
    public void Case1() {

        String input = """
                       3
                       4 10
                       5 8
                       2 9
                    """;

        String expected = """
                          18
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC352C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       5
                       1 1
                       1 1
                       1 1
                       1 1
                       1 1
                    """;

        String expected = """
                          5
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC352C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       10
                       690830957 868532399
                       741145463 930111470
                       612846445 948344128
                       540375785 925723427
                       723092548 925021315
                       928915367 973970164
                       563314352 832796216
                       562681294 868338948
                       923012648 954764623
                       691107436 891127278
                    """;

        String expected = """
                          7362669937
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC352C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }
}
