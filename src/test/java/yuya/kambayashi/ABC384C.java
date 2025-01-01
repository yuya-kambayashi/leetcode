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
public class ABC384C {

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

        final int a = sc.nextInt();
        final int b = sc.nextInt();
        final int c = sc.nextInt();
        final int d = sc.nextInt();
        final int e = sc.nextInt();

        List<Person> pp = new ArrayList<>();
        pp.add(new Person("A", 0));
        pp.add(new Person("B", 0));
        pp.add(new Person("C", 0));
        pp.add(new Person("D", 0));
        pp.add(new Person("E", 0));
        pp.add(new Person("AB", 0));
        pp.add(new Person("AC", 0));
        pp.add(new Person("AD", 0));
        pp.add(new Person("AE", 0));
        pp.add(new Person("BC", 0));
        pp.add(new Person("BD", 0));
        pp.add(new Person("BE", 0));
        pp.add(new Person("CD", 0));
        pp.add(new Person("CE", 0));
        pp.add(new Person("DE", 0));
        pp.add(new Person("ABC", 0));
        pp.add(new Person("ABD", 0));
        pp.add(new Person("ABE", 0));
        pp.add(new Person("ACD", 0));
        pp.add(new Person("ACE", 0));
        pp.add(new Person("ADE", 0));
        pp.add(new Person("BCD", 0));
        pp.add(new Person("BCE", 0));
        pp.add(new Person("BDE", 0));
        pp.add(new Person("CDE", 0));
        pp.add(new Person("ABCD", 0));
        pp.add(new Person("ABCE", 0));
        pp.add(new Person("ABDE", 0));
        pp.add(new Person("ACDE", 0));
        pp.add(new Person("BCDE", 0));
        pp.add(new Person("ABCDE", 0));

        for (var p : pp) {
            if (p.name.indexOf("A") != -1) {
                p.point += a;
            }
            if (p.name.indexOf("B") != -1) {
                p.point += b;
            }
            if (p.name.indexOf("C") != -1) {
                p.point += c;
            }
            if (p.name.indexOf("D") != -1) {
                p.point += d;
            }
            if (p.name.indexOf("E") != -1) {
                p.point += e;
            }
        }
        Collections.sort(pp, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                if (p1.point != p2.point) {
                    return Integer.compare(p2.point, p1.point);
                }

                return p1.name.compareTo(p2.name);
            }
        });

        for (var p : pp) {
            System.out.println(p.name);

        }

    }

    static class Person {

        String name;
        int point;

        public Person(String name, int point) {
            this.name = name;
            this.point = point;
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                       400 500 600 700 800
                    """;

        String expected = """
                          ABCDE
                          BCDE
                          ACDE
                          ABDE
                          ABCE
                          ABCD
                          CDE
                          BDE
                          ADE
                          BCE
                          ACE
                          BCD
                          ABE
                          ACD
                          ABD
                          ABC
                          DE
                          CE
                          BE
                          CD
                          AE
                          BD
                          AD
                          BC
                          AC
                          AB
                          E
                          D
                          C
                          B
                          A
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC384C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                       800 800 900 900 1000
                    """;

        String expected = """
                          ABCDE
                          ACDE
                          BCDE
                          ABCE
                          ABDE
                          ABCD
                          CDE
                          ACE
                          ADE
                          BCE
                          BDE
                          ABE
                          ACD
                          BCD
                          ABC
                          ABD
                          CE
                          DE
                          AE
                          BE
                          CD
                          AC
                          AD
                          BC
                          BD
                          AB
                          E
                          C
                          D
                          A
                          B
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC384C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                       128 256 512 1024 2048
                    """;

        String expected = """
                          ABCDE
                          BCDE
                          ACDE
                          CDE
                          ABDE
                          BDE
                          ADE
                          DE
                          ABCE
                          BCE
                          ACE
                          CE
                          ABE
                          BE
                          AE
                          E
                          ABCD
                          BCD
                          ACD
                          CD
                          ABD
                          BD
                          AD
                          D
                          ABC
                          BC
                          AC
                          C
                          AB
                          B
                          A
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC384C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                       
                    """;

        String expected = """
                          
                          """;
        Stream.of(input.split("\\n")).map(s -> s.trim()).forEach(s -> in.inputln(s));
        ABC384C.main(null);
        Stream.of(expected.split("\\n")).map(s -> s.trim()).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
