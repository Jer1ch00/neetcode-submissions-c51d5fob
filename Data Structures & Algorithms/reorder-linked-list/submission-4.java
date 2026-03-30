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
        if (head == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;
         
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //slow becomes the mid point

        ListNode prev = null;
        ListNode curr = slow.next; // curr becomes the head of the other part of the list
        slow.next = null;// slow is the last node of the first part of the list

        while(curr != null) { // reverse the second half of the list, head of which is curr
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }

        ListNode l1 = head;
        ListNode l2 = prev; // head of the reversed list

        while(l2 != null) {
            ListNode n1 = l1.next;
            ListNode n2 = l2.next;
            l1.next = l2;
            l2.next = n1;

            l1=n1;
            l2=n2;

        }
    }
}
