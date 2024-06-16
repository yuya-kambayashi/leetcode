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
public class ABC301C {

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

        final String s = sc.next();
        final String t = sc.next();

        String ret = "No";
        if (solve(s, t) || solve(t, s)) {
            ret = "Yes";
        }
        System.out.println(ret);
    }

    static boolean solve(String s1, String s2) {

        // s1に対して、s2を操作してゲームに勝てるか
        // s1と重複する文字は除く
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        for (char c : s2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        ArrayList<Character> cIn2Not1 = new ArrayList<>();
        for (var entry : map2.entrySet()) {

            if (entry.getKey().equals('@')) {
                for (int i = 0; i < map2.get(entry.getKey()); i++) {
                    cIn2Not1.add(entry.getKey());
                }
            } else {
                if (map1.containsKey(entry.getKey())) {
                    int diff = map1.get(entry.getKey()) - map2.get(entry.getKey());
                    if (diff > 0) {
                        for (int i = 0; i < diff; i++) {
                            cIn2Not1.add(entry.getKey());
                        }
                    }
                } else {
                    for (int i = 0; i < map2.get(entry.getKey()); i++) {
                        cIn2Not1.add(entry.getKey());
                    }
                }
            }
        }
        // @以外の文字があったら勝てないために終了する
        for (var r : cIn2Not1) {
            if (r != '@') {
                return false;
            }
        }

        // @を使って、s2をs1に変換できるか？
        int atCnt2 = 0;
        for (var c : s1.toCharArray()) {
            if (c == '@') {
                atCnt2++;
            }
        }

        // 残ったs1の文字に対して、s2の@を使用して変換可能か
        return false;
    }
//}

    @Test
    public void Case1() {

        String input = """
                       ch@ku@ai
choku@@i
                    """;

        String expected = """
                          Yes
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC301C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case2() {

        String input = """
                       ch@kud@i
akidu@ho
                    """;

        String expected = """
                          Yes
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC301C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                       aoki
@ok@
                    """;

        String expected = """
                          No
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC301C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
