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
public class ABC384D {

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

        // 入力の読み込み
        int N = sc.nextInt();
        long S = sc.nextLong();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        // 尺取り法で解く
        long currentSum = 0;
        int left = 0;

        // ループを最大 2N ではなく、理論的に必要な長さで制限
        for (int right = 0; right < 400000; right++) {
            // 現在の右端要素を追加
            currentSum += A[right % N];

            // 和がSを超えたら左端を縮める
            while (currentSum > S && left <= right) {
                currentSum -= A[left % N];
                left++;
            }

            // 和がSに一致したらYesを出力して終了
            if (currentSum == S) {
                System.out.println("Yes");
                return;
            }
        }

        // 見つからなければNoを出力
        System.out.println("No");
    }
//}

    @Test
    public void Case1() {

        String input = """
                       3 42
                       3 8 4
                    """;

        String expected = """
                          Yes
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC384D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       3 1
                       3 8 4
                    """;

        String expected = """
                          No
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC384D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       20 83298426
                       748 169 586 329 972 529 432 519 408 587 138 249 656 114 632 299 984 755 404 772
                    """;

        String expected = """
                          Yes
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC384D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case4() {

        String input = """
                       20 85415869
                       748 169 586 329 972 529 432 519 408 587 138 249 656 114 632 299 984 755 404 772
                    """;

        String expected = """
                          No
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC384D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
