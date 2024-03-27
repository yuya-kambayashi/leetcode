/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yuya.kambayashi;

import java.util.Scanner;
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
public class ACTemplate {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String s = sc.next();
        
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
        
        in.inputln("");
                
        ABC081A.main(null);

        var actual = out.readLine();
        
        var expected = "2"; 
        
        assertThat(actual).isEqualTo(expected); 
    }
    @Test
    public void Case2() {
        
        in.inputln("");
                
        ABC081A.main(null);

        var actual = out.readLine();
        
        var expected = "0"; 
        
        assertThat(actual).isEqualTo(expected); 
    }
}

//import java.util.*;
//public class Main {