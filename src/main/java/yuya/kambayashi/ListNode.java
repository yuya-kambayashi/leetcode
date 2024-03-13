/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yuya.kambayashi;

/**
 *
 * @author kamba
 */
public class ListNode {
    int val;
    ListNode next;
    
    ListNode(int x) {
        this.val = x;
        this.next = null;
    }
    ListNode(int x, ListNode next) {
        this.val = x;
        this.next = next;
    }
    
    public boolean equals(Object obj){
        
        ListNode other = (ListNode)obj;
        
        if (this.val != other.val){
            return false;
        }
        
        if (this.next == null && other.next == null){
            return true;
        }
        if (this.next == null || other.next == null){
            return false;
        }
        
        return this.next.equals(other.next);
    }
}
