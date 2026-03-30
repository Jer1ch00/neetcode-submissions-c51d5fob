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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> q = new PriorityQueue<>((a,b) -> a.val-b.val);

        ListNode dummy = new ListNode(0,null);
        ListNode tail = dummy;

        for(ListNode node : lists) {
            if(node != null) {
                q.offer(node);
            }
        }

        while(!q.isEmpty()) {
            tail.next = q.poll();
            tail = tail.next;

            if(tail.next!=null) {
                q.offer(tail.next);
            }
        }

        return dummy.next;
    }
}
