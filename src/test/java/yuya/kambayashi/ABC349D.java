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
public class ABC349D {

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

        final int l = sc.nextInt();
        final int r = sc.nextInt();
        System.out.println();
    }
//}

    @Test
    public void Case1() {

        in.inputln("3 19");
        var expected = "5";

        ABC349D.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

    //  @Test
    public void Case2() {

        in.inputln("");
        var expected = "";

        ABC349D.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }

    // @Test
    public void Case3() {

        in.inputln("");
        var expected = "";

        ABC349D.main(null);
        var actual = out.readLine();
        assertThat(actual).isEqualTo(expected);
    }
}

//import java.util.*;
//public class Main {
