/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yuya.kambayashi;

import java.util.HashSet;
import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

/**
 *
 * @author kamba
 */
public class LC0876Test {
     
    public ListNode middleNode(ListNode head) {
        
        return null;
    }
    @Test
    void Case1() {
        
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        
        var actual = middleNode(head);
        
        ListNode expected = new ListNode(3, new ListNode(4, new ListNode(5)));
        assertThat(actual).isEqualTo(expected);
    }
}
