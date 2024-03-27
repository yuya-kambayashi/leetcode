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
public class ABC083B {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        final int n = sc.nextInt();
        final int a = sc.nextInt();
        final int b = sc.nextInt();
        
        int cnt = 0;
        
        for(int i = 1; i <= n; i++){
            
                    
            int sum = 0;
            
            while(i > 0){
                
                int t = i % 10;
                sum += t;
                
                i /= 10;
            }
            
            if (a <= i && i <= b){
                cnt++;
            }       
        }

        
        System.out.println(cnt);
    }
    
    
    public static boolean areEven(int[] ai){
        for(int a : ai){
            if (a % 2 == 1){
                return false;
            }
        }
        return true;
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
        
        in.inputln("20 2 5");
                
        ABC083B.main(null);

        var actual = out.readLine();
        
        var expected = "84"; 
        
        assertThat(actual).isEqualTo(expected); 
    }
    //@Test
    public void Case2() {
        
        in.inputln("10 1 2");
                
        ABC083B.main(null);

        var actual = out.readLine();
        
        var expected = "0"; 
        
        assertThat(actual).isEqualTo(expected); 
    }
    //@Test
    public void Case3() {
        
        in.inputln("100 4 16");
                
        ABC083B.main(null);

        var actual = out.readLine();
        
        var expected = "4554"; 
        
        assertThat(actual).isEqualTo(expected); 
    }
}