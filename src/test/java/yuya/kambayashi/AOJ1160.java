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
public class AOJ1160 {

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

// https://judge.u-aizu.ac.jp/onlinejudge/review.jsp?rid=149237#1    
//import java.util.*;
//import java.util.stream.Collectors;
//public class Main {
    static char[][] grid;
    static int row, col;

    static void delete(int r, int c) {

        grid[r][c] = '*';
        // 対象セルが最上段でない場合、上方向のセルをチェックする
        if (r > 0) {
            // ↖
            if (c > 0) {
                if (grid[r - 1][c - 1] == '@') {
                    delete(r - 1, c - 1);
                }
            }
            // ↗
            if (c < col - 1) {
                if (grid[r - 1][c + 1] == '@') {
                    delete(r - 1, c + 1);
                }
            }
            // ↑
            if (grid[r - 1][c] == '@') {
                delete(r - 1, c);
            }
        }
        // 対象セルが最下段でない場合、下方向のセルをチェックする
        if (r < row - 1) {
            // ↙
            if (c > 0) {
                if (grid[r + 1][c - 1] == '@') {
                    delete(r + 1, c - 1);
                }
            }
            // ↘
            if (c < col - 1) {
                if (grid[r + 1][c + 1] == '@') {
                    delete(r + 1, c + 1);
                }
            }
            //　↓
            if (grid[r + 1][c] == '@') {
                delete(r + 1, c);
            }
        }
        // 左端でない場合、左のセルをチェックする（左上、左下はチェック済み）
        if (c > 0) {
            // ←
            if (grid[r][c - 1] == '@') {
                delete(r, c - 1);
            }
        }
        // 右端でない場合、右のセルをチェックする（右上、右下はチェック済み）
        if (c < col - 1) {
            // →
            if (grid[r][c + 1] == '@') {
                delete(r, c + 1);
            }
        }
        return;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while ((col = sc.nextInt()) != 0 && (row = sc.nextInt()) != 0) {
            grid = new char[row][col];

            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    // 陸は「＠」とし、海は「*」とする
                    grid[r][c] = sc.nextInt() == 1 ? '@' : '*';
                }
            }
            int ans = 0;

            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    // 陸のセルを見つけたら、隣接するセルが陸ならつなげていく
                    if (grid[r][c] == '@') {
                        ans++;
                        delete(r, c);
                    }
                }
            }
            System.out.println(ans);
        }

    }
//}

    @Test
    public void Case1() {

        String input = """
                       1 1
                       0
                       2 2
                       0 1
                       1 0
                       3 2
                       1 1 1
                       1 1 1
                       5 4
                       1 0 1 0 0
                       1 0 0 0 0
                       1 0 1 0 1
                       1 0 0 1 0
                       5 4
                       1 1 1 0 1
                       1 0 1 0 1
                       1 0 1 0 1
                       1 0 1 1 1
                       5 5
                       1 0 1 0 1
                       0 0 0 0 0
                       1 0 1 0 1
                       0 0 0 0 0
                       1 0 1 0 1
                       0 0
                    """;

        String expected = """
                          0
                          1
                          1
                          3
                          1
                          9
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        AOJ1160.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //  @Test
    public void Case2() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        AOJ1160.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        AOJ1160.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}

//import java.util.*;
//public class Main {
