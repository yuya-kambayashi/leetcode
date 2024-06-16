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
public class ABC333C {

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
//https://qiita.com/hyouchun/items/2385b686d133329be6fe
//import java.math.*;
//import java.util.*;
//import java.util.stream.*
//public class Main {

    public static long repunit(int length) {
        return Long.parseLong("1".repeat(length));
    }

    public static void main(String[] args) {
        Set<Long> repunit3Set = new HashSet<>();
        for (int i = 1; i <= 12; i++) {
            for (int j = 1; j <= 12; j++) {
                for (int k = 1; k <= 12; k++) {
                    long value = repunit(i) + repunit(j) + repunit(k);
                    repunit3Set.add(value);
                }
            }
        }

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.close();

        Long[] repunit3Array = repunit3Set.toArray(new Long[0]);
        Arrays.sort(repunit3Array);
        System.out.println(repunit3Array[N - 1]);
    }

//}
    @Test
    public void Case1() {

        String input = """
                       5
                    """;

        String expected = """
                          113
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC333C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //  @Test
    public void Case2() {

        String input = """
                       19
                    """;

        String expected = """
                          2333
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC333C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                       333
                    """;

        String expected = """
                          112222222233
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC333C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
