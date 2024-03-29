/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yuya.kambayashi;

import java.util.Arrays;
import java.util.Scanner;
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
public class ABC088B {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();

        int[] aa = new int[n];

        for (int i = 0; i < n; i++) {
            aa[i] = sc.nextInt();
        }

        Arrays.sort(aa);

        int alice = 0, bob = 0;

        int cnt = 1;
        for (int i = aa.length - 1; i >= 0; i--) {
            if (cnt % 2 == 1) {
                alice += aa[i];
            } else {
                bob += aa[i];
            }
            cnt++;
        }

        System.out.println(alice - bob);
    }

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

    //@Test
    public void Case1() {

        in.inputln("2");
        in.inputln("3 1");

        ABC088B.main(null);

        var actual = out.readLine();

        var expected = "2";

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void Case2() {

        in.inputln("3");
        in.inputln("2 7 4");

        ABC088B.main(null);

        var actual = out.readLine();

        var expected = "5";

        assertThat(actual).isEqualTo(expected);
    }
    // @Test

    public void Case3() {

        in.inputln("4");
        in.inputln("20 18 2 18");

        ABC088B.main(null);

        var actual = out.readLine();

        var expected = "18";

        assertThat(actual).isEqualTo(expected);
    }
}
