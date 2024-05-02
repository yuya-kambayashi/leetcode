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
public class ABC335C {

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
//public class Main {

    static class Pair {

        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final int q = sc.nextInt();

        List<Pair> pairs = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            Pair p = new Pair(i, 0);

            pairs.add(p);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < q; i++) {
            String query = sc.next();

            if (query.equals("1")) {

                String next = sc.next();
                sb.append(next);

            } else if (query.equals("2")) {

                List<Pair> newPairs = new ArrayList<>();

                for (int j = 0; j < n; j++) {
                    Pair p = pairs.get(j);

                    // 移動クエリの更新
                    if (j > 0 && sb.length() > 0) {
                        Pair before = pairs.get(j - 1);

                        // 移動量
                        int v = sb.length();

                        // x方向
                        int ddx = before.first - p.first;
                        if (ddx > 0) {
                            for (int k = 0; k < ddx; k++) {
                                sb.insert(0, "R");
                            }
                        } else if (ddx < 0) {
                            for (int k = 0; k < -ddx; k++) {
                                sb.insert(0, "L");
                            }
                        }

                        // y方向
                        int ddy = before.second - p.second;
                        if (ddy > 0) {
                            for (int k = 0; k < ddy; k++) {
                                sb.insert(0, "U");
                            }
                        } else if (ddy < 0) {
                            for (int k = 0; k < -ddy; k++) {
                                sb.insert(0, "D");
                            }
                        }
                        for (int k = 0; k < v; k++) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                    }

                    // 実際の移動
                    // 移動する
                    int dx = 0, dy = 0;
                    for (char c : sb.toString().toCharArray()) {
                        switch (c) {
                            case 'R':
                                dx++;
                                break;
                            case 'L':
                                dx--;
                                break;
                            case 'U':
                                dy++;
                                break;
                            case 'D':
                                dy--;
                                break;
                        }
                    }
                    Pair newPair = new Pair(p.first + dx, p.second + dy);
                    newPairs.add(newPair);
                }

                pairs = new ArrayList<>(newPairs);

                Pair target = pairs.get(sc.nextInt() - 1);

                System.out.println(String.valueOf(target.first) + " " + String.valueOf(target.second));

                sb.setLength(0);

            }
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                       5 9
                       2 3
                       1 U
                       2 3
                       1 R
                       1 D
                       2 3
                       1 L
                       2 1
                       2 5
                    """;

        String expected = """
                          3 0
                          2 0
                          1 1
                          1 0
                          1 0
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC335C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    //  @Test
    public void Case2() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC335C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC335C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }
}
