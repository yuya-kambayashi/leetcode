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
public class ABC367D {

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
        Scanner scanner = new Scanner(System.in);

        // 入力の読み取り
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        // 累積和の計算
        int[] cumulativeSum = new int[N + 1];
        for (int i = 0; i < N; i++) {
            cumulativeSum[i + 1] = cumulativeSum[i] + A[i];
        }

        // 全ての(s, t)ペアを調べる
        int count = 0;
        for (int s = 0; s < N; s++) {
            for (int t = 0; t < N; t++) {
                if (s == t) {
                    continue;
                }

                // s から t までの時計回りの距離
                int clockwiseDistance = (s < t)
                        ? cumulativeSum[t] - cumulativeSum[s]
                        : cumulativeSum[N] - (cumulativeSum[s] - cumulativeSum[t]);

                // t から s までの反時計回りの距離
                int counterClockwiseDistance = cumulativeSum[N] - clockwiseDistance;

                // 最小距離を選択
                int minDistance = Math.min(clockwiseDistance, counterClockwiseDistance);

                // 最小距離が M の倍数かどうかをチェック
                if (minDistance % M == 0) {
                    count++;
                }
            }
        }

        // 結果の出力
        System.out.println(count);

        scanner.close();
    }

//}
    @Test
    public void Case1() {

        String input = """
                       4 3
                       2 1 4 3
                    """;

        String expected = """
                          4
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC367D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       2 1000000
                       1 1
                    """;

        String expected = """
                          0
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC367D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       9 5
                       9 9 8 2 4 4 3 5 3
                    """;

        String expected = """
                          11
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC367D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC367D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
