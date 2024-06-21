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
public class ABC208C {

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
        System.setOut(null);//import java.math.*;
        //import java.util.*;
        //import java.util.stream.*;
        //public class Main {

    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        long k = sc.nextLong();

        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pairs.add(new Pair(i + 1, sc.nextInt(), 0));
        }

        for (var p : pairs) {
            p.cnt += k / n;
        }

        k %= n;

        Collections.sort(pairs, Comparator.comparingInt(Pair::getNumber));
        for (int i = 0; i < k; i++) {
            pairs.get(i).cnt++;
        }
        Collections.sort(pairs, Comparator.comparingInt(Pair::getIndex));
        for (var p : pairs) {
            System.out.println(p.cnt);
        }
    }

    static class Pair {

        int index, number;
        long cnt;

        Pair(int index, int number, long cnt) {
            this.index = index;
            this.number = number;
            this.cnt = cnt;
        }

        int getIndex() {
            return index;
        }

        int getNumber() {
            return number;
        }
    }
//}
}
//import java.math.*;
//import java.util.*;
//import java.util.stream.*;
//public class Main {

public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        long k = sc.nextLong();

        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pairs.add(new Pair(i + 1, sc.nextInt(), 0));
        }

        for (var p : pairs) {
            p.cnt += k / n;
        }

        k %= n;

        Collections.sort(pairs, Comparator.comparingInt(Pair::getNumber));
        for (int i = 0; i < k; i++) {
            pairs.get(i).cnt++;
        }
        Collections.sort(pairs, Comparator.comparingInt(Pair::getIndex));
        for (var p : pairs) {
            System.out.println(p.cnt);

}
    }

    static class Pair {

    int index, number;
    long cnt;

    Pair(int index, int number, long cnt) {
        this.index = index;
        this.number = number;
        this.cnt = cnt;
    }

    int getIndex() {
        return index;
    }

    int getNumber() {
        return number;
    }
}
//}

@Test
public void Case1() {

        String input = """
                       2 7
                       1 8
                    """;

        String expected = """
                          4
                          3
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC208C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
public void Case2() {

        String input = """
                       1 3
                       33
                    """;

        String expected = """
                          3
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC208C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
public void Case3() {

        String input = """
                       7 1000000000000
                       99 8 2 4 43 5 3
                    """;

        String expected = """
                          142857142857
                          142857142857
                          142857142858
                          142857142857
                          142857142857
                          142857142857
                          142857142857
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC208C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
