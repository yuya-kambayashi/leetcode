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
public class ABC367C {

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
        final int k = sc.nextInt();
        int[] rr = new int[n];
        for (int i = 0; i < n; i++) {
            rr[i] = sc.nextInt();
        }
        List<List<Integer>> result = new ArrayList<>();
        int[] num = new int[n];
        generateCombinations(result, rr, num, 0, n, k);

        for (var combi : result) {
            for (var v : combi) {
                System.out.print(v);
                System.out.print(" ");
            }
            System.out.println();
        }

    }

    static void generateCombinations(List<List<Integer>> result, int[] rr, int[] num, int index, int n, int k) {
        if (index == n) {
            if (check(num, k)) {
                List<Integer> combi = new ArrayList<>(n);
                for (int v : num) {
                    combi.add(v);
                }
                result.add(combi);
            }
            return;
        }

        for (int i = 1; i <= rr[index]; i++) {
            num[index] = i;
            generateCombinations(result, rr, num, index + 1, n, k);
        }
    }

    static boolean check(int[] num, int k) {
        int sum = 0;
        for (int v : num) {
            sum += v;
        }
        return sum % k == 0;
    }
//}

    @Test
    public void Case1() {

        String input = """
                       3 2
                       2 1 3
                    """;

        String expected = """
                          1 1 2
                          2 1 1
                          2 1 3
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC367C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                        1 2
                       1
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC367C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       5 5
                       2 3 2 3 2
                    """;

        String expected = """
                          1 1 1 1 1
                          1 2 2 3 2
                          1 3 1 3 2
                          1 3 2 2 2
                          1 3 2 3 1
                          2 1 2 3 2
                          2 2 1 3 2
                          2 2 2 2 2
                          2 2 2 3 1
                          2 3 1 2 2
                          2 3 1 3 1
                          2 3 2 1 2
                          2 3 2 2 1
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC367C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
    // @Test

    public void Case4() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC367C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
