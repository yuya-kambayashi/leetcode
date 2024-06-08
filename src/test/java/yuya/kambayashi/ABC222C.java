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
public class ABC222C {

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
        Player[] players = new Player[2 * n];

        for (int i = 0; i < 2 * n; i++) {
            String s = sc.next();
            players[i] = new Player(i, 0, s);
        }

        int[] wins = new int[2 * n];
        for (int round = 0; round < m; round++) {

            for (int i = 0; i < 2 * n; i += 2) {
                char c1 = players[i].hand(round);
                char c2 = players[i + 1].hand(round);

                if (c1 == 'G' && c2 == 'C') {
                    players[i].win();
                } else if (c1 == 'C' && c2 == 'P') {
                    players[i].win();
                } else if (c1 == 'P' && c2 == 'G') {
                    players[i].win();
                } else if (c1 == 'C' && c2 == 'G') {
                    players[i + 1].win();
                } else if (c1 == 'G' && c2 == 'P') {
                    players[i + 1].win();
                } else if (c1 == 'P' && c2 == 'C') {
                    players[i + 1].win();
                }
            }

            Arrays.sort(players, new Comparator<Player>() {
                @Override
                public int compare(Player p1, Player p2) {
                    if (p1.wins == p2.wins) {
                        return Integer.compare(p1.id, p2.id);
                    }
                    return Integer.compare(p2.wins, p1.wins);
                }
            }
            );
        }

        for (var p : players) {
            System.out.println(p.id + 1);
        }
    }

    static class Player {

        int id, wins;
        String hands;

        public Player(int id, int wins, String hands) {
            this.wins = wins;
            this.hands = hands;
            this.id = id;
        }

        public void win() {
            this.wins++;
        }

        public char hand(int index) {
            return hands.charAt(index);

        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                       2 3
GCP
PPP
CCC
PPC
                    """;

        String expected = """
                          3
1
2
4
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC222C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       2 2
GC
PG
CG
PP
                    """;

        String expected = """
                          1
2
3
4
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC222C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC222C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }
}

}
