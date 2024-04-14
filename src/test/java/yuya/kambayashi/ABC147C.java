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

        System.out.println();
    }
//}

    // @Test
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

    // @Test
    public void Case3() {

        in.inputln("");
        var expected = "";

        ABC147C.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }
}

//import java.util.*;
//public class Main {
