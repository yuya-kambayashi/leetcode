
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
public class ABC385D {

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
        Scanner scanner = new Scanner(System.in);

        // 入力の読み取り
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        long Sx = scanner.nextLong();
        long Sy = scanner.nextLong();

        // 家の座標をセットに保存
        Set<String> houses = new HashSet<>();
        for (int i = 0; i < N; i++) {
            long x = scanner.nextLong();
            long y = scanner.nextLong();
            houses.add(x + "," + y);
        }

        // 移動指示をリストに保存
        List<Move> moves = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String direction = scanner.next();
            long distance = scanner.nextLong();
            moves.add(new Move(direction, distance));
        }

        // サンタクロースの移動
        long currentX = Sx;
        long currentY = Sy;
        Set<String> visitedHouses = new HashSet<>();

        for (Move move : moves) {
            String direction = move.direction;
            long distance = move.distance;

            // 移動方向に従って座標を更新
            for (long step = 1; step <= distance; step++) {
                if (direction.equals("U")) {
                    currentY++;
                }
                if (direction.equals("D")) {
                    currentY--;
                }
                if (direction.equals("L")) {
                    currentX--;
                }
                if (direction.equals("R")) {
                    currentX++;
                }

                // 通過した家を記録
                String key = currentX + "," + currentY;
                if (houses.contains(key)) {
                    visitedHouses.add(key);
                }
            }
        }

        // 結果の出力
        System.out.println(currentX + " " + currentY + " " + visitedHouses.size());
    }

    // 移動の指示を表すクラス
    static class Move {

        String direction;
        long distance;

        Move(String direction, long distance) {
            this.direction = direction;
            this.distance = distance;
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                       3 4 3 2
                       2 2
                       3 3
                       2 1
                       L 2
                       D 1
                       R 1
                       U 2
                    """;

        String expected = """
                          2 3 2
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC385D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       1 3 0 0
                       1 1
                       R 1000000000
                       R 1000000000
                       R 1000000000
                    """;

        String expected = """
                          3000000000 0 0
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC385D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC385D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case4() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC385D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
