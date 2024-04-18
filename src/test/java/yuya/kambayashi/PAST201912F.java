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
public class PAST201912F {

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

        final String s = sc.next();

        List<String> list = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (i == 0) {
                sb.append(c);
            } else {
                sb.append(c);
                if (sb.length() > 1 && Character.isUpperCase(c)) {
                    list.add(sb.toString());
                    sb.setLength(0);
                }
            }
        }

        list.sort(String.CASE_INSENSITIVE_ORDER);

        sb.setLength(0);
        list.stream().forEach(t -> sb.append(t));

        System.out.println(sb.toString());
    }
//}

    @Test
    public void Case1() {

        String input = """
                      FisHDoGCaTAAAaAAbCAC 
                    """;

        var expected = "AAAaAAbCACCaTDoGFisH";

        Stream.of(input.split("\\n")).forEach(s -> in.inputln(s));
        PAST201912F.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void Case2() {

        String input = """
                      AAAAAjhfgaBCsahdfakGZsZGdEAA 
                    """;

        var expected = "AAAAAAAjhfgaBCsahdfakGGdEZsZ";

        Stream.of(input.split("\\n")).forEach(s -> in.inputln(s));
        PAST201912F.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

    // @Test
    public void Case3() {

        String input = """
                       
                    """;

        var expected = "";

        Stream.of(input.split("\\n")).forEach(s -> in.inputln(s));
        PAST201912F.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }
}

//import java.util.*;
//public class Main {
