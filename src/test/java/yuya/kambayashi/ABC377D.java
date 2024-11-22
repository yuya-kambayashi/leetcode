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
public class ABC377D {

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
//            Scanner sc = new Scanner(System.in);
//
//            final int n = sc.nextInt();
//            final int m = sc.nextInt();
//
//            int[] ll = new int[n];
//            int[] rr = new int[n];
//
//            for (int i = 0; i < n; i++) {
//                ll[i] = sc.nextInt();
//                rr[i] = sc.nextInt();
//            }
//            int[] excludeRange = new int[m + 2];
//            for (int i = 0; i < n; i++) {
//                excludeRange[ll[i]]++;
//                excludeRange[rr[i] + 1]--;
//            }
//            for (int i = 1; i <= m; i++) {
//                excludeRange[i] += excludeRange[i - 1];
//            }
//            long cnt = 0;
//            for (int left = 1; left <= m; left++) {
//                for (int right = left; right <= m; right++) {
//                    if (excludeRange[left] == 0 && excludeRange[right] == 0) {
//                        cnt++;
//                    }
//                }
//            }
//
//            System.out.println(cnt);
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] L = new int[N];
        int[] R = new int[N];
        for (int i = 0; i < N; i++) {
            L[i] = sc.nextInt();
            R[i] = sc.nextInt();
        }

        // 全てのペア (l, r) の組み合わせ数を計算
        long totalPairs = (long) M * (M + 1) / 2;

        // 各位置に区間が含まれるかを管理する配列
        int[] excludeRange = new int[M + 2];

        // 各区間について影響範囲をマーク
        for (int i = 0; i < N; i++) {
            excludeRange[L[i]]++;
            if (R[i] + 1 <= M) {
                excludeRange[R[i] + 1]--;
            }
        }

        // 累積和で影響範囲を計算
        for (int i = 1; i <= M; i++) {
            excludeRange[i] += excludeRange[i - 1];
        }

        // 有効なペアの累積和を管理
        long validPairs = 0;
        for (int l = 1; l <= M; l++) {
            for (int r = l; r <= M; r++) {
                if (excludeRange[r] == 0) {
                    validPairs++;
                } else {
                    break; // 含まれない範囲が現れたら終了
                }
            }
        }

        // 条件を満たす組み合わせの数を計算
        long result = totalPairs - validPairs;
        System.out.println(result);

        sc.close();

    }
//}

    @Test
    public void Case1() {

        String input = """
                       2 4
                       1 2
                       3 4
                    """;

        String expected = """
                          5
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC377D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       6 5
                       1 1
                       2 2
                       3 3
                       4 4
                       5 5
                       1 5
                    """;

        String expected = """
                          0
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC377D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       6 20
                       8 12
                       14 20
                       11 13
                       5 19
                       4 11
                       1 6
                    """;

        String expected = """
                          102
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC377D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC377D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
