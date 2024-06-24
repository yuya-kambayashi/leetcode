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
        if (pp.length == 2) {
            System.out.print(pp[1]);
            System.out.print(" ");
            System.out.print(pp[0]);
            return;
        }

        // 4 5 1 2 3
        // 5 1 -> 3 5
        // 4 3 5 (1, 2)
        // 4 3 5 2 1
        // 5 1 2 3
        // 5 1 -> 3 5
        // 3 5 (1, 2)
        // 3 5 2 1
        // 後ろから数えて単調現象する起点を取得
        int baseIndex = -1;
        for (int i = n - 1; i > 0; i--) {
            if (pp[i] > pp[i - 1]) {
                baseIndex = i;
                break;
            }
        }
        if (baseIndex == -1) {
            return;
        }

        // その単調減少が増える瞬間を取得
        int changeIndex = -1;
        for (int i = baseIndex - 1; i > 0; i--) {
            if (pp[i] < pp[i - 1]) {
                changeIndex = i - 1;
                break;
            }
        }
        if (changeIndex == -1) {
            for (int i = 0; i < baseIndex; i++) {
                System.out.print(pp[i]);
                System.out.print(" ");
            }
            System.out.print(pp[baseIndex + 1]);
            System.out.print(" ");
            System.out.print(pp[baseIndex]);
            System.out.print(" ");

            for (int i = baseIndex + 2; i < n; i++) {
                System.out.print(pp[i]);
                System.out.print(" ");
            }
            return;

        }

        // その増えた箇所＋その後ろに対して、一つちいさい数を作る
        int chanegeV1 = pp[changeIndex];
        int chanegeV2 = pp[changeIndex + 1];

        List<Integer> ss = new ArrayList<>();
        for (int i = changeIndex; i < n; i++) {
            ss.add(pp[i]);
        }
        Collections.sort(ss);

        int afterV1 = -1;
        int afterV2 = -1;

        // V2よりも小さい値がある場合
        if (ss.get(0) != chanegeV2) {

            int i = ss.indexOf(Integer.valueOf(chanegeV2));
            afterV1 = chanegeV1;
            afterV2 = ss.get(i - 1);

        } // V2よりも小さい値がない場合
        else {
            int i = ss.indexOf(Integer.valueOf(chanegeV1));
            afterV1 = ss.get(i - 1);
            afterV2 = ss.get(ss.size() - 1);
        }

        pp[changeIndex] = afterV1;
        pp[changeIndex + 1] = afterV2;

        ss.remove(Integer.valueOf(afterV1));
        ss.remove(Integer.valueOf(afterV2));

        if (changeIndex + 1 < n) {
            int j = ss.size() - 1;
            for (int i = changeIndex + 2; i < n; i++) {

                int v = ss.get(j);
                pp[i] = v;
                j--;
            }
        }
        for (var p : pp) {
            System.out.print(p);
            System.out.print(" ");

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

    //@Test
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
                       5
                       4 5 1 2 3
                    """;

        String expected = """
                          4 3 5 2 1
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC276C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                       4
                       5 1 2 3
                    """;

        String expected = """
                          3 5 2 1
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC276C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case5() {

        String input = """
                       2
                       3 2
                    """;

        String expected = """
                          2 3
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC276C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case6() {

        String input = """
                       3
                       1 3 2
                    """;

        String expected = """
                          1 2 3
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC276C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case7() {

        String input = """
                       4
                       1 3 2 1
                    """;

        String expected = """
                          1 2 3 1
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC276C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
