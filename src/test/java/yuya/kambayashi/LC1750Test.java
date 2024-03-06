/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yuya.kambayashi;

import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 *
 * @author kamba
 */
public class LC1750Test {
        
    public int minimumLength(String s) {
        
        if (s.length() <= 1){
            return s.length();
        }
        
        while(s.length() > 1){
            String pre = getPrefix(s);
            String suff = getSuffix(s);
            
            if (pre.charAt(0) == suff.charAt(0)){
            
                s = trim(s, pre, suff);
            }
            else{
                return s.length();
            }
            
        }
        
        
        return s.length();
    }
    private String getPrefix(String s){
        
        char pre = '0';
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if (i == 0){
                pre = c;
                sb.append(c);
                continue;
            }
            if (pre == c){
                sb.append(c);
            }
            else{
                return sb.toString();
            }
        }
        return sb.toString();
    }
    private String getSuffix(String s){
        
        char pre = '0';
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() -1; i >= 0; i--){
            char c = s.charAt(i);
            
            if (i == s.length() -1){
                pre = c;
                sb.append(c);
                continue;
            }
            if (pre == c){
                sb.append(c);
            }
            else{
                return sb.toString();
            }
        }
        return sb.toString();
    }
    private String trim(String s, String prefix, String suffix){
        
        if (s.length() == prefix.length()){
            return "";
        }
        
        return s.substring(prefix.length(), s.length() - suffix.length());
    }

    @Test
    void Case0() {
        
        assertThat(getPrefix("ab")).isEqualTo("a");
        assertThat(getPrefix("aab")).isEqualTo("aa");
        assertThat(getPrefix("aaab")).isEqualTo("aaa");
        assertThat(getPrefix("a")).isEqualTo("a");
        assertThat(getPrefix("aa")).isEqualTo("aa");
        assertThat(getPrefix("aba")).isEqualTo("a");
        assertThat(getPrefix("abba")).isEqualTo("a");
        
        assertThat(getSuffix("ab")).isEqualTo("b");
        assertThat(getSuffix("abb")).isEqualTo("bb");
        assertThat(getSuffix("abbb")).isEqualTo("bbb");
        assertThat(getSuffix("b")).isEqualTo("b");
        assertThat(getSuffix("bb")).isEqualTo("bb");
        assertThat(getSuffix("bab")).isEqualTo("b");
        assertThat(getSuffix("baab")).isEqualTo("b");
        
        assertThat(trim("aa", "a", "a")).isEqualTo("");
        
        assertThat(trim("aba", "a", "a")).isEqualTo("b");
        assertThat(trim("abba", "a", "a")).isEqualTo("bb");
        assertThat(trim("abbba", "a", "a")).isEqualTo("bbb");
        
        assertThat(trim("aaba", "aa", "a")).isEqualTo("b");
        assertThat(trim("aabba", "aa", "a")).isEqualTo("bb");
        assertThat(trim("aabbba", "aa", "a")).isEqualTo("bbb");
        
        assertThat(trim("abaa", "a", "aa")).isEqualTo("b");
        assertThat(trim("abbaa", "a", "aa")).isEqualTo("bb");
        assertThat(trim("abbbaa", "a", "aa")).isEqualTo("bbb");
        

    }
    @Test
    void Case1() {
        
        String s = "ca";
      
        var actual = minimumLength(s);
        
        var expected = 2;
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    void Case2() {
        
        String s = "cabaabac";
      
        var actual = minimumLength(s);
        
        var expected = 0;
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    void Case3() {
        
        String s = "aabccabba";
      
        var actual = minimumLength(s);
        
        var expected = 3;
        assertThat(actual).isEqualTo(expected);
    }
    @Test    
    void Case4() {
        
        String s = "bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb";
      
        var actual = minimumLength(s);
        
        var expected = 1;
        assertThat(actual).isEqualTo(expected);
    }
}
