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
public class ABC147C {

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
        int[] as = new int[n];
        List<ArrayList<int[]>> xyss = new ArrayList<ArrayList<int[]>>();
        for (int i = 0; i < n; i++) {
            as[i] = sc.nextInt();

            ArrayList<int[]> xys = new ArrayList<>();
            for (int j = 0; j < as[i]; j++) {

                int[] xy = new int[]{sc.nextInt(), sc.nextInt()};

                xys.add(xy);
            }
            xyss.add(xys);
        }

        int max = 0;

        // 正直者のパターンを作り、ループを回す
        for (int bit = 0; bit < 1 << n; bit++) {

            int[] check = new int[n];
            Arrays.fill(check, 0);

            boolean ok = true;

            for (int i = 0; i < n; i++) {

                if ((bit & (1 << i)) >= 1) {
                    check[i] = 1;
                }
            }

            for (int i = 0; i < n; i++) {
                // 不親切とみなしている人はチェックしない
                if (check[i] == 0) {
                    continue;
                }
                // 正直者の証言をチェック

                var xys = xyss.get(i);

                for (int[] xy : xys) {

                    // 正直者と証言している場合に矛盾がないかどうか
                    if (check[xy[0] - 1] != xy[1]) {

                        ok = false;
                        break;
                    }
                }
                if (!ok) {
                    break;
                }
            }

            if (ok) {

                int cnt = 0;
                for (var c : check) {
                    if (c == 1) {
                        cnt++;
                    }
                }
                max = Math.max(max, cnt);
            }
        }

        System.out.println(max);
    }
//}

    @Test
    public void Case1() {

        in.inputln("3");
        in.inputln("1");
        in.inputln("2 1");
        in.inputln("1");
        in.inputln("1 1");
        in.inputln("1");
        in.inputln("2 0");
        var expected = "2";

        ABC147C.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void Case2() {
        in.inputln("3");
        in.inputln("2");
        in.inputln("2 1");
        in.inputln("3 0");
        in.inputln("2");
        in.inputln("3 1");
        in.inputln("1 0");
        in.inputln("2");
        in.inputln("1 1");
        in.inputln("2 0");
        var expected = "0";

        ABC147C.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void Case3() {

        in.inputln("2");
        in.inputln("1");
        in.inputln("2 0");
        in.inputln("1");
        in.inputln("1 0");
        var expected = "1";

        ABC147C.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }
}

//import java.util.*;
//public class Main {
