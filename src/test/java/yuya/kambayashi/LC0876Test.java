/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yuya.kambayashi;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

/**
 *
 * @author kamba
 */
public class LC0876Test {
     
    public ListNode middleNode(ListNode head) {
        
        List<ListNode> nodes = new LinkedList<>();
        
        while(head != null){
            nodes.add(head);
            
            head = head.next;
        }
        
        return nodes.get(nodes.size()/ 2);
    }
    @Test
    void Case1() {
        
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2, a);
        
        
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        
        var actual = middleNode(head);
        
        ListNode expected = new ListNode(3, new ListNode(4, new ListNode(5)));
        assertThat(actual).isEqualTo(expected);
        
        ListNode expected2 = new ListNode(2, new ListNode(4, new ListNode(5)));
        assertThat(actual).isNotEqualTo(expected2);
    }
}
