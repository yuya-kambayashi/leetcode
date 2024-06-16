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
public class ABC207C {

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
        List<Section> sections = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sections.add(new Section(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(sections, new Comparator<Section>() {
            @Override
            public int compare(Section s1, Section s2) {
                if (s1.x != s2.x) {
                    return Integer.compare(s1.x, s2.x);
                }
                return Integer.compare(s1.y, s2.y);
            }
        });

        // 1 1 2 ->  [1, 2]
        // 2 2 3 ->  [2, 3) 
        // 3 2 4 ->  (2, 4]
        // 1,2 -> o 
        // 1,3 -> x
        // 2,3 -> o
        // すべての組み合わせから、共通部分を持たない組み合わせを引く
        int cnt = 0;

        for (int i = 0; i < n; i++) {

            var s1 = sections.get(i);
            double y1 = s1.y;
            if (s1.type == 2 || s1.type == 4) {
                y1 -= 0.1;
            }

            for (int j = i + 1; j < n; j++) {
                var s2 = sections.get(j);
                double x2 = s2.x;
                if (s2.type == 3 || s2.type == 4) {
                    x2 += 0.1;
                }

                if (y1 < x2) {
                    cnt++;
                }
            }
        }

        int all = n * (n - 1) / 2;

        System.out.println(all - cnt);
    }

    static class Section {

        int type, x, y;

        Section(int type, int x, int y) {
            this.type = type;
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

    }
//}

    @Test
    public void Case1() {

        String input = """
                       3
1 1 2
2 2 3
3 2 4
                    """;

        String expected = """
                          2
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC207C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       19
4 210068409 221208102
4 16698200 910945203
4 76268400 259148323
4 370943597 566244098
1 428897569 509621647
4 250946752 823720939
1 642505376 868415584
2 619091266 868230936
2 306543999 654038915
4 486033777 715789416
1 527225177 583184546
2 885292456 900938599
3 264004185 486613484
2 345310564 818091848
1 152544274 521564293
4 13819154 555218434
3 507364086 545932412
4 797872271 935850549
2 415488246 685203817
                    """;

        String expected = """
                          102
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC207C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC207C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
