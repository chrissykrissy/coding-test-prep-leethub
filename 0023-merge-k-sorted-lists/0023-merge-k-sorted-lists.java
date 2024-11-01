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
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode l : lists){
            if(l != null){
                pq.add(l);
            }
        }
        ListNode head = new ListNode();
        ListNode dummy = head;
        while(!pq.isEmpty()){
            ListNode curr = pq.poll();
            dummy.next = curr;
            curr = curr.next;
            if(curr != null){
                pq.add(curr);
            }
            dummy = dummy.next;
        }
        return head.next;
    }
}