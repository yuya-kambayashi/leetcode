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
public class ABC221C {

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
        int[] nn = new int[10];
        char[] cc = String.valueOf(n).toCharArray();
        for (int i = 0; i < cc.length; i++) {
            char c = cc[i];
            nn[c - '0']++;
        }

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int cnt = 1;
        boolean to1 = true;
        for (int i = 9; i >= 0; i--) {

            for (int j = 0; j < nn[i]; j++) {
                if (to1) {
                    if (cnt == 0) {
                        sb1.append(i);
                        cnt++;
                    } else if (cnt == 1) {
                        sb1.append(i);
                        cnt = 0;
                        to1 = false;
                    }
                } else {
                    if (cnt == 0) {
                        sb2.append(i);
                        cnt++;
                    } else if (cnt == 1) {
                        sb2.append(i);
                        cnt = 0;
                        to1 = true;
                    }
                }
            }
        }

        long n1 = Long.parseLong(sb1.toString());
        long n2 = Long.parseLong(sb2.toString());

        System.out.println(n1 * n2);
    }
//}

    //@Test
    public void Case1() {

        String input = """
                       123
                    """;

        String expected = """
                          63
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC221C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    //@Test
    public void Case2() {

        String input = """
                       1010
                    """;

        String expected = """
                          100
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC221C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       998244353
                    """;

        String expected = """
                          939337176
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC221C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }
}
