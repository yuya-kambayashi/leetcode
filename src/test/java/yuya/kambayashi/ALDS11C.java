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
public class ALDS11C {
    
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
//https://judge.u-aizu.ac.jp/onlinejudge/review.jsp?rid=7861463#1
//import java.util.*;
//import java.util.stream.Collectors;
//public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        int[][] g = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            int u = sc.nextInt();
            int k = sc.nextInt();
            for (int j = 0; j < k; j++) {
                int v = sc.nextInt();
                g[u - 1][v - 1] = 1;
            }
        }
        
        Queue<Integer> q = new ArrayDeque<Integer>();
        q.add(0);
        
        int d[] = new int[n];
        for (int i = 1; i < n; i++) {
            d[i] = Integer.MAX_VALUE;
        }
        
        while (!q.isEmpty()) {
            int now = q.peek();
            q.poll();
            
            for (int i = 0; i < n; i++) {
                if (g[now][i] == 1 && d[i] > d[now] + 1) {
                    d[i] = d[now] + 1;
                    q.add(i);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (d[i] == Integer.MAX_VALUE) {
                d[i] = -1;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(Integer.toString(i + 1) + " " + Integer.toString(d[i]));
        }
    }
//}

    @Test
    public void Case1() {
        
        String input = """
                       4
                       1 2 2 4
                       2 1 4
                       3 0
                       4 1 3
                    """;
        
        String expected = """
                          1 0
                          2 1
                          3 2
                          4 1
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ALDS11C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    //  @Test
    public void Case2() {
        
        String input = """
                       
                    """;
        
        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ALDS11C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }

    // @Test
    public void Case3() {
        
        String input = """
                       
                    """;
        
        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ALDS11C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine()).isEqualTo(s));
    }
}

//import java.util.*;
//public class Main {
