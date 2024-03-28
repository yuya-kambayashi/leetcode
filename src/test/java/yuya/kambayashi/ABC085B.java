/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yuya.kambayashi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
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
public class ABC085B {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        int[] da = new int[n];
        for (int i = 0; i < n; i++) {
            da[i] = sc.nextInt();
        }

        Set<Integer> set = new HashSet<>();
        for (int d : da) {
            set.add(d);
        }

        System.out.println(set.size());
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

    @Test
    public void Case1() {

        in.inputln("4");
        in.inputln("10");
        in.inputln("8");
        in.inputln("8");
        in.inputln("6");

        ABC085B.main(null);

        var actual = out.readLine();

        var expected = "3";

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void Case2() {

        in.inputln("3");
        in.inputln("15");
        in.inputln("15");
        in.inputln("15");

        ABC085B.main(null);

        var actual = out.readLine();

        var expected = "1";

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void Case3() {

        in.inputln("7");
        in.inputln("50");
        in.inputln("30");
        in.inputln("50");
        in.inputln("100");
        in.inputln("50");
        in.inputln("80");
        in.inputln("30");

        ABC085B.main(null);

        var actual = out.readLine();

        var expected = "4";

        assertThat(actual).isEqualTo(expected);
    }
}
