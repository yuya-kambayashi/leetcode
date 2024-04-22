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
public class ABC350C {

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
        List<Integer> aa = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            aa.add(sc.nextInt());
        }

        int[] pos = new int[aa.size()];

        for (int i = 0; i < n; i++) {

            pos[i] = aa.indexOf(i + 1);

        }

        int cnt = 0;
        List<int[]> ans = new ArrayList<>();
        for (int i = 1; i < n; i++) {

            // すでにその値であれば何もしない
            if (pos[i - 1] == i - 1) {
                continue;
            }

            // どこにあるか
            int indexOfTarget = pos[i - 1];
            // 置き換え対象
            int vt = aa.get(i - 1);

            cnt++;
            int[] tt = {i, indexOfTarget + 1};
            ans.add(tt);

            aa.set(i - 1, i);
            aa.set(indexOfTarget, vt);

            pos[i - 1] = i;
            pos[vt - 1] = indexOfTarget;

            int ttt = 0;

        }

        if (cnt == 0) {
            System.out.println(0);
        } else {
            System.out.println(cnt);
            for (var a : ans) {
                String t = a[0] + " " + a[1];
                System.out.println(t);

            }

        }

    }

//}
    @Test
    public void Case1() {

        String input = """
                       5
                       3 4 1 2 5
                    """;

        String expected = """
                          2
                          1 3
                          2 4
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC350C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       4
                       1 2 3 4
                    """;

        String expected = """
                          0
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC350C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       3
                       3 1 2
                    """;

        String expected = """
                          2
                          1 2
                          2 3
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC350C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }
}

//import java.util.*;
//public class Main {
