/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null) return;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) { slow = slow.next; fast = fast.next.next; } // slow -> mid point of the list
        ListNode prev = null, cur = slow.next; slow.next = null; //break LL into 2 parts
        while (cur != null) { ListNode nxt = cur.next; cur.next = prev; prev = cur; cur = nxt; }
        ListNode l1 = head, l2 = prev;
        while (l2 != null) {
            ListNode n1 = l1.next, n2 = l2.next;
            l1.next = l2; l2.next = n1;
            l1 = n1; l2 = n2;
        }    
    }
}