/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yuya.kambayashi;

import java.util.*;
import java.util.stream.Collectors;
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
public class ABC306C {

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
        int[] aa = new int[n * 3];
        for (int i = 0; i < n * 3; i++) {
            aa[i] = sc.nextInt();
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {

            for (int j = 0; j < n * 3; j++) {
                if (aa[j] == i) {
                    if (map.containsKey(i)) {

                        var list = map.get(i);
                        list.add(j + 1);
                        map.put(i, list);

                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(j + 1);
                        map.put(i, list);
                    }
                }
            }
        }

        List<Integer> midList = new ArrayList<>();
        for (var i : map.values()) {
            midList.add(i.get(1));
        }
        Collections.sort(midList);

        int[] ans = new int[n];

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {

            int t = entry.getValue().get(1);
            for (int i = 0; i < n; i++) {
                if (midList.get(i).intValue() == t) {
                    ans[i] = entry.getKey();
                    break;
                }
            }

        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(ans[i]);
            if (i != n - 1) {
                sb.append(" ");
            }
        }

        System.out.println(sb.toString());

    }
//}

    @Test
    public void Case1() {

        String input = """
                       3
                       1 1 3 2 3 2 2 3 1
                    """;

        String expected = """
                          1 3 2
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC306C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       1
                       1 1 1
                    """;

        String expected = """
                          1
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC306C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       4
                       2 3 4 3 4 1 3 1 1 4 2 2
                    """;

        String expected = """
                          3 4 1 2
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC306C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }
}
