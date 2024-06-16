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
public class ABC185C {

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

        final int l = sc.nextInt();

        // L-1 C 11
        int left = l - 1;
        int right = 11;

        right = left - right;
        if (right == 0) {
            System.out.println(1);
            return;
        }

        int cnt = right;

        List<Integer> children = new ArrayList<>();
        List<Integer> mothers = new ArrayList<>();
        int cntt = 0;

        while (cntt < cnt) {
            children.add(left);
            left--;
            cntt++;
        }

        long m = 1;
        cntt = 0;
        while (cntt < cnt) {
            mothers.add(right);
            right--;
            cntt++;
        }

        long child = 1, mother = 1;

        for (var c : children) {
            if (!mothers.contains(c)) {
                child *= c;
            }
        }
        for (var mm : mothers) {
            if (!children.contains(mm)) {
                mother *= mm;
            }
        }

        System.out.println(child / mother);
    }
//}

    //@Test
    public void Case1() {

        String input = """
                       12
                    """;

        String expected = """
                          1
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC185C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case2() {

        String input = """
                       13
                    """;

        String expected = """
                          12
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC185C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       17
                    """;

        String expected = """
                          4368
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC185C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
