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
public class ABC377E {

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

        int N = sc.nextInt();
        long K = sc.nextLong();
        int[] P = new int[N];
        for (int i = 0; i < N; i++) {
            P[i] = sc.nextInt() - 1; // 0-indexed に変換
        }

        // 各位置のサイクル情報を確認するための配列
        int[] finalPosition = new int[N];
        boolean[] visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                // サイクルを記録するためのリスト
                List<Integer> cycle = new ArrayList<>();
                int current = i;
                while (!visited[current]) {
                    visited[current] = true;
                    cycle.add(current);
                    current = P[current];
                }

                // サイクルの長さ
                int cycleLength = cycle.size();
                long effectiveK = K % cycleLength;

                // サイクル内の各位置を更新
                for (int j = 0; j < cycleLength; j++) {
                    int targetIndex = (int) ((j + effectiveK) % cycleLength);
                    finalPosition[cycle.get(j)] = cycle.get(targetIndex);
                }
            }
        }

        // 結果を出力するために finalPosition を調整
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[i] = finalPosition[i] + 1; // 1-indexed に戻す
        }

        // 結果を出力
        for (int i = 0; i < N; i++) {
            System.out.print(result[i]);
            if (i < N - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();

        sc.close();
    }
//}

    @Test
    public void Case1() {

        String input = """
                       6 3
                       5 6 3 1 2 4
                    """;

        String expected = """
                          6 1 3 2 4 5
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC377E.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       5 1000000000000000000
                       1 2 3 4 5
                    """;

        String expected = """
                          1 2 3 4 5
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC377E.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       29 51912426
                       7 24 8 23 6 1 4 19 11 18 20 9 17 28 22 27 15 2 12 26 10 13 14 25 5 29 3 21 16
                    """;

        String expected = """
                          18 23 16 24 21 10 2 27 19 7 12 8 13 5 15 26 17 4 3 9 1 22 25 14 28 11 29 6 20
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC377E.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC377E.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
