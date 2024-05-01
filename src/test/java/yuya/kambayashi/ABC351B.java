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
public class ABC351B {

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
//import java.util.*;
//import java.util.stream.Collectors;
//public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();

        String[] sa = new String[n];
        String[] sb = new String[n];

        for (int i = 0; i < n; i++) {
            sa[i] = sc.next();
        }
        for (int i = 0; i < n; i++) {
            sb[i] = sc.next();
        }

        for (int i = 0; i < n; i++) {
            if (sa[i].equals(sb[i])) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (sa[i].charAt(j) == sb[i].charAt(j)) {
                    continue;
                }
                System.out.println(String.valueOf(i + 1) + " " + String.valueOf(j + 1));

            }
        }

    }
//}

    @Test
    public void Case1() {

        String input = """
                       3
                       abc
                       def
                       ghi
                       abc
                       bef
                       ghi
                    """;

        String expected = """
                          2 1
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC351B.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       1
                       f
                       q
                    """;

        String expected = """
                          1 1
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC351B.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       10
                       eixfumagit
                       vtophbepfe
                       pxbfgsqcug
                       ugpugtsxzq
                       bvfhxyehfk
                       uqyfwtmglr
                       jaitenfqiq
                       acwvufpfvv
                       jhaddglpva
                       aacxsyqvoj
                       eixfumagit
                       vtophbepfe
                       pxbfgsqcug
                       ugpugtsxzq
                       bvfhxyehok
                       uqyfwtmglr
                       jaitenfqiq
                       acwvufpfvv
                       jhaddglpva
                       aacxsyqvoj
                    """;

        String expected = """
                          5 9
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC351B.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }
}

//import java.util.*;
//public class Main {
