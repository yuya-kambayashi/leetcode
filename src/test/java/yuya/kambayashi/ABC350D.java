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
public class ABC350D {

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
//import java.util.*;
//import java.util.stream.Collectors;
//public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final int m = sc.nextInt();

        ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> ar = new ArrayList<>();
            al.add(ar);
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;

            al.get(a).add(b);
            al.get(b).add(a);
        }

        int cnt = 0;

        for (int i = 0; i < al.size() / 2; i++) {

            // iの友人
            var ifriends = al.get(i);

            // iの友人の友人のうち、まだ友達でない人を友人に追加する
            for (int j = 0; j < ifriends.size(); j++) {
                var ifriend = ifriends.get(j); // iの友人の友人
                var iff = al.get(ifriend);

                for (int iiff : iff) {
                    if (i == iiff) {
                        continue;
                    }
                    if (!ifriends.contains(iiff)) {
                        // まだともだちでない人を地下
                        ifriends.add(iiff);
                        al.get(iiff).add(i);
                        cnt++;
                    }

                    int aaaa = 0;
                }

                int b = 0;

            }

        }

        System.out.println(cnt);
    }
//}

    @Test
    public void Case1() {

        String input = """
                       4 3
                       1 2
                       2 3
                       1 4
                    """;

        String expected = """
                          3
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC350D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       3 0
                    """;

        String expected = """
                          0
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC350D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       10 8
                       1 2
                       2 3
                       3 4
                       4 5
                       6 7
                       7 8
                       8 9
                       9 10
                    """;

        String expected = """
                          12
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC350D.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }
}

//import java.util.*;
//public class Main {
