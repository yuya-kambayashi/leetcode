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
public class JOI2008YOD {

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

        final int m = sc.nextInt();
        List<int[]> mmm = new ArrayList<int[]>();
        for (int i = 0; i < m; i++) {
            int[] t = new int[2];

            t[0] = sc.nextInt();
            t[1] = sc.nextInt();
            mmm.add(t);
        }
        final int n = sc.nextInt();
        List<int[]> nnn = new ArrayList<int[]>();
        for (int i = 0; i < n; i++) {
            int[] t = new int[2];

            t[0] = sc.nextInt();
            t[1] = sc.nextInt();
            nnn.add(t);
        }

        int[] baseXY = mmm.get(0);

        for (int i = 0; i < n; i++) {
            int[] xy = nnn.get(i);

            int diffX = xy[0] - baseXY[0];
            int diffY = xy[1] - baseXY[1];

            List<int[]> offsetNNN = new ArrayList<int[]>();

            for (int j = 0; j < n; j++) {
                int[] offset = {nnn.get(j)[0] - diffX, nnn.get(j)[1] - diffY};
                offsetNNN.add(offset);

            }

            boolean allContains = true;
            for (int j = 0; j < m; j++) {

                int[] mm = mmm.get(j);
                boolean contains = false;
                for (int k = 0; j < n; j++) {
                    int[] offset = offsetNNN.get(j);
                    if (mm[0] == offset[0] && mm[1] == offset[1]) {
                        contains = true;
                        break;
                    }
                }
                if (!contains) {
                    allContains = false;
                    break;
                }
            }
            if (allContains) {
                String ret = String.valueOf(diffX) + " " + String.valueOf(diffY);
                System.out.println(ret);
                return;

            }

        }

        // System.out.println();
    }
//}

    @Test
    public void Case1() {
        in.inputln("5");
        in.inputln("8 5");
        in.inputln("6 4");
        in.inputln("4 3");
        in.inputln("7 10");
        in.inputln("0 10");
        in.inputln("10");
        in.inputln("10 5");
        in.inputln("2 7");
        in.inputln("9 7");
        in.inputln("8 10");
        in.inputln("10 2");
        in.inputln("1 2");
        in.inputln("8 1");
        in.inputln("6 7");
        in.inputln("6 0");
        in.inputln("0 9");
        var expected = "2 -3";

        JOI2008YOD.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void Case2() {
        in.inputln("5");
        in.inputln("904207 809784");
        in.inputln("845370 244806");
        in.inputln("499091 59863");
        in.inputln("638406 182509");
        in.inputln("435076 362268");
        in.inputln("10");
        in.inputln("757559 866424");
        in.inputln("114810 239537");
        in.inputln("519926 989458");
        in.inputln("461089 424480");
        in.inputln("674361 448440");
        in.inputln("81851 150384");
        in.inputln("459107 795405");
        in.inputln("299682 6700");
        in.inputln("254125 362183");
        in.inputln("50795 541942");
        var expected = "-384281 179674";

        JOI2008YOD.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

    // @Test
    public void Case3() {

        in.inputln("");
        var expected = "";

        JOI2008YOD.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }
}

//import java.util.*;
//public class Main {
