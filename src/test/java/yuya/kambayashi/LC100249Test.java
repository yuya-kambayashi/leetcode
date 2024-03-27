/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yuya.kambayashi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 *
 * @author kamba
 */
public class LC100249Test {
       
    public String minimizeStringValue(String s) {
        
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 0);
        map.put('b', 0);
        map.put('c', 0);
        map.put('d', 0);
        map.put('e', 0);
        map.put('f', 0);
        map.put('g', 0);
        map.put('h', 0);
        map.put('i', 0);
        map.put('j', 0);
        map.put('k', 0);
        map.put('l', 0);
        map.put('m', 0);
        map.put('n', 0);
        map.put('o', 0);
        map.put('p', 0);
        map.put('q', 0);
        map.put('r', 0);
        map.put('s', 0);
        map.put('t', 0);
        map.put('u', 0);
        map.put('v', 0);
        map.put('w', 0);
        map.put('x', 0);
        map.put('y', 0);
        map.put('z', 0);

        char[] ca = s.toCharArray();
        
        for(int i = 0; i < ca.length; i++){
            char c = ca[i];
            if (c != '?'){
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }
            
        int cntq = 0;
        
        for(int i = 0; i < ca.length; i++){
            char c = ca[i];
            if (c == '?'){
                cntq++;
            }
        }
        
        char[] target = new char[cntq];
        int changei = 0;
        
        for(int i = 0; i < ca.length; i++){
            char c = ca[i];
            if (c != '?'){
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            else{
                
                int min = Integer.MAX_VALUE;
                for(var v : map.values()){
                    min = Math.min(min, v);
                }
                
                for(Map.Entry<Character, Integer> entry : map.entrySet()){
                    if (entry.getValue() == min){
                        target[changei] = entry.getKey();
                        changei++;
                        map.put(entry.getKey(), min+1);
                        break;
                    }
                }
            }
        }
        
        Arrays.sort(target);
        
        int index = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < ca.length; i++){
            char c = ca[i];
            if (c != '?'){
                sb.append(c);
            }
            else{
                sb.append(target[index]);
                index++;
            }

        }
      
        return sb.toString();
    }

    //@Test
    void Case1() {
        
        String s = "???";
        
        var actual = minimizeStringValue(s);
        
        var expected = "abc";
        
        assertThat(actual).isEqualTo(expected);
    }
    @Test @Disabled
    void Case2() {
        
        String s = "a?a?";
        
        var actual = minimizeStringValue(s);
        
        var expected = "abac";
        
        assertThat(actual).isEqualTo(expected);
    }
    //@Test
    void Case3() {
        
        String s = "?????";
        
        var actual = minimizeStringValue(s);
        
        var expected = "abcde";
        
        assertThat(actual).isEqualTo(expected);
    }
    //@Test
    void Case4() {
        
        String s = "??????????????????????????";
        
        var actual = minimizeStringValue(s);
        
        var expected = "abcdefghijklmnopqrstuvwxyz";
        
        assertThat(actual).isEqualTo(expected);
    }
    //@Test
    void Case5() {
        
        String s = "???????????????????????????";
        
        var actual = minimizeStringValue(s);
        
        var expected = "aabcdefghijklmnopqrstuvwxyz";
        
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    void Case6() {
        
        String s = "abcdefghijklmnopqrstuvwxy??";
        
        var actual = minimizeStringValue(s);
        
        var expected = "abcdefghijklmnopqrstuvwxyaz";
        
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    void Case8() {
        
        String s = "eq?umjlasi";
        
        var actual = minimizeStringValue(s);
        
        var expected = "eqbumjlasi";
        
        assertThat(actual).isEqualTo(expected);
    }
}
