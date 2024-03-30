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
public class ABC347D {
//import java.util.*;
//public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int a = sc.nextInt();
        final int b = sc.nextInt();
        final int c = sc.nextInt();
        String bb = Integer.toBinaryString(b);
        String cb = Integer.toBinaryString(c);

        System.out.println(set.size());
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

    //@Disabled
    @Test
    public void Case1() {

        in.inputln("3 4 7");

        ABC347D.main(null);

        var actual = out.readLine();

        var expected = "28 27";

        assertThat(actual).isEqualTo(expected);
    }

    //@Disabled
    @Test
    public void Case2() {

        in.inputln("34 56 998244353");

        ABC347D.main(null);

        var actual = out.readLine();

        var expected = "-1";

        assertThat(actual).isEqualTo(expected);
    }

    // @Disabled
    @Test
    public void Case3() {

        in.inputln("39 47 530423800524412070");

        ABC347D.main(null);

        var actual = out.readLine();

        var expected = "540431255696862041 10008854347644927";

        assertThat(actual).isEqualTo(expected);
    }
}

//import java.util.*;
//public class Main {
