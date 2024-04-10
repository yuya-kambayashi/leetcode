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
public class ABC348C {

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
        int[][] zaa = new int[n][2];
        for (int i = 0; i < n; i++) {
            zaa[i][0] = sc.nextInt();
            zaa[i][1] = sc.nextInt();
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int[] za = zaa[i];

            int k = za[1];
            int v = za[0];

            if (map.containsKey(k)) {
                if (map.get(k) > v) {
                    map.put(k, v);
                }
            } else {
                map.put(k, v);
            }
        }

        int min = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (min < entry.getValue()) {
                min = entry.getValue();
            }
        }

        System.out.println(min);
    }
//}

    @Test
    public void Case1() {

        in.inputln("4");
        in.inputln("100 1");
        in.inputln("20 5");
        in.inputln("30 5");
        in.inputln("40 1");
        var expected = "40";

        ABC348C.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void Case2() {
        in.inputln("10");
        in.inputln("68 3");
        in.inputln("17 2");
        in.inputln("99 2");
        in.inputln("92 4");
        in.inputln("82 4");
        in.inputln("10 3");
        in.inputln("100 2");
        in.inputln("78 1");
        in.inputln("3 1");
        in.inputln("35 4");
        var expected = "35";

        ABC348C.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

    // @Test
    public void Case3() {

        in.inputln("");
        var expected = "";

        ABC348C.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }
}

//import java.util.*;
//public class Main {
