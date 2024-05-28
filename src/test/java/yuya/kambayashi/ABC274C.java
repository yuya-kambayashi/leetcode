/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yuya.kambayashi;

import java.util.*;
import java.util.stream.Stream;
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
public class ABC274C {

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
//import java.math.*;
//import java.util.*;
//import java.util.stream.*;
//public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        int[] aa = new int[n];
        for (int i = 0; i < n; i++) {
            aa[i] = sc.nextInt();
        }

        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(1);
        for (int i = 1; i < n; i++) {
            int a = aa[i];

            var l = list.get(a - 1);

            list.add(l + 1);
            list.add(l + 1);
        }
        for (int i : list) {
            System.out.println(i);
        }
    }
    // 1(0), 2(1), 3(1), 4(3,1),5(3,1),6(5,3,1),7(5,3,1),8(2,1),9(2,1)
//}

    @Test
    public void Case1() {

        String input = """
                       2
1 2
                    """;

        String expected = """
                          0
1
1
2
2
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC274C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       4
1 3 5 2
                    """;

        String expected = """
                          0
1
1
2
2
3
3
2
2
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC274C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC274C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }
}
