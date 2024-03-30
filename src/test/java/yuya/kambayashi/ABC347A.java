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
public class ABC347A {
//import java.util.*;
//public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final int k = sc.nextInt();
        int[] aa = new int[n];
        for (int i = 0; i < n; i++) {
            aa[i] = sc.nextInt();
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < aa.length; i++) {
            if (aa[i] % k == 0) {
                ans.add(aa[i] / k);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ans.size(); i++) {
            sb.append(ans.get(i));
            if (i != ans.size() - 1) {
                sb.append(" ");
            }
        }

        System.out.println(sb.toString());
    }
//}

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

    // @Disabled
    @Test
    public void Case1() {

        in.inputln("5 2");
        in.inputln("2 5 6 7 10");

        ABC347A.main(null);

        var actual = out.readLine();

        var expected = "1 3 5";

        assertThat(actual).isEqualTo(expected);
    }

    //@Disabled
    @Test
    public void Case2() {

        in.inputln("3 1");
        in.inputln("3 4 7");

        ABC347A.main(null);

        var actual = out.readLine();

        var expected = "3 4 7";

        assertThat(actual).isEqualTo(expected);
    }

    //@Disabled
    @Test
    public void Case3() {

        in.inputln("5 10");
        in.inputln("50 51 54 60 65");

        ABC347A.main(null);

        var actual = out.readLine();

        var expected = "5 6";

        assertThat(actual).isEqualTo(expected);
    }
}

//import java.util.*;
//public class Main {
