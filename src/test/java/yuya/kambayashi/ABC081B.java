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
public class ABC081B {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        final int N = sc.nextInt();
        int[] ai = new int[N];
        for(int i = 0; i < N; i++){
            ai[i] = sc.nextInt();
        }
        
        int cnt = 0;
        
        while(areEven(ai)){
            for(int i = 0; i < ai.length; i++){
                ai[i] /= 2;
            }
            cnt++;
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
        
        in.inputln("3");
        in.inputln("8 12 40");
                
        ABC081B.main(null);

        var actual = out.readLine();
        
        var expected = "2"; 
        
        assertThat(actual).isEqualTo(expected); 
    }
    @Test
    public void Case2() {
        
        in.inputln("4");
        in.inputln("5 6 8 10");
                
        ABC081B.main(null);

        var actual = out.readLine();
        
        var expected = "0"; 
        
        assertThat(actual).isEqualTo(expected); 
    }
    @Test
    public void Case3() {
        
        in.inputln("6");
        in.inputln("382253568 723152896 37802240 379425024 404894720 471526144");
                
        ABC081B.main(null);

        var actual = out.readLine();
        
        var expected = "8"; 
        
        assertThat(actual).isEqualTo(expected); 
    }
}