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
public class ABC237C {

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

        final String s = sc.next();

        if (isPalindrome(s)) {
            System.out.println("Yes");
            return;
        }

        int countFromTail = 0, countFromHead = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == 'a') {
                countFromTail++;
            } else {
                break;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                countFromHead++;
            } else {
                break;
            }
        }

        int removeFromTail = 0;
        if (countFromTail > countFromHead) {
            removeFromTail = countFromTail - countFromHead;
        }

        String trimed = s.substring(0, s.length() - 1 - removeFromTail + 1);

        String ret = "No";
        if (isPalindrome(trimed)) {
            ret = "Yes";
        }

        System.out.println(ret);
    }

    static boolean isPalindrome(String s) {
        if (s.isBlank()) {
            return false;
        }
        if (s.length() == 1) {
            return true;
        }

        long left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt((int) left) != s.charAt((int) right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
//}

    @Test
    public void Case1() {

        String input = """
                       kasaka
                    """;

        String expected = """
                          Yes
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC237C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //  @Test
    public void Case2() {

        String input = """
                       atcoder
                    """;

        String expected = """
                          No
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC237C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                       php
                    """;

        String expected = """
                          Yes
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC237C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
