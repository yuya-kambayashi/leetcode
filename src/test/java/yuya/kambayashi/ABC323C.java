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
public class ABC323C {

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
        final int m = sc.nextInt();
        int[] aa = new int[m];
        for (int i = 0; i < m; i++) {
            aa[i] = sc.nextInt();
        }

        String[] ss = new String[n];
        for (int i = 0; i < n; i++) {
            ss[i] = sc.next();
        }
        int[] points = new int[n];
        for (int i = 0; i < n; i++) {
            String s = ss[i];
            for (int j = 0; j < m; j++) {
                if (s.charAt(j) == 'o') {
                    points[i] += aa[j];
                }
            }
            points[i] += i + 1;
        }

        int max = 0;
        for (int p : points) {
            max = Math.max(max, p);
        }

        //Arrays.sort(aa);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int point = points[i];
            if (point == max) {
                ans.add(0);
            } else {
                int cnt = 0;
                int index = ss[i].length() - 1;
                while (point < max && index >= 0) {
                    if (ss[i].charAt(index) == 'x') {
                        point += aa[index];
                        cnt++;
                    }
                    index--;
                }
                ans.add(cnt);
            }
        }

        for (int i : ans) {

            System.out.println(i);
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                       3 4
                       1000 500 700 2000
                       xxxo
                       ooxx
                       oxox
                    """;

        String expected = """
                          0
                          1
                          1
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC323C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       5 5
                       1000 1500 2000 2000 2500
                       xxxxx
                       oxxxx
                       xxxxx
                       oxxxx
                       oxxxx
                    """;

        String expected = """
                          1
                          1
                          1
                          1
                          0
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC323C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       7 8
                       500 500 500 500 500 500 500 500
                       xxxxxxxx
                       oxxxxxxx
                       ooxxxxxx
                       oooxxxxx
                       ooooxxxx
                       oooooxxx
                       ooooooxx
                    """;

        String expected = """
                          7
                          6
                          5
                          4
                          3
                          2
                          0
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC323C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }
}
