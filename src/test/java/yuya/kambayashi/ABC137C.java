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
public class ABC137C {

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
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            var saa = s.split("");
            Arrays.sort(saa);
            sa[i] = String.join("", saa);
        }

        Map<String, Long> map = new HashMap<>();
        for (var s : sa) {
            map.put(s, map.getOrDefault(s, 0L) + 1);
        }

        long ans = 0;
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            long v = entry.getValue().longValue();
            ans += v * (v - 1) / 2;
        }

        System.out.println(ans);
    }
//}

    @Test
    public void Case1() {

        String input = """
3
                    acornistnt
                    peanutbomb
                    constraint
                    """;

        var expected = "1";

        Stream.of(input.split("\\n")).forEach(s -> in.inputln(s));

        ABC137C.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void Case2() {

        String input = """
                    5
                    abaaaaaaaa
                    oneplustwo
                    aaaaaaaaba
                    twoplusone
                    aaaabaaaaa
                    """;

        var expected = "4";

        Stream.of(input.split("\\n")).forEach(s -> in.inputln(s));
        ABC137C.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void Case3() {

        String input = """
2
oneplustwo
ninemodsix
                    """;

        var expected = "0";

        Stream.of(input.split("\\n")).forEach(s -> in.inputln(s));

        ABC137C.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }
}

//import java.util.*;
//public class Main {
