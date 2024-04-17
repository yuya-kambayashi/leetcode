/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yuya.kambayashi;

import java.util.*;
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
public class S8PC4B {

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
        final int k = sc.nextInt();
        int[] aa = new int[n];
        for (int i = 0; i < n; i++) {
            aa[i] = sc.nextInt();
        }

        // 操作する建物のパターンをビットで表現する
        int minCost = Integer.MAX_VALUE;
        for (int bit = 0; bit < 1 << n; bit++) {

            // 対象の建物のインデックス
            List<Integer> targets = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {

                if ((bit & (1 << i)) >= 1) {
                    targets.add(i);
                }
            }
            if (targets.size() != k) {
                continue;
            }

            int cost = 0;

            // 基準となる高さ
            int baseHeight = aa[targets.get(0)];

            // 基準よりも左側が高い場合はそこまで引き上げる
            int leftHeight = 0;
            for (int i = 0; i < targets.get(0); i++) {
                leftHeight = Math.max(leftHeight, aa[i]);
            }
            // 同じ高さ→1m高くする // 基準のほうが大きい→1m高くする
            if (baseHeight == leftHeight) {
                cost += 1;
                baseHeight += 1;
            } // 基準のほうが大きい→1m高くする
            else if (baseHeight > leftHeight) {
                // 何もしない
            } // 基準のほうが低い　→　そのまま
            else {
                cost += leftHeight - baseHeight + 1;
                baseHeight = leftHeight + 1;
            }

            for (int i = 1; i < targets.size(); i++) {
                int t = aa[targets.get(i)];

                // 同じ高さ→1m高くする // 基準のほうが大きい→1m高くする
                if (baseHeight == t) {
                    cost += 1;
                    baseHeight += 1;
                } // 基準のほうが大きい→1m高くする
                else if (baseHeight > t) {
                    cost += baseHeight - t + 1;
                    baseHeight += 1;
                } // 基準のほうが低い　→　そのまま
                else {
                    baseHeight = t;
                }
            }
            minCost = Math.min(minCost, cost);
        }

        System.out.println(minCost);
    }
//}

    //@Test
    public void Case1() {

        in.inputln("5 5");
        in.inputln("3949 3774 3598 3469 3424");
        var expected = "1541";

        S8PC4B.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void Case2() {

        in.inputln("5 3");
        in.inputln("7 4 2 6 4");
        var expected = "7";

        S8PC4B.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

    // @Test
    public void Case3() {

        in.inputln("");
        var expected = "";

        S8PC4B.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }
}

//import java.util.*;
//public class Main {
