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
public class ABC219C {

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

        final String s = sc.next();
        final int n = sc.nextInt();

        Map<Character, Integer> map = new HashMap<>();
        int index = 0;
        for (char c : s.toCharArray()) {
            map.put(c, index);
            index++;
        }
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) {
            ss[i] = sc.next();
        }
        Arrays.sort(ss, new Comparator<String>() {

            @Override
            public int compare(String l, String r) {

                if (l.equals(r)) {
                    return 0;
                }

                int index = 0;
                while (true) {

                    if (l.length() == index && r.length() == index) {
                        return 0;
                    }
                    if (l.length() == index) {
                        return -1;
                    }
                    if (r.length() == index) {
                        return 1;
                    }

                    char lt = l.charAt(index);
                    char rt = r.charAt(index);

                    if (lt != rt) {
                        return Integer.compare(map.get(lt), map.get(rt));
                    }
                    index++;
                }

            }
        });
        for (String t : ss) {
            System.out.println(t);
        }
    }

//}
    @Test
    public void Case1() {

        String input = """
                       bacdefghijklmnopqrstuvwxzy
                       4
                       abx
                       bzz
                       bzy
                       caa
                    """;

        String expected = """
                          bzz
                          bzy
                          abx
                          caa
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC219C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       zyxwvutsrqponmlkjihgfedcba
                       5
                       a
                       ab
                       abc
                       ac
                       b
                    """;

        String expected = """
                          b
                          a
                          ac
                          ab
                          abc
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC219C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC219C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
