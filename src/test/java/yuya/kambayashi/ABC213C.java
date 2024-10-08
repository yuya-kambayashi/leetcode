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
public class ABC213C {

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

        final int h = sc.nextInt();
        final int w = sc.nextInt();
        final int n = sc.nextInt();;
        int[] aa = new int[n];
        int[] bb = new int[n];
        TreeSet<Integer> setA = new TreeSet<>();
        TreeSet<Integer> setB = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            aa[i] = sc.nextInt();
            bb[i] = sc.nextInt();
            setA.add(aa[i]);
            setB.add(bb[i]);
        }

        HashMap<Integer, Integer> mapA = new HashMap<>();
        HashMap<Integer, Integer> mapB = new HashMap<>();

        int j = 1;
        for (var a : setA) {
            mapA.put(a, j);
            j++;
        }
        j = 1;
        for (var b : setB) {
            mapB.put(b, j);
            j++;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(mapA.get(aa[i]) + " " + mapB.get(bb[i]));
        }

    }
//}

    @Test
    public void Case1() {

        String input = """
                       4 5 2
3 2
2 5
                    """;

        String expected = """
                          2 1
1 2
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC213C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       1000000000 1000000000 10
1 1
10 10
100 100
1000 1000
10000 10000
100000 100000
1000000 1000000
10000000 10000000
100000000 100000000
1000000000 1000000000
                    """;

        String expected = """
                          1 1
2 2
3 3
4 4
5 5
6 6
7 7
8 8
9 9
10 10
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC213C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC213C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
