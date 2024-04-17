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
public class ABC002D {

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
        final int m = sc.nextInt();
        int[][] xys = new int[m][2];
        for (int i = 0; i < m; i++) {
            xys[i][0] = sc.nextInt();
            xys[i][1] = sc.nextInt();
        }

        // 知り合いの関係をメモ化する
        boolean[][] connections = new boolean[n][n];
        for (int i = 0; i < m; i++) {
            int[] xy = xys[i];

            connections[xy[0] - 1][xy[1] - 1] = true;
            connections[xy[1] - 1][xy[0] - 1] = true;

        }
        // 国会議員のうち、任意の人数を取り出して、それらの間に人間関係があるかをチェックする
        int max = 0;
        for (int bit = 0; bit < 1 << n; bit++) {

            // 派閥候補のリストを取得する
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((bit & (1 << i)) >= 1) {
                    list.add(i);
                }
            }

            boolean ok = true;
            for (int i = 0; i < list.size(); i++) {

                for (int j = 0; j < list.size(); j++) {
                    if (i == j) {
                        continue;
                    }
                    if (!connections[list.get(i)][list.get(j)]) {
                        // 関係なし
                        ok = false;
                        break;
                    }
                }
                if (!ok) {
                    break;
                }
            }
            if (ok) {
                max = Math.max(max, list.size());
            }
        }
        if (max == 0) {
            max = 1;
        }

        System.out.println(max);
    }
//}

    // @Test
    public void Case1() {

        in.inputln("5 3");
        in.inputln("1 2");
        in.inputln("2 3");
        in.inputln("1 3");
        var expected = "3";

        ABC002D.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

    //@Test
    public void Case2() {

        in.inputln("5 3");
        in.inputln("1 2");
        in.inputln("2 3");
        in.inputln("3 4");
        var expected = "2";

        ABC002D.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void Case3() {
        in.inputln("7 9");
        in.inputln("1 2");
        in.inputln("1 3");
        in.inputln("2 3");
        in.inputln("4 5");
        in.inputln("4 6");
        in.inputln("4 7");
        in.inputln("5 6");
        in.inputln("5 7");
        in.inputln("6 7");
        var expected = "4";

        ABC002D.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

    //@Test
    public void Case4() {

        in.inputln("12 0");
        var expected = "1";

        ABC002D.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }
}

//import java.util.*;
//public class Main {
