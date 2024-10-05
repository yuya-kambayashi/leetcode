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
public class ABC372C {

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
        final int q = sc.nextInt();
        final String s = sc.next();

        char[] ca = s.toCharArray();

        Set<Integer> heads = new HashSet<>();

        // 最初に "ABC" を探して heads に登録
        for (int j = 0; j < s.length() - 2; j++) {
            if (ca[j] == 'A' && ca[j + 1] == 'B' && ca[j + 2] == 'C') {
                heads.add(j);
            }
        }

        for (int i = 0; i < q; i++) {
            int x = sc.nextInt() - 1;  // 0-indexed に調整
            char c = sc.next().charAt(0);

            // 更新前に "ABC" の影響範囲にある箇所を削除
            for (int j = Math.max(0, x - 2); j <= Math.min(n - 3, x); j++) {
                if (ca[j] == 'A' && ca[j + 1] == 'B' && ca[j + 2] == 'C') {
                    heads.remove(j);
                }
            }

            // 更新
            ca[x] = c;

            // 更新後に "ABC" の影響範囲に新しい "ABC" が存在するかを確認
            for (int j = Math.max(0, x - 2); j <= Math.min(n - 3, x); j++) {
                if (ca[j] == 'A' && ca[j + 1] == 'B' && ca[j + 2] == 'C') {
                    heads.add(j);
                }
            }

            // 現在の "ABC" の数を出力
            System.out.println(heads.size());
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                       7 4
                       ABCDABC
                       4 B
                       3 A
                       5 C
                       4 G
                    """;

        String expected = """
                          2
                          1
                          1
                          0
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC372C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       3 3
                       ABC
                       1 A
                       2 B
                       3 C
                    """;

        String expected = """
                          1
                          1
                          1
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC372C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       15 10
                       BBCCBCACCBACACA
                       9 C
                       11 B
                       5 B
                       11 B
                       4 A
                       8 C
                       8 B
                       5 B
                       7 B
                       14 B
                    """;

        String expected = """
                          0
                          0
                          0
                          0
                          1
                          1
                          2
                          2
                          1
                          1
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC372C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC372C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
