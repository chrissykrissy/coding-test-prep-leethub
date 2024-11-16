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
    public ListNode partition(ListNode head, int x) {
        ListNode smaller = new ListNode();
        ListNode ds = smaller;
        ListNode rest = new ListNode();
        ListNode dr = rest;
        ListNode temp = head;
        while (temp != null) {
            if (temp.val < x) {
                ds.next = temp;
                ds = ds.next;
            }else {
                dr.next = temp;
                dr = dr.next;
            }
            temp = temp.next;
        }
        dr.next = null; 
        ds.next = rest.next;
        return smaller.next;
    }
}