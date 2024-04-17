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
public class JOI2008YOE {

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

        final int row = sc.nextInt();
        final int col = sc.nextInt();
        int[][] aaa = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                aaa[i][j] = sc.nextInt();
            }
        }
        // 色を合わせる列をビットで表現する
        for (int bit = 0; bit < 1 << col; bit++) {
            List<Integer> targetCols = new ArrayList<>();
            for (int i = 0; i < col; i++) {
                if ((bit & (1 << i)) >= 1) {
                    targetCols.add(i);
                }
            }
            if (targetCols.isEmpty()) {
                continue;
            }

            // 対象の列がそろっている場合はOK
            int colored = 0, white = 0;
            boolean ok = true;
            for (int i = 0; i < row; i++) {
                int baseColor = aaa[i][targetCols.get(0)];
                if (targetCols.size() == 1) {

                } else {
                    for (int j = 1; j < targetCols.size(); j++) {
                        if (aaa[i][targetCols.get(j)] == baseColor) {
                            // OK
                        } else {
                            ok = false;
                            break;
                        }
                    }
                }
                if (!ok) {
                    break;
                } else {
                    if (baseColor == 1) {
                        colored++;
                    } else {
                        white++;
                    }
                }
            }
            if (!ok) {
                continue;
            }

        }

        System.out.println();
    }
//}

    @Test
    public void Case1() {

        in.inputln("2 5");
        in.inputln("0 1 0 1 0");
        in.inputln("1 0 0 0 1");
        var expected = "9";

        JOI2008YOE.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

    //  @Test
    public void Case2() {

        in.inputln("");
        var expected = "";

        JOI2008YOE.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

    // @Test
    public void Case3() {

        in.inputln("");
        var expected = "";

        JOI2008YOE.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }
}

//import java.util.*;
//public class Main {
