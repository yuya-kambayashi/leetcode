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
public class ABC276C {

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
        int[] pp = new int[n];
        for (int i = 0; i < n; i++) {
            pp[i] = sc.nextInt();
        }

        int j = n - 2;
        while (j >= 0 && pp[j] < pp[j + 1]) {
            j--;
        }

        int k = n - 1;
        while (pp[j] < pp[k]) {
            k--;
        }

        int temp = pp[j];
        pp[j] = pp[k];
        pp[k] = temp;

        reverse(pp, j + 1, n - 1);

        StringBuilder sb = new StringBuilder();
        for (int p : pp) {
            sb.append(p);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);

        System.out.println(sb.toString());

    }

    public static void reverse(int[] array, int start, int end) {
        while (start < end) {
            int t = array[start];
            array[start] = array[end];
            array[end] = t;
            start++;
            end--;
        }
    }

//}
    //@Test
    public void Case1() {

        String input = """
                       3
3 1 2
                    """;

        String expected = """
                          2 3 1
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC276C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       10
9 8 6 5 10 3 1 2 4 7
                    """;

        String expected = """
                          9 8 6 5 10 2 7 4 3 1
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC276C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case3() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC276C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
