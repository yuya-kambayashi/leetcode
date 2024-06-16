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
public class ABC225C {

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

        long[][] bb = new long[n][m];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                bb[r][c] = sc.nextLong();
            }
        }

        // 列間の差は1
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m - 1; c++) {
                if (bb[r][c + 1] - bb[r][c] != 1) {
                    System.out.println("No");
                    return;
                }
            }
            // 7の倍数が途中に来てはダメ
            for (int c = 0; c < m; c++) {
                if (bb[r][c] % 7 == 0 && c != m - 1) {
                    System.out.println("No");
                    return;
                }
            }
        }
        // 行間の差は7
        for (int r = 0; r < n - 1; r++) {
            for (int c = 0; c < m; c++) {
                if (bb[r + 1][c] - bb[r][c] != 7) {
                    System.out.println("No");
                    return;
                }
            }
        }

        if (m == 7) {
            if (bb[0][0] % 7 != 1) {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }
//}

    @Test
    public void Case1() {

        String input = """
                       2 3
1 2 3
8 9 10
                    """;

        String expected = """
                          Yes
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC225C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       2 1
1
2
                    """;

        String expected = """
                          No
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC225C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       10 4
1346 1347 1348 1349
1353 1354 1355 1356
1360 1361 1362 1363
1367 1368 1369 1370
1374 1375 1376 1377
1381 1382 1383 1384
1388 1389 1390 1391
1395 1396 1397 1398
1402 1403 1404 1405
1409 1410 1411 1412
                    """;

        String expected = """
                          Yes
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC225C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
