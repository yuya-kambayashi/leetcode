/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yuya.kambayashi;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

/**
 *
 * @author kamba
 */
public class LC0141Test {
    public boolean hasCycle(ListNode head) {
               
        return false;
    }
    @Test
    void Case1() {
        
        ListNode nodeA = new ListNode(-4);
        ListNode nodeB = new ListNode(0);
        ListNode nodeC = new ListNode(2);
        ListNode nodeD = new ListNode(3);
        
        nodeD.next = nodeC;
        nodeC.next = nodeB;
        nodeB.next = nodeA;
        nodeA.next = nodeC;
        
        var actual = hasCycle(nodeA);
        
        var expected = true;
        assertThat(actual).isEqualTo(expected);
    }
}
