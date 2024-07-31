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
public class ABC264C {

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

        final int h1 = sc.nextInt();
        final int w1 = sc.nextInt();
        int[][] grid1 = new int[h1][w1];
        for (int i = 0; i < h1; i++) {
            for (int j = 0; j < w1; j++) {
                grid1[i][j] = sc.nextInt();
            }
        }
        final int h2 = sc.nextInt();
        final int w2 = sc.nextInt();
        int[][] grid2 = new int[h2][w2];
        for (int i = 0; i < h2; i++) {
            for (int j = 0; j < w2; j++) {
                grid2[i][j] = sc.nextInt();
            }
        }

        for (int bitH = 0; bitH < 1 << h1; bitH++) {

            List<Integer> idsH = new ArrayList<>();
            for (int i = 0; i < h1; i++) {
                if ((bitH & (1 << i)) >= 1) {
                    idsH.add(i);
                }
            }
            if (idsH.size() != h1 - h2) {
                continue;
            }

            for (int bitW = 0; bitW < 1 << w1; bitW++) {
                List<Integer> idsW = new ArrayList<>();
                for (int i = 0; i < w1; i++) {
                    if ((bitW & (1 << i)) >= 1) {
                        idsW.add(i);
                    }
                }
                if (idsW.size() != w1 - w2) {
                    continue;
                }

                boolean ok = true;

                for (int row1 = 0, row2 = 0; row1 < h1; row1++, row2++) {
                    if (idsH.contains(row1)) {
                        row2--;
                        continue;
                    }
                    for (int col1 = 0, col2 = 0; col1 < w1; col1++, col2++) {

                        if (idsW.contains(col1)) {
                            col2--;
                            continue;
                        }

                        if (grid1[row1][col1] != grid2[row2][col2]) {
                            ok = false;
                            break;
                        }
                    }
                }
                if (ok) {
                    System.out.println("Yes");
                    return;
                }
            }
        }

        System.out.println("No");
    }
//}

    @Test
    public void Case1() {

        String input = """
                       4 5
1 2 3 4 5
6 7 8 9 10
11 12 13 14 15
16 17 18 19 20
2 3
6 8 9
16 18 19
                    """;

        String expected = """
                          Yes
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC264C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       3 3
1 1 1
1 1 1
1 1 1
1 1
2
                    """;

        String expected = """
                          No
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC264C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       1 2
                       1 2
                       1 1
                       3
                    """;

        String expected = """
                          No
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC264C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC264C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
