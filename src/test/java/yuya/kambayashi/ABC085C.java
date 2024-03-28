/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yuya.kambayashi;

import java.util.*;
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
public class ABC085C {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        final int n = sc.nextInt();
        int[] da = new int[n];
        for (int i = 0; i < n; i++) {
            da[i] = sc.nextInt();
        }
        
        System.out.println();
    }
	
    private StandardInputSnatcher  in = new StandardInputSnatcher();
    private StandardOutputSnatcher  out = new StandardOutputSnatcher ();
    
    @BeforeAll
    public void beforeAll(){
        System.setIn(in);
        System.setOut(out);
    }
    @AfterAll
    public void afterAll(){
        System.setIn(null);
        System.setOut(null);
    }

    @Test
    public void Case1() {
        
        in.inputln("9 45000");
                
        ABC081A.main(null);

        var actual = out.readLine();
        
        var expected = "4 0 5"; 
        
        assertThat(actual).isEqualTo(expected); 
    }
    @Test
    public void Case2() {
        
        in.inputln("20 196000");
                
        ABC081A.main(null);

        var actual = out.readLine();
        
        var expected = "-1 -1 -1"; 
        
        assertThat(actual).isEqualTo(expected); 
    }
    @Test
    public void Case3() {
        
        in.inputln("1000 1234000");
                
        ABC081A.main(null);

        var actual = out.readLine();
        
        var expected = "14 27 959"; 
        
        assertThat(actual).isEqualTo(expected); 
    }
}

//import java.util.*;
//public class Main {