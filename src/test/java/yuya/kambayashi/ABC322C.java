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
public class ABC322C {
    
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
        
        boolean[] fire = new boolean[n];
        Arrays.fill(fire, false);
        for (int i = 0; i < m; i++) {
            int t = sc.nextInt();
            t--;
            fire[t] = true;
        }
        
        int fireIndex = 0;
        
        List<Integer> ans = new ArrayList<>();
        
        for (int i = n - 1; i >= 0; i--) {
            if (fire[i]) {
                fireIndex = i;
                ans.add(0);
            } else {
                ans.add(fireIndex - i);
            }
        }
        
        Collections.reverse(ans);
        for (int a : ans) {
            System.out.println(a);
        }
    }
//}

    @Test
    public void Case1() {
        
        String input = """
                       3 2
                       2 3
                    """;
        
        String expected = """
                          1
                          0
                          0
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC322C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
    
    @Test
    public void Case2() {
        
        String input = """
                       8 5
                       1 3 4 7 8
                    """;
        
        String expected = """
                          0
                          1
                          0
                          0
                          2
                          1
                          0
                          0
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC322C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {
        
        String input = """
                       
                    """;
        
        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC322C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
