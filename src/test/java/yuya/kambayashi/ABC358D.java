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
public class ABC358D {

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
        int[] bb = new int[m];
        List<Box> boxies = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            boxies.add(new Box(a, a));
        }
        for (int i = 0; i < m; i++) {
            bb[i] = sc.nextInt();
        }

        Arrays.sort(bb);

        Collections.sort(boxies, Comparator.comparingInt(Box::getCount));

        long sumPrice = 0;
        int aindex = 0;
        for (var b : bb) {
            while (true) {
                if (aindex == boxies.size()) {
                    System.out.println(-1);
                    return;
                }

                int acnt = boxies.get(aindex).count;
                if (b <= acnt) {
                    sumPrice += boxies.get(aindex).price;
                    aindex++;
                    break;
                } else {
                    aindex++;
                }

            }
        }

        System.out.println(sumPrice);
    }

    static class Box {

        int count, price;

        Box(int count, int price) {
            this.count = count;
            this.price = price;
        }

        public int getCount() {
            return count;
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                       4 2
                       3 4 5 4
                       1 4
                    """;

        String expected = """
                          7
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC358D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       3 3
                       1 1 1
                       1000000000 1000000000 1000000000
                    """;

        String expected = """
                          -1
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC358D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       7 3
                       2 6 8 9 5 1 11
                       3 5 7
                    """;

        String expected = """
                          19
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC358D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
