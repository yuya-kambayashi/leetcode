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
public class ABC087B {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        final int A = sc.nextInt(); // 500
        final int B= sc.nextInt();  // 100
        final int C = sc.nextInt(); // 50
        final int X = sc.nextInt(); // 合計
        
        int cnt = 0;
        for(int i = 0; i <= A; i++){
            for(int j = 0; j <= B; j++){
                for(int k = 0; k <= C; k++){
                    
                    if (500*i + 100*j+50*k == X){
                        cnt++;
                    }
                }

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
        
        in.inputln("2");
        in.inputln("2");
        in.inputln("2");
        in.inputln("100");
                
        ABC087B.main(null);

        var actual = out.readLine();
        
        var expected = "2"; 
        
        assertThat(actual).isEqualTo(expected); 
    }
    @Test
    public void Case2() {
        
        in.inputln("5");
        in.inputln("1");
        in.inputln("0");
        in.inputln("150");

                
        ABC087B.main(null);

        var actual = out.readLine();
        
        var expected = "0"; 
        
        assertThat(actual).isEqualTo(expected); 
    }
    @Test
    public void Case3() {
        
        in.inputln("30");
        in.inputln("40");
        in.inputln("50");
        in.inputln("6000");
                
        ABC087B.main(null);

        var actual = out.readLine();
        
        var expected = "213"; 
        
        assertThat(actual).isEqualTo(expected); 
    }
}